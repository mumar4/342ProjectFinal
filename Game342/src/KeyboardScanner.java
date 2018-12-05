//
//Name: Abdullah Umar, Netid: mumar4
//Name: Hamzah Quraishi, Netid: hqurai3
//Name: Abdullah Kidwai, Netid: akidwa2
//UIC
//Game342 V4
//Nov 14 2018
//

import java.util.Scanner;

//CLASS ENCAPSULATED SCANNER AND SYSTEM.IN
public class KeyboardScanner {

	//define scanner as static
	private static KeyboardScanner s = null;
	private static Scanner keyboard;
	
	//----------------------------------------------------
	//----------------------------------------------------
	private KeyboardScanner() {
		keyboard = new Scanner(System.in);
	}
	
	//----------------------------------------------------
	//----------------------------------------------------
	static Scanner getKeyboardScanner() {
		if(s== null) {
			s  = new KeyboardScanner();
		}
		return keyboard;
	}
	
	
}
