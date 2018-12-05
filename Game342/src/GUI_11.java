import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class GUI_11 extends JFrame implements UserInterface, ActionListener {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JComboBox comboBox;
	private JLabel lblGame;
	public JTextArea textArea;
	private JPanel panel;
	public JScrollPane scroll;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_11 frame = new GUI_11();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	
	
	public GUI_11() {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_11 frame = new GUI_11();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 790, 555);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 245, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		panel = new JPanel();
		contentPane.add(panel, "name_67120319949415");
		
		lblGame = new JLabel();
		
		JButton btnNewButton = new JButton("Go");
		
		
		
		JButton btnGet = new JButton("Get");
		
		JButton btnLook = new JButton("Look");
		
		JButton btnNewButton_1 = new JButton("Drop");
		
		JButton btnNewButton_2 = new JButton("Use");
		
		JButton btnInve = new JButton("Inve");
		
		JButton btnExit = new JButton("Exit");
		
		
		//lblText = new JLabel();
		String []directionList = {"North", "South", "East", "West"};
		comboBox = new JComboBox(directionList);
		comboBox.setSelectedIndex(1);
		
		
		//add(comboBox);
		//panel.add(lblText);
		
		textArea = new JTextArea(0, 500);
		textArea.setWrapStyleWord(true);
		textArea.setSize(400, 400);
		
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		
		JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setEnabled(true);
		
		
		
		
		
		panel.add(scroll);
		
		//panel.setVisible(true);
		
		
		//textArea.setText("damnnnnnn");
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblGame, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnNewButton)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnGet)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton_2))
								.addGroup(gl_panel.createSequentialGroup()
									.addContainerGap()
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnInve))
								.addComponent(btnLook, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)))
					.addGap(31))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblGame)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnGet)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2)
						.addComponent(btnLook))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnInve))
					.addGap(5)
					.addComponent(btnExit))
		);
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == comboBox) {
					//JComboBox comboBox1 = (JComboBox)e.getSource();
					String msg = (String) comboBox.getSelectedItem();
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String value = (String)comboBox.getSelectedItem();
							textArea.setText(value);
							
							
						}
					});
			
				
			}
			}
			
			
		});
		//JScrollPane scroll = new JScrollPane(textArea);
		//textArea.setEditable(false);
		//panel.setVisible(true);
		panel.setLayout(gl_panel);
		
	}
    public JTextArea getTextArea() {
    		
    		return textArea;
    }
	

	@Override
	public void display(String s) {
		java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            		setVisible(true);
                textArea.append(s);
            }
        });
                
         
	}

	@Override
	public String getLine() {
		Scanner reader = KeyboardScanner.getKeyboardScanner();
		return reader.nextLine();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
