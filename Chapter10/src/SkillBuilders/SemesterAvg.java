package SkillBuilders;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

public class SemesterAvg {

	private JFrame frame;
	private JTextField Gr1;
	private JTextField Gr2;
	private JTextField Gr3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SemesterAvg window = new SemesterAvg();
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
	public SemesterAvg() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		Gr1 = new JTextField();
		Gr1.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if (Gr1.getText().equals("Enter the first grade:"))
				{
					Gr1.setText("");
				}
			}
		});
		Gr1.setText("Enter the first grade:");
		Gr1.setBounds(26, 46, 147, 42);
		panel.add(Gr1);
		Gr1.setColumns(10);
		
		Gr2 = new JTextField();
		Gr2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if (Gr2.getText().equals("Enter the second grade:"))
				{
					Gr2.setText("");
				}
			}
		});
		Gr2.setText("Enter the second grade:");
		Gr2.setColumns(10);
		Gr2.setBounds(26, 99, 147, 42);
		panel.add(Gr2);
		
		Gr3 = new JTextField();
		Gr3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if (Gr3.getText().equals("Enter the third grade:"))
				{
					Gr3.setText("");
				}
			}
		});
		Gr3.setText("Enter the third grade:");
		Gr3.setColumns(10);
		Gr3.setBounds(26, 152, 147, 42);
		panel.add(Gr3);
		
		JLabel Display = new JLabel("");
		Display.setBounds(26, 223, 338, 42);
		panel.add(Display);
		

		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String eventName = e.getActionCommand();
				
				if (eventName.equals("Submit"))
				{
					double AvgGrade;
					
					String g1 = Gr1.getText();
					String g2 = Gr2.getText();
					String g3 = Gr3.getText();
					
				
					
					AvgGrade = (Double.parseDouble(g1) + Double.parseDouble(g2) + Double.parseDouble(g3))/3;
					
					DecimalFormat dc = new DecimalFormat("0.0");
					
					
					Display.setText("Your semester average is:" + dc.format(AvgGrade));
				}
			}
			
		});
		btnNewButton.setBounds(246, 46, 153, 148);
		panel.add(btnNewButton);
		
		
	}
}
