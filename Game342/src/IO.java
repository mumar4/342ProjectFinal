
public class IO implements UserInterface{
	
	public static final int text = 0;
	public static final int GUI_11 = 1;
	public static final int GUI_2 = 2;
	public static final int GUI_3 = 3;
	
	//protected TextInterface io;
	private int selection;
	//protected UserInterface userI = new TextInterface();
	protected UserInterface userI = new GUI_11();
	
	public void display(String s) {
		userI.display(s);
		//System.out.println(s);
		
	}
	public String getLine() {
		return userI.getLine();	
	}
	public void selectInterface(int x) {
		if(x==0) {
			selection = text;
			userI = new TextInterface();	
		}
		/*
		if(x==1) {
			selection = GUI_1;
			gui1 = new GUI_1();
		}
		*/
	}
}
