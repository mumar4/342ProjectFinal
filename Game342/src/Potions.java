//
//Name: Abdullah Umar, Netid: mumar4
//Name: Hamzah Quraishi, Netid: hqurai3
//Name: Abdullah Kidwai, Netid: akidwa2
//UIC
//Game342 V4
//Nov 14 2018
//

//Potions are a type of artifact that regain player's health
public class Potions extends Artifact{
	private IO IO = new IO();
	public Potions(Artifact copy){ //copy constructor when you delete a key afgter you drop it.
		super(copy);
		
	}
	public Potions(int id, int Val, int Mobility, String Name, String Des, int KeyPattern) {
		super(id, Val, Mobility, Name, Des, KeyPattern);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void use(Character c, Place p){

		c.addHP();
		IO.display("The potions strength is: " + c.getHP());

	}
	
}