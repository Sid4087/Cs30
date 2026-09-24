package SkillBuilders;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Font;

public class MetricConversion {

	private JFrame frame;
	private JComboBox comboBox;
	private JLabel lblNewLabel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MetricConversion window = new MetricConversion();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MetricConversion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 216, 172);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel Display = new JLabel("");
		Display.setBounds(10, 86, 181, 14);
		panel.add(Display);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setBounds(10, 39, 181, 36);
		comboBox.setModel(new DefaultComboBoxModel(new String[] 
				{"feet to meters", "inches to centimeters",
				"gallon to liters","pound to kilograms"}));
		panel.add(comboBox);
		
		lblNewLabel = new JLabel("Select a conversion type:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 181, 28);
		panel.add(lblNewLabel);
		
		
		comboBox.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) 
		    {

		        String choice = comboBox.getSelectedItem().toString();

		        if (choice.equals("feet to meters")) 
		        {
		            Display.setText("1 foot = 0.3048 meters");
		        }
		        else if (choice.equals("inches to centimeters")) 
		        {
		            Display.setText("1 inch = 2.54 centimeters");
		        }
		        else if (choice.equals("gallon to liters")) 
		        {
		            Display.setText("1 gallon = 4.5461 liters");
		        }
		        else if (choice.equals("pound to kilograms")) 
		        {
		            Display.setText("1 pound = 0.4536 kilograms");
		        }
		    }
		});
		
	}
}
