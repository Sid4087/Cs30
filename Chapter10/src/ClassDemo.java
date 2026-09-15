import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ClassDemo {

	private JFrame frame;
	private JTextField FirstName;
	private JTextField LastName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassDemo window = new ClassDemo();
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
	public ClassDemo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 710, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		FirstName = new JTextField();
		FirstName.setText("Enter first name");
		FirstName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(FirstName.getText().equals("Enter first name"))
				{
					FirstName.setText("");
				}
				if(LastName.getText().equals("Enter last name"))
				{
					LastName.setText("");
				}
			}
		});
		FirstName.setBounds(20, 25, 167, 28);
		panel.add(FirstName);
		FirstName.setColumns(10);
		
		LastName = new JTextField();
		LastName.setText("Enter last name");
		LastName.setColumns(10);
		LastName.setBounds(216, 25, 167, 28);
		panel.add(LastName);
		
		JLabel Display = new JLabel("");
		Display.setBounds(20, 165, 363, 69);
		panel.add(Display);
		
		JButton Submit = new JButton("Submit");
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String fN = FirstName.getText();
				String lN = LastName.getText();
				
				Display.setText("Your first name is:" + fN + " " + "Your last name is:" + lN);
			}
		});
		Submit.setFont(new Font("Tahoma", Font.BOLD, 18));
		Submit.setBounds(422, 25, 238, 226);
		panel.add(Submit);
		
			}
}
