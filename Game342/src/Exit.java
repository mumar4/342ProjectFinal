//
//Name: Abdullah Umar, Netid: mumar4
//Name: Hamzah Quraishi, Netid: hqurai3
//Name: Abdullah Kidwai, Netid: akidwa2
//UIC
//Game342 V4
//Nov 14 2018
//

//EXITS - ONLY FOR PLAYER
public class Exit extends Move{
	private IO IO = new IO();
	@Override
	void execute(Character c, Place p, String s) {
		// TODO Auto-generated method stub
	    IO.display("EXITING SIMULATION, you are free to go... ");
	    System.exit(0);
		
	}

}
