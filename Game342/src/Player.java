//
//Name: Abdullah Umar, Netid: mumar4
//Name: Hamzah Quraishi, Netid: hqurai3
//Name: Abdullah Kidwai, Netid: akidwa2
//UIC
//Game342 V4
//Nov 14 2018
//

import java.util.ArrayList;

//PLAYER CLASS CHILD OF CHARACTER
public class Player extends Character{

	private int HP;

	//----------------------------------------------------
	//----------------------------------------------------
	//DECISIONMAKER VARIABLE SET TO UI OBJECT
	public Player(int id, String name, String desc) {
		super(id, name, desc);
		DM = new UI();
		this.HP = 3;
		// TODO Auto-generated constructor stub
	}

	//----------------------------------------------------
	//----------------------------------------------------
	public Player(Character c) {
		// TODO Auto-generated constructor stub
		super(c);
		DM = new UI();
		this.HP = c.getHP();
	}

	//----------------------------------------------------
	//----------------------------------------------------
	//MAKE ALL PLAYER MOVES
	@Override 
		void makeMove() {
			//Uses UI abstract class to execute a move
			DM.getMove(this, this.get_curr());//this = character, get_curr = curr Place

		}
	//----------------------------------------------------
	//----------------------------------------------------
	@Override
		public void setHP(int h){
			this.HP = 3;

		}

	//----------------------------------------------------
	//----------------------------------------------------
	@Override
		public void addHP(){
			if(this.HP == 1 || this.HP == 2){
				(this.HP)++;
			}
		}
	//----------------------------------------------------
	//----------------------------------------------------
	@Override
		public void subHP(){
			if(this.HP == 1 || this.HP == 2 || this.HP == 3){
				(this.HP)--;
			}
		}
	//----------------------------------------------------
	//----------------------------------------------------
	@Override
		public int getHP(){
			return this.HP;
		}

}
