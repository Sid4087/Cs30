
/*
Program: BreakAPlate.java          Last Date of this Revision: October 2nd, 2026

Purpose: This program is a game where the user clicks a button to break
plates and randomly receive either a tiger plush or a sticker. The program
displays different images depending on the prize that is won. The user can
also click Play Again to reset the game.

Author: Saeid Abdalla

School: CHHS

Course: CSE3010 - Computer Science 3
*/

package Mastery;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class BreakAPlate implements ActionListener
{
    // Constants for the two possible prizes
    private static final String FIRST_PRIZE = "tiger plush";
    private static final String CONSOLATION_PRIZE = "sticker";

    // GUI components
    private JFrame frame;
    private JPanel contentPane;
    private JButton play;
    private JLabel plates;
    private JLabel prizeWon;

    // Images used in the game
    private ImageIcon platesImage;
    private ImageIcon allBrokenImage;
    private ImageIcon twoBrokenImage;
    private ImageIcon tigerImage;
    private ImageIcon stickerImage;
    private ImageIcon placeholderImage;

    /**
     * Creates the BreakAPlate game window and initializes
     * the images and GUI components.
     */
    public BreakAPlate()
    {
        // Loads the image of the unbroken plates
        platesImage = new ImageIcon(
                "C:\\Users\\89186001\\Downloads\\plates.gif");

        // Loads the image showing all plates broken
        allBrokenImage = new ImageIcon(
                "C:\\Users\\89186001\\Downloads\\plates_all_broken.gif");

        // Loads the image showing two plates broken
        twoBrokenImage = new ImageIcon(
                "C:\\Users\\89186001\\Downloads\\plates_two_broken.gif");

        // Loads the tiger plush prize image
        tigerImage = new ImageIcon(
                "C:\\Users\\89186001\\Downloads\\tiger_plush.gif");

        // Loads the sticker prize image
        stickerImage = new ImageIcon(
                "C:\\Users\\89186001\\Downloads\\sticker.gif");

        // Loads the placeholder image shown before playing
        placeholderImage = new ImageIcon(
                "C:\\Users\\89186001\\Downloads\\placeholder.gif");

        // Creates the main game window
        frame = new JFrame();

        // Sets the title of the window
        frame.setTitle("Break A Plate");

        // Sets the size and position of the window
        frame.setBounds(100, 100, 350, 268);

        // Closes the program when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creates the main panel
        contentPane = new JPanel();

        // Sets the background colour of the panel
        contentPane.setBackground(new Color(255, 255, 255));

        // Adds the panel to the frame
        frame.setContentPane(contentPane);

        // Uses absolute positioning for the components
        contentPane.setLayout(null);

        // Creates the Play button
        play = new JButton("Play");

        // Sets the position and size of the Play button
        play.setBounds(117, 101, 89, 23);

        // Connects the button to the actionPerformed method
        play.addActionListener(this);

        // Adds the Play button to the panel
        contentPane.add(play);

        // Creates the label used to display the plate images
        plates = new JLabel();

        // Sets the position and size of the plate image
        plates.setBounds(26, 11, 281, 86);

        // Displays the unbroken plates when the program starts
        plates.setIcon(platesImage);

        // Adds the plate label to the panel
        contentPane.add(plates);

        // Creates the label used to display the prize
        prizeWon = new JLabel("");

        // Sets the position and size of the prize image
        prizeWon.setBounds(112, 124, 125, 94);

        // Displays the placeholder before the game is played
        prizeWon.setIcon(placeholderImage);

        // Adds the prize label to the panel
        contentPane.add(prizeWon);
    }

    /**
     * Handles the Play and Play Again button actions.
     *
     * @param event the button action performed by the user
     */
    public void actionPerformed(ActionEvent event)
    {
        // Gets the command associated with the button
        String eventName = event.getActionCommand();

        String prize;

        // Runs the game when the Play button is clicked
        if (eventName.equals("Play"))
        {
            // Randomly selects a prize
            prize = start();

            // Displays the correct broken plate image
            if (prize.equals(FIRST_PRIZE))
            {
                plates.setIcon(allBrokenImage);
            }
            else if (prize.equals(CONSOLATION_PRIZE))
            {
                plates.setIcon(twoBrokenImage);
            }

            // Displays the image of the prize won
            if (prize.equals(FIRST_PRIZE))
            {
                prizeWon.setIcon(tigerImage);
            }
            else
            {
                prizeWon.setIcon(stickerImage);
            }

            // Changes the button to Play Again
            play.setText("Play Again");
            play.setActionCommand("Play Again");
        }

        // Resets the game when Play Again is clicked
        else if (eventName.equals("Play Again"))
        {
            // Resets the plates to their original image
            plates.setIcon(platesImage);

            // Resets the prize to the placeholder image
            prizeWon.setIcon(placeholderImage);

            // Changes the button back to Play
            play.setText("Play");
            play.setActionCommand("Play");
        }
    }

    /**
     * Randomly selects one of the two possible prizes.
     *
     * @return the prize selected by the random number generator
     */
    private String start()
    {
        // Creates a Random object
        Random random = new Random();

        // Generates either 0 or 1
        int result = random.nextInt(2);

        // Returns the first prize if the result is 0
        if (result == 0)
        {
            return FIRST_PRIZE;
        }
        else
        {
            // Returns the consolation prize if the result is 1
            return CONSOLATION_PRIZE;
        }
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    // Creates an instance of the BreakAPlate class
                    BreakAPlate window = new BreakAPlate();

                    // Makes the application window visible
                    window.frame.setVisible(true);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
}

