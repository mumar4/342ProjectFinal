//
//Name: Abdullah Umar, Netid: mumar4
//Name: Hamzah Quraishi, Netid: hqurai3
//Name: Abdullah Kidwai, Netid: akidwa2
//UIC
//Game342 V4
//Nov 14 2018
//

//DROP, A CHILD OF MOVE. DROPS A GIVEN ARTIFACT USER INPUTS
public class Drop extends Move{

	//CHECKS IF CHAR CONTAINS ARTIFACT
	//IF THEY DO, THEN REMOVE ARTIFACT FROM PLAYER LIST 
	//ADD ARTIFACT TO PLACE LIST
	private IO IO = new IO();
	@Override
	void execute(Character c, Place p, String input) {
		// TODO Auto-generated method stub
		String artifactS = input.replace("DROP", " ");//strip DROP from string
		artifactS = artifactS.trim();
		if (c.contains_art(artifactS)) {
			Artifact a = c.retrieve_art(artifactS);
			c.remove_art(artifactS);
		
			if(a != null) {
				IO.display(c.name()+" drops "+a.name()+ " at " +p.name());
				p.addArtifact(a);
			}
		}
		
		
	}

}
