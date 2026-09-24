package SkillBuilders;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Roll {

	private JFrame frame;
	private JLabel die1;
	private JLabel die2;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Roll window = new Roll();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Roll() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 217, 254);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton rollDice = new JButton("Roll Dice");
		rollDice.setBounds(52, 123, 89, 37);
		rollDice.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) 
			{
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(rollDice);
		
		rollDice.addActionListener(e -> 
		{

		    Random rand = new Random();

		    int roll1 = rand.nextInt(6) + 1;
		    int roll2 = rand.nextInt(6) + 1;
		    die1.setIcon(new ImageIcon
		    		("C:\\Users\\89186001\\Downloads\\die" + roll1 + ".gif"));
		    ImageIcon icon = new ImageIcon(
		    		"C:\\Users\\89186001\\Downloads\\die" + roll2 + ".png");
		    
		    Image img = icon.getImage();
			Image scaled = img.getScaledInstance(75,75, Image.SCALE_SMOOTH);
		    die2.setIcon(new ImageIcon(scaled));
		});
		
		die1 = new JLabel();
		die1.setBounds(10, 21, 75, 91);
		die1.setIcon(new ImageIcon("C:\\Users\\89186001\\Downloads\\die1.gif"));
		frame.getContentPane().add(die1);
		
		die2 = new JLabel();
		die2.setBounds(108, 21, 75, 91);
		ImageIcon icon = new ImageIcon("C:\\Users\\89186001\\Downloads\\die1.png");
				Image img = icon.getImage();
				Image scaled = img.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
				die2.setIcon(new ImageIcon(scaled));
		frame.getContentPane().add(die2);
		
	}
}
