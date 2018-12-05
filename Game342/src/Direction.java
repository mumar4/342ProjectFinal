//
//Name: Abdullah Umar, Netid: mumar4
//Name: Hamzah Quraishi, Netid: hqurai3
//Name: Abdullah Kidwai, Netid: akidwa2
//UIC
//Game342 V4
//Nov 14 2018
//
import java.util.Scanner;

//DIRECTION INFO FOR EACH DIRECTION
class Direction{

	private int id;
	private Place from;
	private Place to;
	private DirType dir;
	private int lock;
	//for key
	private int lockPattern;
	public int check;
	//private IO IO = new IO();

	//constructor
	Direction(int ID, Place from, Place to, String d, int lock, int lp){
		this.id = ID;
		this.from = from;
		this.to = to;
		this.dir = dir.valueOf(DirType.class, d);//converts string d to enumerated type aka DirType
		this.lock = lock;
		this.lockPattern = lp;

	}

	//----------------------------------------------------
	//----------------------------------------------------
	//FILE PARSER FOR DIRECTIONS
	Direction(Scanner s){
		String line = Game.getCleanLine(s);
		int j = 0;
		int placeid = 0;
		int num_dir = 0;

		Scanner lineScanner = new Scanner(line);
		//System.out.println("num_dir..." +lineScanner.next());
		if(lineScanner.next().equals("DIRECTIONS")) {
			num_dir = lineScanner.nextInt();
			//System.out.println("num_dir..." +num_dir);

			int i = 0;
			while(i < num_dir) {

				line = Game.getCleanLine(s);
				//System.out.println("\nline: "+line);
				lineScanner = new Scanner(line);

				//id
				this.id = lineScanner.nextInt();

				//FROM
				placeid = lineScanner.nextInt();
				//System.out.println("PlaceID: "+placeid);
				from = Place.getPlaceByID(placeid);
				//System.out.println("From: "+this.from.name());

				//Direction
				String dire = lineScanner.next();
				this.dir = dir.valueOf(DirType.class, dire);
				//System.out.println("Dir: "+dire);
				//dire = this.dir.toString();

				//TO
				int placeid1;
				placeid1 = lineScanner.nextInt();
				//System.out.println("PlaceID1: "+placeid1);
				if(placeid1 <= 0) {
					this.lock = 1;
					int placeid2 = placeid1*-1;
					//System.out.println("PlaceID2: "+placeid2);
					this.to = Place.getPlaceByID(placeid2);
					//System.out.println("TO NAME: "+Place.getPlaceByID(placeid2).name());
					//System.out.println("TO NAME11: "+to.name());


				}
				else {
					this.lock = 0;
					//System.out.println("helloooooo");
					this.to = Place.getPlaceByID(placeid1);
					//System.out.println("TO NAME2: "+Place.getPlaceByID(placeid1).name());
					//System.out.println("TO NAME22: "+to.name());


				}
				

				//LOCKPattern
				this.lockPattern = lineScanner.nextInt();
				//System.out.println("Lockpattern: "+this.lockPattern);

				Direction d = new Direction(id,from,to,dire,lock,lockPattern);

				Place.getPlaceByID(placeid).addDirection(d);


				i++;
			}
		}
		if(Game.fversion > 3.1) {
			Character c = new Character(s);
		}
		else {
			GameTester.IO.display("SCAN ART");
			Artifact a = new Artifact(s);
		}
	}

	//----------------------------------------------------
	//----------------------------------------------------
	//CONTAINS CONSTANT DIRECTION TEXT AND ABBREVIATION TO BE COMPARED TO USER INPUT
	private enum DirType{
		NONE("None","None"), 
		N("North", "N"), 
		S("South", "S"), E("East", "E"),W("West", "W"), U("Under", "U"), D("Down","D"),
		NE("Northeast", "NE"), NW("Northwest", "NW"),SE("Southeast", "SE"), SW("Southwest", "SW"),
		NNE("North-northeast", "NNE"), NNW("North-northwest", "NNW"), ENE("East-northeast", "ENE"), WNW("West-northwest", "WNW"),
		ESE("East-southeast", "ESE"), WSW("West-southwest", "WSW"), SSE("South-southeast", "SSE"),SSW("South-southwest","SSW");

		private final String text;
		private final String abbreviation;


		private DirType(String text, String abbreviation){
			this.text = text;
			this.abbreviation = abbreviation;

		}

		public String toString(){

			return this.text;

		}

		private Boolean match(String s) {
			/*if(s.toLowerCase().equals(text.toLowerCase()) || s.toLowerCase().equals(abbreviation.toLowerCase())) {
			  return true;
			  }*/

			String delims = " ";
			String[] tokens = s.split(delims);
			for(String t: tokens) {
				if (t.toLowerCase().equals(text.toLowerCase()) || t.toLowerCase().equals(abbreviation.toLowerCase())) {
					return true;
				}	
			}

			return false;

		}
	}

	//----------------------------------------------------
	//----------------------------------------------------
	//SET LOCK PATTERN
	void setLockPattern(int lp) {
		this.lockPattern = lp;
	}

	//----------------------------------------------------
	//----------------------------------------------------
	//GIVEN AN ARTIFACT, USE THE KEY ON THIS DIRECTION
	void useKey(Artifact a) {

		if (this.lock == 1 && (a.keyPattern() > 0 ) && a.keyPattern() == this.lockPattern) {
			this.unlock();
			GameTester.IO.display("Direction "+dir.toString()+ " UNLOCKED from "+this.from.name()+ " using "+a.name()+" : " );
		}
		else {
			GameTester.IO.display("Nothing happened....");
		}

	}

	//SENDS TO MATCH FUNCTION IN DIRTYPE, CHECKS IF MATCHES EITHER TEXT OR ABBREVIATION
	Boolean match(String s) {


		return dir.match(s);


	}


	//----------------------------------------------------
	//----------------------------------------------------
	//GETS THE DIRECTION IN STRING
	String getdir() {
		return this.dir.toString();
	}

	//----------------------------------------------------
	//----------------------------------------------------
	void lock() {
		this.lock = 1;
		//System.out.println(this.to.name+ " has been locked");
	}

	//----------------------------------------------------
	//----------------------------------------------------
	void unlock() {
		this.lock = 0;
		//System.out.println(this.to.name+ " has been unlocked");
	}

	//----------------------------------------------------
	//----------------------------------------------------
	int getLock() {
		return this.lock;
	}

	//----------------------------------------------------
	//----------------------------------------------------
	int getLockPattern() {
		return this.lockPattern;
	}

	//----------------------------------------------------
	//----------------------------------------------------
	Boolean isLocked() {
		if(this.lock == 1) 
			return true;
		else 
			return false;
	}

	//----------------------------------------------------
	//----------------------------------------------------
	//CHECKS LOCK VALLUE AND FOLLOWS ACCORDINGLY
	Place Follow() {
		if(this.lock == 0) {
			return this.to;
		}
		else {
			return this.from;
		}
	}

	//PRINT OUT DIRECTION INFO
	void print() {
		GameTester.IO.display("Direction Information:");
		GameTester.IO.display("ID: " +this.id);
		GameTester.IO.display("Lock Status: "+this.lock);

	}

}
