import java.util.*;
//
//Name: Abdullah Umar, Netid: mumar4
//Name: Hamzah Quraishi, Netid: hqurai3
//Name: Abdullah Kidwai, Netid: akidwa2
//UIC
//Game342 V4
//Nov 14 2018
//
public class Artifact {
	private int valueArtifact;
	private int mobility;
	private String nameArtifact;
	private String desArtifact;
	private int keyPattern;
	private int id;
	//private IO IO = new IO();

	public int getValueArtifact() {
		return valueArtifact;
	}

	public String getNameArtifact() {
		return nameArtifact;
	}

	public void setValueArtifact(int valueArtifact) {
		this.valueArtifact = valueArtifact;
	}

	public void setNameArtifact(String nameArtifact) {
		this.nameArtifact = nameArtifact;
	}

	public int weight(){
		return mobility;
	}

	public int keyPattern(){
		return this.keyPattern;
	}	

	public int id(){
		return this.id;
	}	


	//----------------------------------------------------
	//----------------------------------------------------
	public Artifact(int id, int Val, int Mobility, String Name, String Des, int KeyPattern){ 
		this.valueArtifact = Val;
		this.mobility = Mobility;
		this.nameArtifact = Name;
		this.desArtifact = Des;
		this.keyPattern = KeyPattern;
		this.id = id;

	}

	//----------------------------------------------------
	//----------------------------------------------------
	public Artifact(Artifact copy){ //copy constructor when you delete a key afgter you drop it.
		this.valueArtifact = copy.valueArtifact;
		this.mobility = copy.mobility;
		this.nameArtifact = copy.nameArtifact;
		this.desArtifact = copy.desArtifact;
		this.keyPattern = copy.keyPattern;

	}

	//----------------------------------------------------
	//----------------------------------------------------
	public Artifact(Scanner scan){ //This scanner constructor parses in the artifact 
		int id = 0;
		int placeID = 0;
		int numOfArt = 0;
		int numbered = 0;
		String buffer = " ";
		int numOflines = 0;
		String line = Game.getCleanLine(scan);
		Scanner newScan = new Scanner(line);
		Artifact art;
		if(newScan.next().equals("ARTIFACTS")){
			numOfArt = newScan.nextInt();
			



			int i = 0;
			while(i<numOfArt){
				line = Game.getCleanLine(scan);
				newScan = new Scanner(line);
				placeID = newScan.nextInt();

				
				line = Game.getCleanLine(scan);
				newScan = new Scanner(line);
				id= newScan.nextInt();
				
				
				valueArtifact= newScan.nextInt();
				
				mobility= newScan.nextInt();
				
				keyPattern = newScan.nextInt();    //0 means not a key
				
				nameArtifact = newScan.nextLine().trim();
				



				line = Game.getCleanLine(scan);
				newScan = new Scanner(line);
				numOflines = newScan.nextInt();
				int j=0;

				while(j<numOflines){
					line = Game.getCleanLine(scan);
					newScan = new Scanner(line);
					desArtifact = newScan.nextLine();
					desArtifact = desArtifact.trim();
					j++;
				}
				if(Game.fversion > 3.1) {
					if(Game.fversion == 5.0) {

						if(nameArtifact.toUpperCase().contains("SCROLL")){
							Scroll s = new Scroll(id, valueArtifact, mobility, nameArtifact, desArtifact, keyPattern);
							art = s;

							if(placeID<0) {
								placeID = placeID * -1;
								if(Character.getCharacterbyID(placeID) != null)
									Character.getCharacterbyID(placeID).addArtifact(art);
								//Character.getCharacterbyID(placeID).printInv();

							}
							else if(placeID == 0) {
								Collections.shuffle(Game.placelist);
								Place.getPlaceByID(0).addArtifact(art);
							}
							else {
								Place.getPlaceByID(placeID).addArtifact(art);
							}

						}
						else if(nameArtifact.toUpperCase().contains("POTION")){
							Potions p = new Potions(id, valueArtifact, mobility, nameArtifact, desArtifact, keyPattern);
							art = p;
							
							if(placeID<0) {
								placeID = placeID * -1;
								if(Character.getCharacterbyID(placeID) != null)
									Character.getCharacterbyID(placeID).addArtifact(art);
								//Character.getCharacterbyID(placeID).printInv();

							}
							else if(placeID == 0) {
								Collections.shuffle(Game.placelist);
								Place.getPlaceByID(0).addArtifact(art);
							}
							else {
								Place.getPlaceByID(placeID).addArtifact(art);
							}

						}

						else{
							art = new Artifact(id, valueArtifact, mobility, nameArtifact, desArtifact, keyPattern);



							
							if(placeID<0) {
								placeID = placeID * -1;
								if(Character.getCharacterbyID(placeID) != null)
									Character.getCharacterbyID(placeID).addArtifact(art);
								//Character.getCharacterbyID(placeID).printInv();

							}
							else if(placeID == 0) {
								Collections.shuffle(Game.placelist);
								Place.getPlaceByID(0).addArtifact(art);
							}
							else {
								Place.getPlaceByID(placeID).addArtifact(art);
							}
						}
					}
					else if(Game.fversion == 4.0) {
						art = new Artifact(id, valueArtifact, mobility, nameArtifact, desArtifact, keyPattern);


						if(placeID<0) {
							placeID = placeID * -1;
							if(Character.getCharacterbyID(placeID) != null)
								Character.getCharacterbyID(placeID).addArtifact(art);
							//Character.getCharacterbyID(placeID).printInv();

						}
						else if(placeID == 0) {
							Collections.shuffle(Game.placelist);
							Place.getPlaceByID(0).addArtifact(art);
						}
						else {
							Place.getPlaceByID(placeID).addArtifact(art);
						}
					}

				}
				else {
					this.desArtifact = this.desArtifact.trim();

					//CREATING NEW ARTIFACT TO BE ADDED TO SPECIFIED PLACE'S ARTIFACT LIST
					Artifact a = new Artifact(id, valueArtifact, mobility, nameArtifact, desArtifact, keyPattern);

					Place.getPlaceByID(placeID).addArtifact(a);
				}
				i++;
			}

		}
	}

	//----------------------------------------------------
	//----------------------------------------------------
	public int value(){  //returns the value of the artifact
		return this.valueArtifact;
	}

	//----------------------------------------------------
	//----------------------------------------------------
	public int size(){   //returns the size of the artifact
		return this.mobility;
	}

	//----------------------------------------------------
	//----------------------------------------------------
	public String name(){ //returns the name of the artifact
		return this.nameArtifact;
	}

	//----------------------------------------------------
	//----------------------------------------------------
	public String description(){ //returns the description of the artifact
		return this.desArtifact;
	}

	//----------------------------------------------------
	//----------------------------------------------------
	public void use(){ //checks to see if the key is being used

		Game.getCurrentPlace().useKey(this);
		//Place.useKey(this);
	}

	public void use(Character c, Place p){
		p.useKey(this);

	}

	//----------------------------------------------------
	//----------------------------------------------------
	public int getPattern(){   //This returns the key pattern
		return this.keyPattern;
	}
	//----------------------------------------------------
	//----------------------------------------------------
	public void something(){
	}

	//----------------------------------------------------
	//----------------------------------------------------

	Boolean art_match(String input) {
		String input1 = input.replace("GET", " ");
		input1 = input1.trim();
		if(input1.toUpperCase().equals(this.nameArtifact.toUpperCase())) {
			return true;
		}
		else return false;

	}
	//----------------------------------------------------
	//----------------------------------------------------



}

