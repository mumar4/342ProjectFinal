//
//Name: Abdullah Umar, Netid: mumar4
//Name: Hamzah Quraishi, Netid: hqurai3
//Name: Abdullah Kidwai, Netid: akidwa2
//UIC
//Game342 V4
//Nov 14 2018
//

import java.util.*;
import java.util.concurrent.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

//PLACE HOLDS ALL INFO FOR ONE PLACE: DIRECTIONS, ARTIFACTS, AND CHARACTERS IN THAT PLACE
//HOLDS HASHMAP OF ID -> PLACES - HOLDING ALL PLACES, AND LIST OF PLACES 
class Place{

	public int getId() {
		return id;
	}


	private int id;
	private String name;
	private String description;
	private ArrayList<Direction> dirlist = new ArrayList<Direction>();
	private ArrayList<Artifact>  artlist = new ArrayList<Artifact>();
	private ArrayList<Character> charlist = new ArrayList<Character>();
	static HashMap<Integer, Place> placemap = new HashMap<Integer, Place>();
	static ArrayList<Place> placelist= new ArrayList<Place>();
	static Boolean firstTime = true;
	//private IO IO = new IO();

	//Constructor
	Place(int id, String name, String description){
		this.id = id;
		this.name = name;
		this.description = description;

	}

	Place(Place copy){
		this.id = copy.id;
		this.name = copy.name;
		this.description = copy.description;

	}

	//File Parsing Constructor
	Place(Scanner s){
		String line = Game.getCleanLine(s);
		int j = 0;
		int numlines = 0;
		//System.out.println(line);
		int num_places = 0;
		String[] parts = null;
		Scanner lineScanner = new Scanner(line);
		if(lineScanner.next().equals("PLACES")) {
			num_places = lineScanner.nextInt();
			int i = 0;
			while(i < num_places) {

				line = Game.getCleanLine(s);
				lineScanner = new Scanner(line);
				//parts = line.split(" ",2);
				//System.out.println("The curr line: "+line);
				//this.id = Integer.valueOf(parts[0]);
				this.id = lineScanner.nextInt();
				//System.out.println("ID: "+id);

				this.name = lineScanner.nextLine().trim();
				//System.out.println("Name: "+name);

				line = Game.getCleanLine(s);
				//System.out.println("The curr line: "+line);
				lineScanner = new Scanner(line);

				numlines = lineScanner.nextInt();
				//System.out.println("numlines: "+numlines);

				j = 0;
				this.description = " ";
				while(j < numlines) {
					line = Game.getCleanLine(s);
					//System.out.println("The curr line: "+line);
					lineScanner = new Scanner(line);
					this.description = description + lineScanner.nextLine() +"\n";
					j++;
				}

				this.description = this.description.trim();
				//System.out.println("Description: "+this.description);

				Place p = new Place(id,name, description);
				placemap.put(id/*Integer.valueOf(id)*/, p);
				//System.out.println("* "+this.name+ " placed in Hmap!!!");
				Game.addPlace(p);
				Game.placeidlist.add(id);
				Place.placelist.add(p);
				i++;
			}
		}
		//System.out.println(num_places);

		Direction d = new Direction(s);
	}

	//ATTACKS FIRST PLAYER IN PLACE
	public String attackPlayer() {
		String remSave = null;
		for(int i = 0; i < charlist.size(); i++) {
			//looking for a player to attack 
			if (charlist.get(i) instanceof Player) {
				GameTester.IO.display(charlist.get(i).name()+ 
						" has HP: "+charlist.get(i).getHP());
				charlist.get(i).subHP();
				GameTester.IO.display(charlist.get(i).name()+ 
						" NOW has HP: "+charlist.get(i).getHP());

				remSave = charlist.get(i).name();

				//if the player's HP is zero they will be sent to the grave yard
				if(charlist.get(i).getHP() == 0){
					Character.numplayers = Character.numplayers - 1;

					//save the players old place
					Place oldP = charlist.get(i).get_curr();

					//set players new place (WHICH IS GRAVEYARD)
					charlist.get(i).set_currI(500);

					Place newP = getPlaceByID(500);
					newP.addChar(charlist.get(i));
					remSave = charlist.get(i).name();
					oldP.removeChar(charlist.get(i));
					GameTester.IO.display(remSave+" has been sent to the graveyard");

				}
				//returning the name of the character
				return remSave;
			}
		}
		return null;
	}

	//STEAL ITEM FROM FIRST PLAYER IN PLACE TO NPC
	public Artifact stealPlayer() {
		//TRAVERSING CHAR LIST
		for(int i = 0; i < charlist.size(); i++) {
			if (charlist.get(i) instanceof Player) {
				String randArt = charlist.get(i).getRanArt();


				if(randArt != null) {
					GameTester.IO.display(charlist.get(i).name()+ "'s Inventory Before Stealing");
					charlist.get(i).printInv();

					Artifact a = charlist.get(i).retrieve_art(randArt);
					return charlist.get(i).retrieve_art(randArt);


				}

			}
		}
		return null;
	}

	//CHECK IF HEALER AND PLAYER ARE IN THE SAME PLACE
	public Boolean containsHealer(){
		for(int i = 0; i < charlist.size(); i++) {
			if(charlist.get(i) instanceof NPC && charlist.get(i).getBehavior() == 2) {
				return true;
			}
		}
		return false;
	}

	//HEALER WILL HEAL A PLAYER
	public void healPlayer() {
		//TRAVERSING CHAR LIST
		for(int i = 0; i < charlist.size(); i++) {
			if (charlist.get(i) instanceof Player && !charlist.get(i).isDead()) {
				GameTester.IO.display("Hello "+charlist.get(i).name()+" !");
				GameTester.IO.display("I am the Healer. Pick an option: ");
				GameTester.IO.display("Press (1) to regain all health");
				GameTester.IO.display("Press (2) to revive fallen comrade");
				GameTester.IO.display("Press (3) to leave");
				Scanner input = new Scanner(System.in);


				do {
					try {
						System.out.print("Please enter an option: ");

						int input1 = input.nextInt();


						if(input1 == 1) {
							if(charlist.get(i).getHP() == 3) {
								GameTester.IO.display("Your health is already full");
							}
							else
								charlist.get(i).setHP(3);
						}
						if(input1 == 2) {
							input = new Scanner(System.in);
							System.out.print("Enter player name you wish to revive: ");
							String input2 = input.nextLine();
							this.reviveDead(input2);
						}

						break;
					} catch (InputMismatchException e) {
						GameTester.IO.display("Incorrect input, nothing happend....");

					}
					input.nextLine();
				} while(true);

			}
		}

	}

	//----------------------------------------------------
	//----------------------------------------------------
	//REVIVING FROM GRAVEYARD
	public void reviveDead(String deadName) {

		for(int i = 0; i < charlist.size(); i++) {
			//checking if name matches
			if (charlist.get(i).name().toUpperCase().equals(deadName.toUpperCase())){
				if(charlist.get(i).getHP() > 0) {
					GameTester.IO.display("No player to revive...");

				}
				if(charlist.get(i).getHP() == 0) {
					Character.numplayers = Character.numplayers + 1;
					charlist.get(i).setHP(3);
					//move back to entrance hall


					Place oldP = charlist.get(i).get_curr();

					charlist.get(i).set_currI(12);
					Place newP = getPlaceByID(12);
					newP.addChar(charlist.get(i));
					String remSave = charlist.get(i).name();
					GameTester.IO.display(remSave+ " has been revived, the story continues!");
					oldP.removeChar(charlist.get(i));
				}


			}
		}
	}
	
	//----------------------------------------------------
	//----------------------------------------------------
	//Remove specific item from player
	public void remArtPlayer(String a) {
		//TRAVERSING CHAR LIST
		for(int i = 0; i < charlist.size(); i++) {
			if (charlist.get(i) instanceof Player) {
				if(charlist.get(i).contains_art(a)){
					charlist.get(i).addToStolenList(a);
					charlist.get(i).remove_art(a);
				}


			}
		}

	}

	//----------------------------------------------------
	//----------------------------------------------------
	//PRINT ALL PLACES, ARTIFACTS, CHARACTERS 
	public static void printAll() {
		for(Place p: placelist) {
			//p.print();
			for(Character c: p.charlist) {
				//c.print();
				//c.printInv();
			}

		}
	}

	//----------------------------------------------------
	//----------------------------------------------------
	//GET RANDOM DIRECTION 
	public String getRanDir() {
		if(dirlist.size() > 0) {
			int random = ThreadLocalRandom.current().nextInt(0, dirlist.size());
			return dirlist.get(random).getdir();
		}
		return null;
	}

	//----------------------------------------------------
	//----------------------------------------------------
	//GET RANDOM DIRECTION 
	public String getRanArt() {
		if(artlist.size() > 0) {
			int random = ThreadLocalRandom.current().nextInt(0, artlist.size());
			return artlist.get(random).name();
		}
		return null;
	}

	//----------------------------------------------------
	//----------------------------------------------------
	//REMOVE CHARACTER FROM PLACE
	public void removeChar(Character c) {
		for(int i = 0; i < charlist.size(); i++) {
			if (charlist.get(i).id() == c.id()) {
				charlist.remove(i);

			}

		}
	}

	//----------------------------------------------------
	//----------------------------------------------------
	//ADD CHARACTER TO CHAR LIST
	public void addChar(Character c) {
		this.charlist.add(c);
	}

	//----------------------------------------------------
	//----------------------------------------------------
	//ADDS ARTIFACT TO PLACE ARTIFACTS
	public void addArtifact(Artifact a) {
		this.artlist.add(a);
		//this.print();
	}

	//----------------------------------------------------
	//----------------------------------------------------
	//REMOVES ARTIFACT FROM THIS PLACE
	void remove_art(String input) {
		for(int i = 0; i < artlist.size(); i++) {
			if (artlist.get(i).art_match(input)) {
				artlist.remove(i);

			}
		}
	}

	//----------------------------------------------------
	//----------------------------------------------------
	//RETRIEVES ARTIFACT FROM THIS PLACE
	Artifact get_art(String input) {
		for(int i = 0; i < artlist.size(); i++) {
			if (artlist.get(i).art_match(input)) {
				//IO.display("Artifact matched!");
				if(artlist.get(i) instanceof Scroll){
					Scroll s = new Scroll(artlist.get(i));
					return s;
				}
				else if(artlist.get(i) instanceof Potions){
					Potions p = new Potions(artlist.get(i));
					return p;
				}
				else{
					Artifact return_artifact = new Artifact(artlist.get(i));
					return return_artifact;
				}
			}
		}
		return null;
	}

	/*static getPlaceByID( int ) :
	  Place – Returns the Place associated with the given ID number, or null. 
	  This will require that a static collection of all known Places be kept within the Place class. 
	  This method can also be used to detect 
	  if an ID has been used before or not, so that duplicates can be avoided.*/
	static Place getPlaceByID(int id){
		if(firstTime) {
			firstTime = false;
			Place Exit = new Place(1,"Exit","To exit the game...");
			placemap.put(1, Exit);

			Place nowhere = new Place(1,"nowhere","nowhere...");
			placemap.put(0, nowhere);
		}
		return placemap.get(id);//returns place or null, useful when assigning dir obj to place

	}


	//----------------------------------------------------
	//----------------------------------------------------
	//uses a specific artifact on all directions 
	void useKey(Artifact a) {
		for(Direction currdir: dirlist) {
			currdir.useKey(a);
		}	
	}
	
	//----------------------------------------------------
	//----------------------------------------------------
	String name() {
		return this.name;
	}

	//----------------------------------------------------
	//----------------------------------------------------
	String description() {
		return this.description;
	}

	//----------------------------------------------------
	//----------------------------------------------------
	void addDirection(Direction d) {
		this.dirlist.add(d);
	}

	//----------------------------------------------------
	//----------------------------------------------------
	//CHECKS IF USER INPUTTED DIRECTION MATCHES, IF YES THEN RETURN THE TO PLACE
	Place followDirection(String s) {
		for(Direction currdir: dirlist) {
			if (currdir.match(s) && (!currdir.isLocked())){
				//System.out.println("You can travel there!:)...");
				return currdir.Follow();
			}
			if (currdir.match(s) && (currdir.isLocked())){
				GameTester.IO.display(currdir.getdir()+ " is LOCKED!");
			}

		}
		GameTester.IO.display("Staying right here...");
		return this;
	}

	//----------------------------------------------------
	//----------------------------------------------------
	//DISPLAYS IMPORTANT INFO
	void display() {
		GameTester.IO.display("Currently at...");
		GameTester.IO.display("\n"+this.name);
		GameTester.IO.display("Description: "+this.description);
		GameTester.IO.display("\nArtifacts:");
		for(int i = 0; i < artlist.size(); i++) {
			System.out.print(artlist.get(i).name());
			GameTester.IO.display(" : "+artlist.get(i).description());

		}
	}

	//----------------------------------------------------
	//----------------------------------------------------
	//print used in debugging
	/*void print(){
		System.out.println("\n"+this.name);
		System.out.println("Description: "+this.description);
		for(Direction currdir: dirlist) {
			System.out.print(currdir.getdir());
			System.out.print(", lockPattern: "+currdir.getLockPattern()+"\n");

		}
		System.out.println("Artifacts:");
		for(int i = 0; i < artlist.size(); i++) {
			System.out.println(" - yooooooo"+artlist.get(i).name());

		}


	}*/
}
