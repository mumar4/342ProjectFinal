//
//Name: Abdullah Umar, Netid: mumar4
//Name: Hamzah Quraishi, Netid: hqurai3
//Name: Abdullah Kidwai, Netid: akidwa2
//UIC
//Game342 V4
//Nov 14 2018
//
import java.util.ArrayList;

import java.util.concurrent.ThreadLocalRandom;
import java.util.HashMap;
import java.util.Scanner;

//PARENT CLASS THAT HOLDS INFORMATION FOR BOTH PLAYER AND NPC
public class Character {

	private int ID;
	private String name;
	private String description;
	private ArrayList<Artifact>  inventory = new ArrayList<Artifact>();//these artifacts are held by the player
	static HashMap<Integer, Character> charmap = new HashMap<Integer, Character>();
	protected DecisionMaker DM;
	private ArrayList<String> stolenItemNames= new ArrayList<String>();
	private Place currplace;
	static int numplayers = 0;
	//private IO IO = new IO();


	//COPY CONSTRUCTOR
	Character(Character c){
		this.ID = c.ID;
		this.name = c.name;
		this.description = c.description;

	}

	//----------------------------------------------------
	//----------------------------------------------------
	//CONSTRUCTOR
	Character(int id, String name, String desc){
		this.ID = id;
		this.name = name;
		this.description = desc;			
	}

	//----------------------------------------------------
	//----------------------------------------------------
	//SCANNER CONSTRUCTOR
	Character(Scanner s){
		String line = Game.getCleanLine(s);
		int j = 0;
		int numlines = 0;
		int NPCbehavior = 0;
		int num_chars = 0;
		String char_type = null;
		int placeid = 0;
		Scanner lineScanner = new Scanner(line);
		if(lineScanner.next().equals("CHARACTERS")) {
			num_chars = lineScanner.nextInt();
			int i = 0;
			while(i < num_chars) {

				line = Game.getCleanLine(s);
				lineScanner = new Scanner(line);

				//Getting "PLAYER" or "NPC"
				char_type = lineScanner.next();


				//PLACEID
				placeid = lineScanner.nextInt();

				if(Game.fversion > 4.0) {
					//BEHAVIOR FOR NPC
					NPCbehavior = lineScanner.nextInt();
				}

				//NEXTLINE----------------------------------
				line = Game.getCleanLine(s);
				//System.out.println("The curr line: "+line);
				lineScanner = new Scanner(line);

				//ID
				this.ID = lineScanner.nextInt();


				//NAME
				this.name = lineScanner.nextLine().trim();
				//System.out.println(this.name);


				//NEXTLINE----------------------------------
				line = Game.getCleanLine(s);
				//System.out.println("The curr line: "+line);
				lineScanner = new Scanner(line);

				numlines = lineScanner.nextInt();

				j = 0;
				this.description = " ";
				while(j < numlines) {
					line = Game.getCleanLine(s);
					//System.out.println("The curr line: "+line);
					lineScanner = new Scanner(line);
					this.description = description + lineScanner.nextLine()  +"\n";
					j++;
				}

				this.description = this.description.trim();
				//System.out.println("Description: "+this.description);

				if(char_type.toUpperCase().equals("PLAYER")){
					numplayers = numplayers +1;
					Character p = new Player(ID,name, description);
					//p.print();
					//ADD CHAR TO CHARMAP, ADD CHAR TO COLLECTION OF CHARS(GAME), SET CURRPLACE OF CHAR
					charmap.put(ID, p);
					Game.charlist.add(p);
					if(placeid == 0) {
						//RANDOM place from placelist
		
						//Rand from 0 - 13
						int random = ThreadLocalRandom.current().nextInt(0, Place.placelist.size());


						int randomID = Place.placelist.get(random).getId();

						//p.set_currI(randomID);
						p.set_currI(randomID);
						Place.getPlaceByID(randomID).addChar(p);


					}
					else {
						p.set_currI(placeid);
						//ADD CHAR TO SPECIFIC PLACE
						Place.getPlaceByID(placeid).addChar(p);
					}


				}

				if(char_type.toUpperCase().equals("NPC")){
					NPC n = new NPC(ID,name, description);
					n.setBehavior(NPCbehavior);
					//System.out.println("SET BEHAVIOR:"+n.getBehavior());
					//n.print();
					//ADD CHAR TO CHARMAP, ADD CHAR TO COLLECTION OF CHARS(GAME), SET CURRPLACE OF CHAR
					charmap.put(ID, n);
					//System.out.println("charmap size: "+charmap.size());
					Game.charlist.add(n);
					if(placeid == 0) {

						int random = ThreadLocalRandom.current().nextInt(0, Place.placelist.size());



						int randomID = Place.placelist.get(random).getId();


						n.set_currI(randomID);
						Place.getPlaceByID(randomID).addChar(n);


					}
					else {
						n.set_currI(placeid);
						//ADD CHAR TO SPECIFIC PLACE
						Place.getPlaceByID(placeid).addChar(n);
					}

				}



				i++;
			}
			/*
			while(Character.numplayers < GameTester.num_players) {
				IO.display("ONLY "+Character.numplayers+ " OUT OF "+GameTester.num_players+ " PLAYERS CREATED");
				System.out.print("Enter new player name: ");
				Scanner reader = KeyboardScanner.getKeyboardScanner();
				String name1= IO.getLine(); 
				System.out.print("Enter new player ID: ");
				reader = KeyboardScanner.getKeyboardScanner();
				int id1 = reader.nextInt();
				while(charmap.containsKey(id1)) {
					System.out.print("ID TAKEN. Please enter new player ID: ");
					reader = KeyboardScanner.getKeyboardScanner();
					id1 = reader.nextInt();
				}
				System.out.print("Enter new player description: ");
				reader = KeyboardScanner.getKeyboardScanner();
				//String desc = reader.nextLine();
				String desc = reader.nextLine();

				//ADDING NEW CHAR
				IO.display("ADDING NEW PLAYER");
				Character p = new Player(id1,name1, desc);
				charmap.put(id1, p);
				Game.charlist.add(p);

				int random = ThreadLocalRandom.current().nextInt(0, Place.placelist.size());
				int randomID = Place.placelist.get(random).getId();

				//setting curr place to random place
				p.set_currI(randomID);

				//adding char to place list
				Place.getPlaceByID(randomID).addChar(p);
				Character.numplayers++;
			}*/
		}

		
		Artifact a = new Artifact(s);

	}

	//Version 4.0 or greater
	Character(Scanner s, int version){

	}

	//----------------------------------------------------
	//----------------------------------------------------
	int id() {
		return this.ID;
	}

	//----------------------------------------------------
	//----------------------------------------------------
	String name() {
		return this.name;
	}

	String description() {
		return this.description;
	}

	//----------------------------------------------------
	//----------------------------------------------------
	//add to PLAYER or NPC inventories
	public void addArtifact(Artifact a) {
		this.inventory.add(a);
	}

	//----------------------------------------------------
	//----------------------------------------------------
	//PRINT ENTIRE INVENTORY
	void printInv() {
		
		GameTester.IO.display("INVENTORY: ");
		int tot= 0;
		for(int i = 0; i < inventory.size(); i++) {
			System.out.print(inventory.get(i).name()+ ": ");
			System.out.print("Value = "+inventory.get(i).value()+", ");
			GameTester.IO.display("Weight = "+inventory.get(i).weight()+" kg");
			tot = tot + inventory.get(i).weight();
		}
		GameTester.IO.display("Total Inventory Weight: "+tot);
	}

	//----------------------------------------------------
	//----------------------------------------------------
	//FOR NPC, RETURNS RANDOM ARTIFACT
	public String getRanArt() {
		if(inventory.size() > 0) {
			int random = ThreadLocalRandom.current().nextInt(0, inventory.size());
			return inventory.get(random).name();
		}
		return null;
	}

	//----------------------------------------------------
	//----------------------------------------------------
	//REMOVES ARTIFACT FROM THIS CHAR
	void remove_art(String input) {

		for(int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).name().toUpperCase().equals(input.toUpperCase())) {
				inventory.remove(i);

			}
		}
	}

	//----------------------------------------------------
	//----------------------------------------------------
	//CONTAINS ARTIFACT FROM THIS CHAR
	boolean contains_art(String input) {
		for(int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).name().toUpperCase().equals(input.toUpperCase())) {
				return true;

			}
		}
		return false;
	}

	//----------------------------------------------------
	//----------------------------------------------------
	boolean isDead() {
		if(this.getHP() == 0) {
			return true;
		}
		else
			return false;
	}

	//----------------------------------------------------
	//----------------------------------------------------
	//RETRIEVES ARTIFACT OBJECT GIVEN STRING INPUT
	public Artifact retrieve_art(String input) {
		//System.out.println("EQUALS");

		for(int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).name().toUpperCase().equals(input.toUpperCase())) {

				Artifact inv = inventory.get(i);
				Artifact a;
				if(inventory.get(i) instanceof Scroll){
					Scroll s = new Scroll(inventory.get(i).id(), inventory.get(i).value(), 
							inventory.get(i).weight(), inventory.get(i).name(), 
							inventory.get(i).description(), inventory.get(i).keyPattern() );

					a = s;
					return a;
				}
				else if(inventory.get(i) instanceof Potions){
					Potions p = new Potions(inventory.get(i).id(), inventory.get(i).value(), 
							inventory.get(i).weight(), inventory.get(i).name(), 
							inventory.get(i).description(), inventory.get(i).keyPattern() );

					a = p;
					return a;
				}
				else{
					a = new Artifact(inventory.get(i).id(), inventory.get(i).value(), inventory.get(i).weight(), inventory.get(i).name(), inventory.get(i).description(), inventory.get(i).keyPattern() );
				}
				return a;

			}
		}
		return null;
	}

	//----------------------------------------------------
	//----------------------------------------------------
	//Scanner retrieves placeid, sets starting location. Used for followdirection as well
	public void set_currI(int id) {
		currplace = Place.getPlaceByID(id);

	}

	//----------------------------------------------------
	//----------------------------------------------------
	public void addToStolenList(String stolenName){
		GameTester.IO.display("adding????");
		stolenItemNames.add(stolenName);

	}

	//----------------------------------------------------
	//----------------------------------------------------
	public String returnStolen(){

		if(stolenItemNames.size()!=0){
			String deleting = stolenItemNames.get(stolenItemNames.size()-1);
			//stolenItemNames.get(stolenItemNames.size()-1);
			stolenItemNames.remove(stolenItemNames.size()-1);
			return deleting;
		}
		return null;

	}

	//----------------------------------------------------
	//----------------------------------------------------
	//sets place with place input
	public void set_currP(Place p) {
		currplace = p;

	}


	//----------------------------------------------------
	//----------------------------------------------------
	//RETURNS CURRENT PLACE CHARACTER IS AT
	public Place get_curr() {
		return currplace;

	}

	//----------------------------------------------------
	//----------------------------------------------------
	public void setHP(int h){
		//this.HP = h;
	}
	//----------------------------------------------------
	//----------------------------------------------------
	public void addHP(){
	}

	//----------------------------------------------------
	//----------------------------------------------------
	public void subHP(){
	}

	//----------------------------------------------------
	//----------------------------------------------------
	public int getHP(){
		return 0;
	}

	public int getBehavior() {
		return 0;
	}
	//----------------------------------------------------
	//----------------------------------------------------

	//HASHMAP ID -> CHARACTER 
	static Character getCharacterbyID(int id) {
		return charmap.get(id);//returns char or null

	}


	//Takes from Game.Play - holds curr place, artifacts, for ea. char
	//implements interface DecisionMaker getMove(Char, place)->Move object
	//makeMove() implements that Move object
	//abstract to override in children function
	void makeMove() {;

	}

	//prints all info
	void print() {
		GameTester.IO.display("PRINTING");
		GameTester.IO.display("ID: "+this.ID);
		GameTester.IO.display("Name: "+this.name);
		GameTester.IO.display("Description: "+this.description);

	}

	//prints gameplay relevant info
	void display() {
		GameTester.IO.display("Name: "+this.name);
		GameTester.IO.display("Description: "+this.description);
	}

}
