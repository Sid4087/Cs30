
/*
Program: SchoolInfo.java          Last Date of this Revision: October 2nd, 2026

Purpose: This program allows the user to enter their name, select their grade
and school, and display the corresponding school image and information.

Author: Saeid Abdalla
School: CHHS
Course: CSE3010 - Computer Science 3
*/

/**
 * This class creates a GUI that allows the user to enter their name,
 * select their grade and school, and display school information.
 */
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

public class SchoolInfo
{
    // Instance fields
    private JFrame frame;
    private JTextField firstName;
    private JTextField lastName;
    private JComboBox grade;
    private JComboBox school;
    private JLabel images;
    private JTextArea info;

    /**
     * Stores the resized school images.
     */
    private ImageIcon resizedCrescent;
    private ImageIcon resizedWestern;
    private ImageIcon resizedPearson;
    private ImageIcon resizedAberhart;
    
    // Window constants
    private static final int FRAME_X = 100;
    private static final int FRAME_Y = 100;
    private static final int FRAME_WIDTH = 450;
    private static final int FRAME_HEIGHT = 397;

    // Image constants
    private static final int IMAGE_WIDTH = 240;
    private static final int IMAGE_HEIGHT = 170;

    // Text constants
    private static final String FIRST_NAME_PROMPT = "Enter first name";
    private static final String LAST_NAME_PROMPT = "Enter last name";

    /**
     * Creates the SchoolInfo application.
     */
    public SchoolInfo()
    {
        initialize();
    }

    /**
     * Initializes the contents of the frame.
     */
    private void initialize()
    {
        createFrame();

        JPanel panel = createPanel();

        createImages(panel);
        createNameFields(panel);
        createComboBoxes(panel);
        createInformationArea(panel);
        createSubmitButton(panel);
    }

    /**
     * Creates the main JFrame window.
     */
    private void createFrame()
    {
        frame = new JFrame();

        frame.setBounds(FRAME_X,FRAME_Y,FRAME_WIDTH,FRAME_HEIGHT);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Creates the main panel for the application.
     *
     * @return the panel used for the GUI
     */
    private JPanel createPanel()
    {
        JPanel panel = new JPanel();

        frame.getContentPane().add(
                panel,
                BorderLayout.CENTER);

        panel.setLayout(null);

        return panel;
    }

    /**
     * Creates and displays the school images.
     *
     * @param panel the panel containing the images
     */
    private void createImages(JPanel panel)
    {
        ImageIcon crescentImage = loadImage("C:\\Users\\89186001\\Downloads\\CresentHeights.png");

        ImageIcon westernImage = loadImage("C:\\Users\\89186001\\Downloads\\WesternRedHawks.png");

        ImageIcon aberhartImage = loadImage("C:\\Users\\89186001\\Downloads\\Aberhart.png");

        ImageIcon pearsonImage = loadImage("C:\\Users\\89186001\\Downloads\\Pearson.png");

        ImageIcon placeholderImage = loadImage("C:\\Users\\89186001\\Downloads\\schoolPlaceHolder.png");

        ImageIcon resizedCrescent = resizeImage(crescentImage);
        ImageIcon resizedWestern = resizeImage(westernImage);
        ImageIcon resizedAberhart = resizeImage(aberhartImage);
        ImageIcon resizedPearson = resizeImage(pearsonImage);
        ImageIcon resizedPlaceholder = resizeImage(placeholderImage);

        images = new JLabel("");
        images.setBounds(20, 170, 270, 177);
        images.setIcon(resizedPlaceholder);

        panel.add(images);

        addSchoolImageListener(
                resizedCrescent,
                resizedWestern,
                resizedPearson,
                resizedAberhart);
    }

    /**
     * Loads an image from a file.
     *
     * @param filePath the location of the image
     * @return the image icon
     */
    private ImageIcon loadImage(String filePath)
    {
        return new ImageIcon(filePath);
    }

    /**
     * Resizes an image to fit the image label.
     *
     * @param image the image to resize
     * @return the resized image
     */
    private ImageIcon resizeImage(ImageIcon image)
    {
        Image resizedImage = image.getImage().getScaledInstance(
                IMAGE_WIDTH,
                IMAGE_HEIGHT,
                Image.SCALE_SMOOTH);

        return new ImageIcon(resizedImage);
    }

    /**
     * Creates the first and last name text fields.
     *
     * @param panel the panel containing the text fields
     */
    private void createNameFields(JPanel panel)
    {
        createFirstNameField(panel);
        createLastNameField(panel);
    }

    /**
     * Creates the first name text field.
     *
     * @param panel the panel containing the field
     */
    private void createFirstNameField(JPanel panel)
    {
        firstName = new JTextField();

        firstName.setBounds(20, 25, 125, 20);
        firstName.setText(FIRST_NAME_PROMPT);
        firstName.setColumns(10);

        addFirstNameListener();

        panel.add(firstName);
    }

    /**
     * Creates the last name text field.
     *
     * @param panel the panel containing the field
     */
    private void createLastNameField(JPanel panel)
    {
        lastName = new JTextField();

        lastName.setBounds(155, 25, 125, 20);
        lastName.setText(LAST_NAME_PROMPT);
        lastName.setColumns(10);

        addLastNameListener();

        panel.add(lastName);
    }

    /**
     * Removes the first name prompt when the user starts typing.
     */
    private void addFirstNameListener()
    {
        firstName.addKeyListener(new KeyAdapter()
        {
            public void keyTyped(KeyEvent e)
            {
                if (firstName.getText().equals(FIRST_NAME_PROMPT))
                {
                    firstName.setText("");
                }
            }
        });
    }

    /**
     * Removes the last name prompt when the user starts typing.
     */
    private void addLastNameListener()
    {
        lastName.addKeyListener(new KeyAdapter()
        {
            public void keyTyped(KeyEvent e)
            {
                if (lastName.getText().equals(LAST_NAME_PROMPT))
                {
                    lastName.setText("");
                }
            }
        });
    }

    /**
     * Creates the grade and school combo boxes.
     *
     * @param panel the panel containing the combo boxes
     */
    private void createComboBoxes(JPanel panel)
    {
        createGradeBox(panel);
        createSchoolBox(panel);
    }

    /**
     * Creates the grade selection combo box.
     *
     * @param panel the panel containing the combo box
     */
    private void createGradeBox(JPanel panel)
    {
        grade = new JComboBox();

        grade.setBounds(20, 63, 80, 28);

        grade.setModel(new DefaultComboBoxModel(new String[] {"My grade", "10", "11", "12"}));

        panel.add(grade);
       
        /**
         * Removes the my grade prompt when the combo box is opened.
         */
        grade.addPopupMenuListener(new PopupMenuListener()
        {
            public void popupMenuCanceled(PopupMenuEvent e)
            {
            }

            public void popupMenuWillBecomeInvisible(PopupMenuEvent e)
            {
            }

            public void popupMenuWillBecomeVisible(PopupMenuEvent e)
            {
                grade.removeItem("My grade");
            }
        });
    }

    /**
     * Creates the school selection combo box.
     *
     * @param panel the panel containing the combo box
     */
    private void createSchoolBox(JPanel panel)
    {
        school = new JComboBox();

        school.setBounds(161, 63, 119, 28);

        school.setModel(new DefaultComboBoxModel(new String[]{"My School","Cresent","Western","Pearson","Aberhart"}));

        addSchoolSelectionListener();

        panel.add(school);
        
        /**
         * Removes the my school prompt when the combo box is opened.
         */
        school.addPopupMenuListener(new PopupMenuListener()
        {
            public void popupMenuCanceled(PopupMenuEvent e)
            {
            }

            public void popupMenuWillBecomeInvisible(PopupMenuEvent e)
            {
            }

            public void popupMenuWillBecomeVisible(PopupMenuEvent e)
            {
                school.removeItem("My School");
            }
        });
    }

    /**
     * Changes the displayed image when a school is selected.
     */
    private void addSchoolSelectionListener()
    {
        school.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String selectedSchool =
                        school.getSelectedItem().toString();

                changeSchoolImage(selectedSchool);
            }
        });
    }

    /**
     * Changes the image based on the selected school.
     *
     * @param selectedSchool the school selected by the user
     */
    private void changeSchoolImage(String selectedSchool)
    {
        if (selectedSchool.equals("Western"))
        {
            images.setIcon(getSchoolImage("Western"));
        }
        else if (selectedSchool.equals("Cresent"))
        {
            images.setIcon(getSchoolImage("Cresent"));
        }
        else if (selectedSchool.equals("Pearson"))
        {
            images.setIcon(getSchoolImage("Pearson"));
        }
        else if (selectedSchool.equals("Aberhart"))
        {
            images.setIcon(getSchoolImage("Aberhart"));
        }
    }

    /**
     * Adds the school image listener.
     *
     * @param crescentImage the Crescent image
     * @param westernImage the Western image
     * @param pearsonImage the Pearson image
     * @param aberhartImage the Aberhart image
     */
    private void addSchoolImageListener(ImageIcon crescentImage,ImageIcon westernImage,ImageIcon pearsonImage,ImageIcon aberhartImage)
    {
        resizedCrescent = crescentImage;
        resizedWestern = westernImage;
        resizedPearson = pearsonImage;
        resizedAberhart = aberhartImage;
    }

    /**
     * Gets the image for the selected school.
     *
     * @param selectedSchool the selected school
     * @return the corresponding school image
     */
    private ImageIcon getSchoolImage(String selectedSchool)
    {
        if (selectedSchool.equals("Western"))
        {
            return resizedWestern;
        }
        else if (selectedSchool.equals("Cresent"))
        {
            return resizedCrescent;
        }
        else if (selectedSchool.equals("Pearson"))
        {
            return resizedPearson;
        }

        return resizedAberhart;
    }

    /**
     * Creates the information text area.
     *
     * @param panel the panel containing the text area
     */
    private void createInformationArea(JPanel panel)
    {
        info = new JTextArea();

        info.setWrapStyleWord(true);
        info.setLineWrap(true);
        info.setBounds(20, 99, 260, 61);

        panel.add(info);
    }

    /**
     * Creates the Submit button.
     *
     * @param panel the panel containing the button
     */
    private void createSubmitButton(JPanel panel)
    {
        JButton submit = new JButton("Submit");

        submit.setBounds(300, 30, 111, 163);

        submit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                displayStudentInformation();
            }
        });

        panel.add(submit);
    }

    /**
     * Displays the student's name, grade, and school.
     */
    private void displayStudentInformation()
    {
        String firstNameText = firstName.getText();
        String lastNameText = lastName.getText();
        String gradeText = grade.getSelectedItem().toString();
        String schoolText = school.getSelectedItem().toString();

        info.setText(firstNameText + " " + lastNameText + " is in grade " + gradeText + " and goes to " + schoolText + " highschool.");
    }

    /**
     * Launches the application.
     *
     * @param args command-line arguments
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
}

