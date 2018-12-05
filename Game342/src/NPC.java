//
//Name: Abdullah Umar, Netid: mumar4
//Name: Hamzah Quraishi, Netid: hqurai3
//Name: Abdullah Kidwai, Netid: akidwa2
//UIC
//Game342 V4
//Nov 14 2018
//

//NON-PLAYER CHARACTER
public class NPC extends Character{
	private int behavior;

	@Override
	public int getBehavior() {
		return behavior;
	}

	//CONSTRUCTOR, DECISIONMAKER SET TO AI CLASS OBJECT
	public NPC(int id, String name, String desc) {
		super(id, name, desc);
		DM = new AI();
		
		// TODO Auto-generated constructor stub
	}
	
	public void setBehavior(int b) {
		this.behavior = b;
	}
	
	@Override 
	void makeMove() {
		//Uses AI abstract class to execute a move
		DM.getMove(this, this.get_curr());//this = character, get_curr = curr Place
		
	}
}
