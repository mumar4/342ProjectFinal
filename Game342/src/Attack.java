//
//Name: Abdullah Umar, Netid: mumar4
//Name: Hamzah Quraishi, Netid: hqurai3
//Name: Abdullah Kidwai, Netid: akidwa2
//UIC
//Game342 V4
//Nov 14 2018
//
public class Attack extends Move{

	//IF PLAYER AND NPC ATTACKER ARE IN SAME AREA 
	//NPC ATTACKS, PLAYER LOSES HP
	//private IO IO = new IO();
	@Override
	void execute(Character c, Place p, String s) {
		// TODO Auto-generated method stub
		//p we can see if player is in same area
		//subtract 1 hp from player
		
		String pname = p.attackPlayer();
		if(pname != null) {
			GameTester.IO.display(c.name() + " ATTACKED "+pname+" !!!");
		}
		else {
			GameTester.IO.display(c.name() + " ATTACKS the air");
		}
	}

}
