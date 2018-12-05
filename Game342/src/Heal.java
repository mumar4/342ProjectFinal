//
//Name: Abdullah Umar, Netid: mumar4
//Name: Hamzah Quraishi, Netid: hqurai3
//Name: Abdullah Kidwai, Netid: akidwa2
//UIC
//Game342 V4
//Nov 14 2018
//

//HEAL action for NPC can either heal all or revive a player
public class Heal extends Move{

	@Override
	void execute(Character c, Place p, String s) {
		// TODO Auto-generated method stub
		if(p.containsHealer()) {
			p.healPlayer();
		}
	}

}
