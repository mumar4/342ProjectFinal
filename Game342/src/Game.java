//
//Name: Abdullah Umar, Netid: mumar4
//Name: Hamzah Quraishi, Netid: hqurai3
//Name: Abdullah Kidwai, Netid: akidwa2
//UIC
//Game342 V4
//Nov 14 2018
//
import java.io.ObjectInputStream;

import java.util.ArrayList;
import java.util.Scanner;

//GAME GETS GAMENAME AND RUNS THE GAME IN A LOOP. SUPPORTS BACKWARDS COMPATABILITY
public class Game {

	static ArrayList<Place> placelist= new ArrayList<Place>();
	static ArrayList<Character> charlist = new ArrayList<Character>();
	static ArrayList<Integer> placeidlist = new ArrayList<Integer>();
	private ArrayList<Artifact>  inventory = new ArrayList<Artifact>();//these artifacts are held by the player
	private String gamename;
	private int exit_check;
	static Place currplace;
	static double fversion;
	//private IO IO = new IO();

	//Game constructor
	Game(String s){
		this.gamename = s;
		this.exit_check = 0;
	}

	//----------------------------------------------------
	//----------------------------------------------------
	//gets next non-empty or comment line and returns it trimmed 
	public static String getCleanLine(Scanner s) {
		String line;
		String[] parts;
		String info = null;

		while(s.hasNextLine()) {//while not eof
			line = s.nextLine();

			if(line.startsWith("//")){
				continue;
			}
			else {
				if(line.length() > 0) {

					String delim = "//";
					parts = line.split("//");
					line = parts[0];
					info = line.trim();


					if (info.length() > 0) 
						return info;

				}
			}
		}

		return null;

	}

	//Parses file
	Game(Scanner s){
		String line = getCleanLine(s);
		//System.out.println(line);
		String gname;
		Scanner lineScanner = new Scanner(line);
		if(lineScanner.next().equals("GDF")) {
			Game.fversion= lineScanner.nextDouble();
			//System.out.println("VEEEERSIIION"+Game.fversion);
			{
				gname = lineScanner.nextLine();
				this.gamename = gname.trim();
				this.exit_check = 0;
			}
		}
		Place p = new Place(s);

	}

	//----------------------------------------------------
	//----------------------------------------------------
	//can be called anywhere, return current place
	static Place getCurrentPlace() {
		return currplace;
	}

	//----------------------------------------------------
	//----------------------------------------------------
	//adds place to place list
	static void addPlace(Place p){
		placelist.add(p);
	}

	//----------------------------------------------------
	//----------------------------------------------------
	//FOR 3.1 OR BELOW, ADDES TO USER INVENTORY
	void addArtifact(Artifact a) {
		this.inventory.add(a);
	}

	//----------------------------------------------------
	//----------------------------------------------------
	//PRINT GAME INFO
	void print(){
		GameTester.IO.display("---------------------------Game Information--------------------------\n");
		GameTester.IO.display("TITLE:                       \n"+this.gamename);
		GameTester.IO.display("PLACES YOU CAN TRAVERSE: \n");
		for(Place currplace: Place.placelist) {
			GameTester.IO.display(currplace.name());
			GameTester.IO.display(currplace.description()+"\n");

		}
	}

	//----------------------------------------------------
	//----------------------------------------------------
	//prints out inventory
	void printInv() {
		int tot= 0;
		for(int i = 0; i < inventory.size(); i++) {
			GameTester.IO.display(inventory.get(i).name()+ ": ");
			GameTester.IO.display("Value = "+inventory.get(i).value()+", ");
			GameTester.IO.display("Weight = "+inventory.get(i).weight()+" kg");
			tot = tot + inventory.get(i).weight();
		}
		GameTester.IO.display("Total Weight: "+tot+" kg");

	}

	//----------------------------------------------------
	//----------------------------------------------------
	//PRINTS ALL CHARACTERS IN THE GAME ALONG WITH THEIR INVENTORY 
	void printChars() {
		int tot= 0;
		for(int i = 0; i < charlist.size(); i++) {
			GameTester.IO.display(charlist.get(i).name()+ ": ");
			GameTester.IO.display("Value = "+inventory.get(i).value()+", ");
			GameTester.IO.display("Weight = "+inventory.get(i).weight()+" kg");
			tot = tot + inventory.get(i).weight();
		}
	}

	//----------------------------------------------------
	//----------------------------------------------------
	//PLAYS GAME. IF VERSION ABOVE 3.1 WILL RUN THROUGH EACH CHAR TO MAKE MOVE, ELSE IT JUST PLAYS VERSION 3.1 WITH JUST USER
	void play() {
		if(Game.fversion > 3.1) {
			exit_check = 1;
			while(exit_check == 1) {
				for(int i = 0; i < charlist.size(); i ++) {
					GameTester.IO.display("\n");
					GameTester.IO.display("-------------------------------------------------------------");
					GameTester.IO.display("CURRENT NUMBER OF PLAYERS: "+Character.numplayers);
					GameTester.IO.display("Make your move: " +charlist.get(i).name());
					if(charlist.get(i) instanceof Player) {
						GameTester.IO.display("Current HP: " +charlist.get(i).getHP());
					}
					charlist.get(i).printInv();

					charlist.get(i).makeMove();
					GameTester.IO.display("-------------------------------------------------------------");

				}
			}
		}
		else {
			//FOR 3.1 GDF
			currplace = Place.getPlaceByID(12);
			GameTester.IO.display("\nWHERE YOUR JOURNEY BEGINS. GO! Let the LEGEND come back to LIFE: ");
			currplace.display();
			while(this.exit_check == 0) {

				Scanner reader = KeyboardScanner.getKeyboardScanner();

				GameTester.IO.display("Enter a command: ");

				String direction = reader.nextLine(); // Scans the next token of the input as an string
				if(direction.equals("EXIT") || direction.equals("QUIT")) {
					GameTester.IO.display("EXITING SIMULATION, you are free to go... ");
					return;
				}

				String delims = " ";
				String[] tokens = direction.split(delims);
				if(tokens[0].toUpperCase().equals("EXIT") || tokens[0].equals("QUIT")) {
					GameTester.IO.display("EXITING SIMULATION, you are free to go... ");
					return;
				}

				//LOOK
				if (tokens[0].toUpperCase().equals("LOOK")) {
					currplace.display();
				}

				//GET
				//transfers artifact to players inventory if possible  (Place class to Game class)
				if (tokens[0].toUpperCase().equals("GET") && tokens.length > 1) {
					direction = direction.toUpperCase();
					Artifact a = currplace.get_art(direction);
					if(a != null) {
						GameTester.IO.display(a.name()+" obtained!");
						this.addArtifact(a);
						currplace.remove_art(direction);
					}

				} 

				//DROP - drops specified item in currplace
				if (tokens[0].toUpperCase().equals("DROP") && tokens.length > 1) {
					//System.out.println("in1");
					direction = direction.toUpperCase();
					String artifactS = direction.replace("DROP", " ");//strip DROP from string
					artifactS = artifactS.trim();
					for(int i = 0; i < inventory.size(); i++) {//finding in inv
						if (artifactS.equals(inventory.get(i).name().toUpperCase())) {
							//System.out.println("here1");
							Artifact a = new Artifact(inventory.get(i));
							currplace.addArtifact(a);
							inventory.remove(i);

						}
					}	
				} 

				//USE
				if (tokens[0].toUpperCase().equals("USE") && tokens.length > 1) {
					GameTester.IO.display("in1");
					direction = direction.toUpperCase();
					GameTester.IO.display("DIRECTION: "+direction);
					String artifactS = direction.replace("USE", " ");//strip DROP from string
					artifactS = artifactS.trim();
					for(int i = 0; i < inventory.size(); i++) {//finding in inv, use item
						if (artifactS.equals(inventory.get(i).name().toUpperCase())) {
							GameTester.IO.display("here2");
							inventory.get(i).use();

						}
					}	
				} 

				//INVE
				if (tokens[0].toUpperCase().equals("INVE") || tokens[0].toUpperCase().equals("INVENTORY")){
					System.out.println(inventory.size());
					this.printInv();
				} 			
				else {
					GameTester.IO.display("\n");
					currplace = currplace.followDirection(direction);
				}


				//if it matches travel in that direction

				//currplace.print();
				if(currplace.name().equals("Exit")) {
					GameTester.IO.display("EXITING SIMULATION, you are free to go... ");
					return;
				}


			}

		}}}

