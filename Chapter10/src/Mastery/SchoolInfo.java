package Mastery;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Color;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SchoolInfo 
{

	private JFrame frame;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField info;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					SchoolInfo window = new SchoolInfo();
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
	public SchoolInfo() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 397);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel images = new JLabel("");
		images.setBounds(20, 170, 260, 177);
		images.setIcon(new ImageIcon("C:\\Users\\89186001\\Downloads\\CresentHeights.png"));
		images.setBackground(new Color(255, 255, 255));
		panel.add(images);
		
		ImageIcon crescentImage = new ImageIcon("C:\\Users\\89186001\\Downloads\\CresentHeights.png");
		ImageIcon westernImage = new ImageIcon("C:\\Users\\89186001\\Downloads\\WesternRedHawks.png");
		ImageIcon aberhartImage = new ImageIcon("C:\\Users\\89186001\\Downloads\\Aberhart.png");
		ImageIcon pearsonImage = new ImageIcon("C:\\Users\\89186001\\Downloads\\Pearson.png");

		ImageIcon resizedCrescent = new ImageIcon(crescentImage.getImage().getScaledInstance(260, 100, Image.SCALE_SMOOTH));

		ImageIcon resizedWestern = new ImageIcon(westernImage.getImage().getScaledInstance(260, 100, Image.SCALE_SMOOTH));

		ImageIcon resizedAberhart = new ImageIcon(aberhartImage.getImage().getScaledInstance(260, 100, Image.SCALE_SMOOTH));

		ImageIcon resizedPearson = new ImageIcon(pearsonImage.getImage().getScaledInstance(260, 100, Image.SCALE_SMOOTH));
	
		JButton submit = new JButton("Submit");
		submit.setBounds(300, 30, 111, 148);
		submit.addKeyListener(new KeyAdapter() 
		{
			public void keyPressed(KeyEvent e) 
			{
				
			}
		});
		panel.add(submit);
		
		firstName = new JTextField();
		firstName.setBounds(20, 25, 125, 20);
		firstName.setText("Enter first name");
		firstName.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(firstName.getText().equals("Enter first name"))
				{
					firstName.setText("");
				}
				
			}
		});
		panel.add(firstName);
		firstName.setColumns(10);
		
		lastName = new JTextField();
		lastName.setBounds(155, 25, 125, 20);
		lastName.setText("Enter last name");
		lastName.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				if(lastName.getText().equals("Enter last name"))
				{
					lastName.setText("");
				}
			}
		});
		lastName.setColumns(10);
		panel.add(lastName);
		
		info = new JTextField();
		info.setBounds(20, 115, 243, 44);
		panel.add(info);
		info.setColumns(10);
		
		
		JComboBox grade = new JComboBox();
		grade.setBounds(20, 63, 80, 28);
		grade.setModel(new DefaultComboBoxModel(new String[] {"10", "11", "12"}));
		panel.add(grade);
		
		JComboBox school = new JComboBox();
		school.setBounds(161, 63, 119, 28);
		school.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				  if (school.getSelectedItem().equals("Western")) 
				  {
					  images.setIcon(resizedWestern);
			      }
				  else if (school.getSelectedItem().equals("Cresent")) 
			      {
					  images.setIcon(resizedCrescent);
			      }
			      else if (school.getSelectedItem().equals("Pearson")) 
			      {
			    	  images.setIcon(resizedPearson);
			      }
			      else if (school.getSelectedItem().equals("Aberhart")) 
			      {
			    	  images.setIcon(resizedAberhart);
			      }
		}});
		school.setModel(new DefaultComboBoxModel(new String[] {"Cresent", "Western", "Pearson", "Aberhart"}));
		panel.add(school);
		
		
	}
}
