//
//Name: Abdullah Umar, Netid: mumar4
//Name: Hamzah Quraishi, Netid: hqurai3
//Name: Abdullah Kidwai, Netid: akidwa2
//UIC
//Game342 V4
//Nov 14 2018
//

//Scroll, a type of artifact and returns last stolen item
public class Scroll extends Artifact{

	private IO IO = new IO();
	public Scroll(int id, int Val, int Mobility, String Name, String Des, int KeyPattern) {
		super(id, Val, Mobility, Name, Des, KeyPattern);
		// TODO Auto-generated constructor stub
	}
	public Scroll(Artifact copy){ //copy constructor when you delete a key afgter you drop it.
		super(copy);
		
	}

	@Override
	public void use(Character c, Place p){
		
		if(c instanceof Player){
			String addBack = c.returnStolen();
			
			if(addBack != null){
				for(int i=0; i<Game.charlist.size();i++){
					if(Game.charlist.get(i).contains_art(addBack)){
						c.addArtifact(Game.charlist.get(i).retrieve_art(addBack));
						IO.display("Adding back "+addBack+ " to "+c.name()+"'s inventory");
						Game.charlist.get(i).remove_art(addBack);

					}
				}
			}
			
		}

	}
	
}