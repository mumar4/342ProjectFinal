//
//Name: Abdullah Umar, Netid: mumar4
//Name: Hamzah Quraishi, Netid: hqurai3
//Name: Abdullah Kidwai, Netid: akidwa2
//UIC
//Game342 V4
//Nov 14 2018
//

//USE CLASS EXECUTES THE USING OF AN ARTIFACT
public class Use extends Move{

	private IO IO = new IO();
	//CHECKS IF ARTIFACT IS VALID, THEN SENDS TO USE FUNCTION IN ARTIFACT CLASS
	@Override
	void execute(Character c, Place p, String s) {
		// TODO Auto-generated method stub
		String artifactS = s.replace("USE", " ");//strip USE from string
		artifactS = artifactS.trim();
		//IF ARTIFACT EXISTS, USE IT
		if(c.contains_art(artifactS)) {
			IO.display(c.name()+" using "+artifactS);
			
			c.retrieve_art(artifactS).use(c, p);
			
			Artifact a = c.retrieve_art(artifactS);
			if(a instanceof Potions) {
				IO.display("The potions strength is: " + c.getHP());
				c.remove_art(artifactS);
			}

			
		}
		
	}
}
