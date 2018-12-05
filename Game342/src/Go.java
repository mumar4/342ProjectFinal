//
//Name: Abdullah Umar, Netid: mumar4
//Name: Hamzah Quraishi, Netid: hqurai3
//Name: Abdullah Kidwai, Netid: akidwa2
//UIC
//Game342 V4
//Nov 14 2018
//

//GO TO ANY DIRECTION - PLAYER AND NPC
public class Go extends Move  {
	
	private IO IO = new IO();
	public Go() {
		// TODO Auto-generated constructor stub
	}

	//overloading method
	void execute(Character c, Place p, String dir) {
		IO.display("\n");
		Place To = p.followDirection(dir);

		//PREVENTS NPC FROM EXITING GAME
		if(c instanceof NPC ) {
			if( To.name().equals("Graveyard")){
				IO.display("Dark energy may not travel to graveyard");
				return;
			}
			if( To.name().equals("Tomb of the King")){
				IO.display("The dungeon starts to shake uncontrollably");
				IO.display("As the dungeon falls into an abyss");
				IO.display(c.name()+" Enters a portal AND WINS THE GAME!!");
				System.exit(0);
			}

			if(p.followDirection(dir).name().toUpperCase().equals("EXIT")){
				IO.display(c.name() + " is an NPC and cannot exit the game");
				return;
			}
		}
		//remove from old place
		p.removeChar(c);
		
		//set new current place for char
		c.set_currP(p.followDirection(dir));

		//add char to new place
		p.followDirection(dir).addChar(c);
		
		IO.display(c.name()+" goes to "+p.followDirection(dir).name());

		//IF PLACE PLAYER IS GOING TO IS EXIT OR QUIT, LEAVE THE GAME
		if(c instanceof Player) {
			
			if( To.name().equals("Tomb of the King")){
				IO.display("The dungeon starts to shake uncontrollably");
				IO.display("As the dungeon falls into an abyss");
				IO.display("You enter a portal AND WIN THE GAME!!");
				System.exit(0);
			}
			if (p.followDirection(dir).name().toUpperCase().equals("EXIT") || p.followDirection(dir).name().toUpperCase().equals("QUIT")){
				IO.display("A PLAYER HAS EXITED THE GAME...");
				IO.display("EXITING SIMULATION, you are free to go... ");
			    System.exit(0);
			}
		}
		
		//DISPLAYING CURR LOCATION
		c.get_curr().display();
		// TODO Auto-generated method stub			
	}

}
