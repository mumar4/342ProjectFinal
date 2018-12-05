//
//Name: Abdullah Umar, Netid: mumar4

//Name: Hamzah Quraishi, Netid: hqurai3
//Name: Abdullah Kidwai, Netid: akidwa2
//UIC
//Game342 V4
//Nov 14 2018
//

import java.io.*;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import java.util.*;
import java.io.FileNotFoundException;

//WHERE FILE IS ENTERED, THE SCANNER RUNS THROUGH FILE, AND GAME PLAY BEGINS
public class GameTester extends JFrame {
	public static int num_players = 0;
	protected static UserInterface UI;
	public static IO IO = new IO();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IO.display("********************************************");
		IO.display("*******************************************");
		IO.display("********************************************");
		IO.display("********************************************");
		IO.display("********************************************");
		IO.display("-------------------------------------");
		IO.display("-------------------------------------\n");
		IO.display("Name: Abdullah Umar, Netid: mumar4\n");
		IO.display("-------------------------------------");
		IO.display("-------------------------------------\n");
		IO.display("Name: Hamzah Quraishi, Netid: hqurai3\n");
		IO.display("-------------------------------------");
		IO.display("-------------------------------------\n");
		IO.display("Name: Abdullah Kidwai, Netid: akidwa2\n");
		IO.display("-------------------------------------");
		IO.display("-------------------------------------\n");
		IO.display("********************************************");
		IO.display("********************************************");
		IO.display("********************************************");
		IO.display("********************************************");
		IO.display("********************************************");
		IO.display("********************************************");
		IO.display("Entering Simulation\n");
		
		
		System.out.print("Please Enter a file name: ");
		Scanner input = new Scanner(System.in);
		UI = new IO();
		String fname = args[0].trim();
		IO.display(args[0]);
		
		if(args.length > 1) {
			num_players = Integer.valueOf(args[1]);
			System.out.println(num_players);
		}

		File file = new File("src/MystiCity50.gdf");
		Scanner reader = null;
		while(true) {
			try {
				reader = new Scanner(file);
				break;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.print("\nPlease Enter another file name: ");
				input = new Scanner(System.in);
				fname = input.nextLine();
				file = new File(fname/*"src/MystiCity 31.gdf"*/);
				continue;
			
			}
		}
		//GUI_11 gui = new GUI_11();
		//gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//gui.setSize(500, 500);
		//gui.setVisible(true);
		Game newGame = new Game(reader);
		newGame.print();
		newGame.play();
	}

}
