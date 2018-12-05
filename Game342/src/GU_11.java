/*import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class GU_11 extends JFrame implements UserInterface {
	

	private JButton btnNewButton;
	private JPanel contentPane;
	private JTextArea textArea;
	private JFrame frame;
	private JScrollPane scroll;

	/*public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GU_11().createAndShowGui();
			}
		});
	}
	public GU_11() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GU_11().createAndShowGui();
			}
		});
	}

	/**
	 * Launch the application.
	 */

	 /*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GU_11 frame = new GU_11();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	  * Create the frame.
	  *
	/*public GU_11() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}


	public void createAndShowGui() {
		frame = new JFrame("ScrollPane to TextArea");
		textArea = new JTextArea(10, 20); //Rows and cols to be displayed
		scroll = new JScrollPane(textArea);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		
		frame.getContentPane().add(scroll); //We add the scroll, since the scroll already contains the textArea
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void display(String s) {
		
                textArea.append(s);
          

	}

	@Override
	public String getLine() {
		// TODO Auto-generated method stub
		return null;
	}

}
*/