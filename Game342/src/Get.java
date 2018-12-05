//
//Name: Abdullah Umar, Netid: mumar4
//Name: Hamzah Quraishi, Netid: hqurai3
//Name: Abdullah Kidwai, Netid: akidwa2
//UIC
//Game342 V4
//Nov 14 2018
//

//GETS ARTIFACT - ACTIONS FOR BOTH PLAYER AND NPC
public class Get extends Move {

	private IO IO = new IO();
	//GETS ARTIFACT FROM PLACE, IF IT EXISTS
	//CREATES NEW ARTIFACT AND ADDS TO CHARACTER INVENTORY
	//REMOVES FROM PLACE INVENTORY
	void execute(Character c, Place p, String input) {
		IO.display(input);
		Artifact a = p.get_art(input);
		if(a != null) {
			
			if(a.weight() >= 0) {
			IO.display(c.name()+" obtains "+a.name()+"!");

			//add artifact from place to chars inventory 
			c.addArtifact(a);
			
			//remove artifact from that place
			p.remove_art(input);
			}
			else {
				IO.display(c.name()+" CANNOT obtain "+a.name()+":(");

			}
		}
		
	}

}
