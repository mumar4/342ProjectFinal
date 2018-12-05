import java.util.Scanner;
public class TextInterface implements UserInterface {
	
	@Override
	public void display(String s) {
		System.out.println("bamz the hamz");
		System.out.println(s);
		
	}

	@Override
	public String getLine() {
		Scanner reader = KeyboardScanner.getKeyboardScanner();
		return reader.nextLine();
	}

}
