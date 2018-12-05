//
//Name: Abdullah Umar, Netid: mumar4
//Name: Hamzah Quraishi, Netid: hqurai3
//Name: Abdullah Kidwai, Netid: akidwa2
//UIC
//Game342 V4
//Nov 14 2018
//

//NPC steals a random artifact from a player
public class Steal extends Move {

	private IO IO = new IO();
	//LOOK AT PLACE IF PLAYER EXISTS. STEAL A RANDOM ITEM FROM PLAYER
	// PUT IN INVENTORY
	@Override
	void execute(Character c, Place p, String s) {
		// TODO Auto-generated method stub
	
		//takes artifact from player 
		Artifact a = p.stealPlayer();
		if(a != null) {

			String artname = a.name();

			//removing art from player
			p.remArtPlayer(artname);

			//add stolen art to NPC
			c.addArtifact(a);

			

		}
		else {
			IO.display(c.name()+ "STEALS from nobody");
		}
		
	}
	

}
