import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.*;

public class GUI_1 extends JFrame implements UserInterface, ActionListener{
	
	public static int num_players = 0;
	protected static UserInterface UI;
	private static IO IO = new IO();

	private static final int DEFAULT_WIDTH = 800;
    private static final int DEFAULT_HEIGHT = 450;
    private static final int BUTTON_TOP = 30;
    private static final int BUTTON_LEFT = 30;
    private static final int BUTTON_HEIGHT_INC = 50;
    private static final int BUTTON_WIDTH_INC = 120;
    private static final int LABEL_TOP = 160;
    private static final int LABEL_LEFT = 80;
    private static final int LABEL_HEIGHT_INC = 35;
	
	private Game theGame;
	
	private JPanel panel;
	private JTextArea text;
	private JScrollPane scroll;
	private JButton quitButton;
	
	
	private JButton goButton;
	private JButton dropButton;
	//private int BUTTON_HEIGHT_INC =50;
	
	
	JPanel cards;
	private JButton lookButton;
	final static String BUTTONPANEL = "Card with JButtons";
	final static String TEXTPANEL = "Card with JTextField";
	
	
	public GUI_1() {
		initDisplay();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
		String s = "";
        display(s);
        
	}
	
	public static void main(String []args) {
		//int reply = JOptionPane.showConfirmDialog(null, "Would you like to load an game?", "ExamBuilder", JOptionPane.YES_NO_OPTION);
        Game theGame;
        /*
        if(reply == JOptionPane.YES_OPTION) {
        	FileDialog fd = new FileDialog((Frame) null, "Select File to Open", FileDialog.LOAD);
            fd.setFile("*.gdf");
            fd.setVisible(true);
            
            String fileName = fd.getDirectory() + fd.getFile();
            System.out.println(fileName);
            */
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
            //String game = JOptionPane.showInputDialog("Name of the game");
			theGame = new Game(fname);
			new GUI_1();
			//display(fname);
            
 

	}
	@Override
	public void display(String s) {
		System.out.println(s);
		java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                setVisible(true);
            }
        });
		
	}
	public void gui() {
		
	}

	@Override
	public String getLine() {
		// TODO Auto-generated method stub
		return null;
	}
	
	 
	
	public void initDisplay() {
		
		panel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
            }
        };
        
        
        panel.setLayout(new BorderLayout());
        setTitle("Exam Builder");
        setSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        panel.setLayout(null);
        panel.setOpaque(true);
        panel.setPreferredSize(new Dimension(DEFAULT_WIDTH - 20, DEFAULT_HEIGHT - 20));
        
        quitButton = new JButton();
        quitButton.setText("Quit");
        panel.add(quitButton);
        quitButton.setBounds(BUTTON_LEFT, BUTTON_TOP, 100, 30);
        quitButton.addActionListener(this);
        
        lookButton = new JButton();
        lookButton.setText("Look");
        panel.add(lookButton);
        lookButton.setBounds(BUTTON_LEFT, BUTTON_TOP+BUTTON_HEIGHT_INC, 100, 30);
        lookButton.addActionListener(this);
        
        
        
        
        JLabel lbl = new JLabel("Select a direction to go to");
        lbl.setVisible(true);
        panel.add(lbl);
        String []directions = {"North", "South", "East", "West"};
        //JPanel 
        JComboBox cb = new JComboBox(directions);
        cb.setVisible(true);
        panel.add(cb);
        cb.setBounds(BUTTON_LEFT, BUTTON_TOP + (BUTTON_HEIGHT_INC *2) , 100, 30);

        dropButton = new JButton();
        dropButton.setText("Drop");
        panel.add(dropButton);
        dropButton.setBounds(BUTTON_LEFT, BUTTON_TOP + (BUTTON_HEIGHT_INC *3) , 100, 30);
        dropButton.addActionListener(this);
        
        
        //JComboBox dirList = new JComboBox(directions);
        //dirList.setSelectedItem(0);
       // dirList.addActionListener(this);
        setResizable(false);
        getContentPane().add(panel);
        getRootPane().setDefaultButton(quitButton);
        panel.setVisible(true);
        //getRootPane().setDefaultButton(quitButton);
        
        
        
        
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(quitButton)) {
            quit();
		}
		else if(e.getSource().equals(dropButton)) {
			go();
			//
			
		}
		else if(e.getSource().equals(lookButton)) {
			
		}
		
	}
	
	private void go() {
		System.out.println("LMAO IT CAME HERE");
	}
	private void quit() {
        System.exit(0);
    }

}
