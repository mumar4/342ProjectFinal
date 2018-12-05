//
//Name: Abdullah Umar, Netid: mumar4
//Name: Hamzah Quraishi, Netid: hqurai3
//Name: Abdullah Kidwai, Netid: akidwa2
//UIC
//Game342 V4
//Nov 14 2018
//

import java.util.Scanner;

//IMPLEMENTS ALL PLAYER MOVES  - GO, GET, DROP, USE, EXIT/QUIT , LOOK, INVE
public class UI implements DecisionMaker {
	//private IO IO = new IO();
	@Override
	public Move getMove(Character c, Place p) {
		// TODO Auto-generated method stub
		
		p.display();
		
		Scanner reader = KeyboardScanner.getKeyboardScanner();
		if(Character.numplayers == 0) {
			GameTester.IO.display("ALL PLAYERS ARE DEAD, THE GAME IS OVER...");
			System.exit(0);

		}
		if(p.name().equals("Tomb of the King")) {
			GameTester.IO.display("You have WON THE GAME!!!!");
			System.exit(0);
		}
		GameTester.IO.display("\n");
		if(c.getHP() == 0){
			GameTester.IO.display("This player is dead and cannot do anything unless the player gets revived");
		}
		else {
			System.out.println();
			//FUNCTION TO CHECK IF HELPER NPC IN SAME P
			
			GameTester.IO.display("Enter a command: ");

			String direction = GameTester.IO.getLine();

			String delims = " ";
			String[] tokens = direction.split(delims);
			if (tokens[0].toUpperCase().equals("EXIT") || tokens[0].equals("QUIT")) {
				//player is out of the game
			}

			//LOOK
			if (tokens[0].toUpperCase().equals("LOOK")) {
				Look l = new Look();
				l.execute(c, p, direction);
			}

			//GET
			//transfers artifact to players inventory if possible  (Place class to Game class)
			if (tokens[0].toUpperCase().equals("GET") && tokens.length > 1) {
				direction = direction.toUpperCase();
				//send to move to execute
				Get get = new Get();
				get.execute(c, p, direction);


			}

			//DROP - drops specified item in currplace
			if (tokens[0].toUpperCase().equals("DROP") && tokens.length > 1) {
				direction = direction.toUpperCase();
				Drop d = new Drop();
				d.execute(c, p, direction);
			}

			//USE
			if (tokens[0].toUpperCase().equals("USE") && tokens.length > 1) {
				if (tokens[1].trim().toUpperCase().equals("PURPLE POTION") || tokens[1].trim().toUpperCase().contains("POTION")) {
					GameTester.IO.display("this heals the HP");
				}
				direction = direction.toUpperCase();
				Use u = new Use();
				u.execute(c, p, direction);
			}

			//INVE
			if (tokens[0].toUpperCase().equals("INVE") || tokens[0].toUpperCase().equals("INVENTORY")) {
			/*System.out.println(inventory.size());
			this.printInv();*/
				Inventory i = new Inventory();
				i.execute(c, p, direction);
			}

			//GO
			if (tokens[0].toUpperCase().equals("GO") && tokens.length > 1) {
				Go go = new Go();
				go.execute(c, p, tokens[1]);

			}
			//GO
			if (tokens[0].toUpperCase().equals("EXIT") || tokens[0].toUpperCase().equals("QUIT")) {
				Exit e = new Exit();
				e.execute(c, p, direction);

			}
		}

		return null;
	}
}

