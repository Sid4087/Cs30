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

public class BreakAPlate implements ActionListener {

    private static final String FIRST_PRIZE = "tiger plush";
    private static final String CONSOLATION_PRIZE = "sticker";

    private JFrame frame;
    private JPanel contentPane;
    private JButton play;
    private JLabel plates, prizeWon;

    // Images
    private ImageIcon platesImage;
    private ImageIcon allBrokenImage;
    private ImageIcon twoBrokenImage;
    private ImageIcon tigerImage;
    private ImageIcon stickerImage;
    private ImageIcon placeholderImage;

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            public void run() {

                try {

                    BreakAPlate window = new BreakAPlate();
                    window.frame.setVisible(true);

                } catch (Exception e) {

                    e.printStackTrace();

                }

            }

        });

    }

    public BreakAPlate() 
    {
        platesImage = new ImageIcon("C:\\Users\\89186001\\Downloads\\plates.gif");
        allBrokenImage = new ImageIcon("C:\\Users\\89186001\\Downloads\\plates_all_broken.gif");
        twoBrokenImage = new ImageIcon("C:\\Users\\89186001\\Downloads\\plates_two_broken.gif");
        tigerImage = new ImageIcon("C:\\Users\\89186001\\Downloads\\tiger_plush.gif");
        stickerImage = new ImageIcon("C:\\Users\\89186001\\Downloads\\sticker.gif");
        placeholderImage = new ImageIcon("C:\\Users\\89186001\\Downloads\\placeholder.gif");

        frame = new JFrame();

        frame.setTitle("Break A Plate");
        frame.setBounds(100, 100, 350, 268);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        frame.setContentPane(contentPane);

        play = new JButton("Play");
        play.setBounds(117, 101, 89, 23);
        play.addActionListener(this);

        contentPane.setLayout(null);
        contentPane.add(play);

        plates = new JLabel();
        plates.setBounds(26, 11, 281, 86);
        plates.setIcon(platesImage);
        contentPane.add(plates);

        prizeWon = new JLabel("");
        prizeWon.setBounds(112, 124, 125, 94);
        prizeWon.setIcon(placeholderImage);
        contentPane.add(prizeWon);
    }

    @Override
    public void actionPerformed(ActionEvent event) 
    {

        String eventName = event.getActionCommand();
        String prize;

        if (eventName.equals("Play")) 
        {

            prize = start();

            if (prize.equals(FIRST_PRIZE)) 
            {
                plates.setIcon(allBrokenImage);

            } 
            else if (prize.equals(CONSOLATION_PRIZE)) 
            {
                plates.setIcon(twoBrokenImage);
            }

            if (prize.equals(FIRST_PRIZE)) 
            {
                prizeWon.setIcon(tigerImage);
            } 
            else 
            {
                prizeWon.setIcon(stickerImage);
            }

            play.setText("Play Again");
            play.setActionCommand("Play Again");

        }

        else if (eventName.equals("Play Again")) 
        {
            plates.setIcon(platesImage);
            prizeWon.setIcon(placeholderImage);

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