package Mastery;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class BreakAPlate implements ActionListener
{

	private static final String FIRST_PRIZE = "tiger plush";
	private static final String CONSOLATION_PRIZE = "sticker";

	private JFrame frame;
	private JPanel contentPane;
	private JButton play;
	private JLabel plates,prizeWon;
	

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					BreakAPlate window = new BreakAPlate();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public BreakAPlate() 
	{
		
		
		play = new JButton("Play");
		play.setBounds(110, 108, 89, 23);
		play.addActionListener(this);
		
		contentPane.add(play);
		
		plates = new JLabel();
		plates.setIcon(new ImageIcon("C:\\Users\\89186001\\Downloads\\plates.gif"));
		plates.setBounds(20, 11, 281, 86);
		
		contentPane.add(plates);
		
		prizeWon = new JLabel("");
		prizeWon.setBounds(80, 150, 200, 20);
		contentPane.add(prizeWon);
		
		
	
	
		
	}

	@Override
	public void actionPerformed(ActionEvent event) 
	{
		String eventName = event.getActionCommand();
		String prize;
	
		if (eventName.equals("Play"))
		{
		
			prize = BreakAPlate.start();
			if (prize.equals(FIRST_PRIZE))
			{
				plates.setIcon(new ImageIcon("plates_all_broken.gif"));
			}
			else if(prize.equals(CONSOLATION_PRIZE))
			{
				plates.setIcon(new ImageIcon("plates_two_broken.gif"));
			}
				prizeWon.setText("Your win:" + prize);
				play.setText("Play again");
				play.setActionCommand("Play again");
		}
		
		else if(eventName.equals("Play again"))
			{
				plates.setIcon(new ImageIcon("plates.gif"));
				prizeWon.setText(" ");
				play.setText("Play");
				play.setActionCommand("Play");
			}
	}

	private static String start() 
	{
		
		Random random = new Random();

		int result = random.nextInt(2);
			if (result == 0)
			{
				return FIRST_PRIZE;
			}
		
			else
			{
				return CONSOLATION_PRIZE;
			}
		
	}
	}
		
	

