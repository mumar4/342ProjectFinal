//
//Name: Abdullah Umar, Netid: mumar4
//Name: Hamzah Quraishi, Netid: hqurai3
//Name: Abdullah Kidwai, Netid: akidwa2
//UIC
//Game342 V4
//Nov 14 2018
//
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


//AI makes move for NPCS using DecisionMaker interface
public class AI implements DecisionMaker{
	
	//protected io;
	//protected UserInterface IO;
	//private IO IO = new IO();
	//AGGRESSIVE: GO, GET, DROP, USE, ATTACK, STEAL
	
	//CONTAINS MOVES: GO, GET, DROP, USE
	@Override
	public Move getMove(Character c, Place p) {
		//AI ONLY GET, DROP, USE
		p.display();
		NPC n = (NPC) c;
		int random = ThreadLocalRandom.current().nextInt(0, 4);//0,4
		String dir = null;
		if(n.getBehavior() == 0) {
			//0 - 3
			random = ThreadLocalRandom.current().nextInt(0, 4);//0,4
			//random = 0;
			dir = null;
			//GO
			if(random == 0) {
				dir = p.getRanDir();
				if(dir != null) {
					Go go = new Go();
					go.execute(c,p, dir);
				}
			}
		
			//GET
			else if(random == 1) {
				dir = p.getRanArt();
				if(dir != null) {
					Get get = new Get();
					get.execute(c, p, dir);
				}
			}
		
			//DROP
			else if(random == 2) {
				dir = c.getRanArt();
				if(dir != null) {
					dir = "DROP "+dir;
					//System.out.println("DIR: "+dir);
					Drop d = new Drop();
					d.execute(c, p, dir);
				}
			}
			//USE
			else if(random == 3) {
				dir = c.getRanArt();
				if(dir != null) {
					dir = "USE "+dir;
					//.display("USE: "+dir);
					Use u = new Use();
					u.execute(c, p, dir);
				}
			}
		}
		//----------------------------------------------------
		//----------------------------------------------------
		//AGGRESSIVE: GO, ATTACK, STEAL 
		if(n.getBehavior() == 1) {
			//0 - 2
			random = ThreadLocalRandom.current().nextInt(0, 3);//0,3
			//THE WHOLE INPUT
			
			//GO
			if(random == 0) {
				dir = p.getRanDir();
				if(dir != null) {
					Go go = new Go();
					go.execute(c,p, dir);
				}
			}
			
			//ATTACK
			if(random == 1) {
				Attack a = new Attack(); 
				a.execute(c, p, dir);
			}
			if(random == 2) {
				Steal s = new Steal();
				s.execute(c, p, dir);
			}
		
		}
		//----------------------------------------------------
		//----------------------------------------------------
		//HEALER BEHAVIOR NPC: HEAL/REVIVE
		if(n.getBehavior() == 2) {
			GameTester.IO.display("Im a healer behavior IO NPC");
			Heal h = new Heal();
			h.execute(c, p, dir);
			
			
		}
		
		

		return null;
	}

	
}
