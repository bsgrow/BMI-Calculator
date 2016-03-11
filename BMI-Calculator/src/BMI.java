import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * This program creates a bmi calculator. It provides a frame and a GUI interface
 * for the user. Here you can enter your name, weight, and height. Then based
 * off of that information entered, you will receive and output of your current
 * bmi. 
 * 
 * @author BrandonGrow
 * 
 * Version 1.0.0
 *
 */

public class BMI extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	JMenuBar menuBar = new JMenuBar();
	JMenu file = new JMenu("File");
	JMenu help = new JMenu("Help");
	JMenuItem exit = new JMenuItem("Exit");
	JPanel contentPane = new JPanel(new BorderLayout());
	Font titleFont = new Font("Serif", Font.BOLD, 25);
	Font bmiFont = new Font("Serif", Font.BOLD, 40);
	Font outputFont = new Font("Serif", Font.BOLD, 15);
	JLabel appLabel = new JLabel("BMI Calculator");
	JLabel firstName = new JLabel("First Name: ");
	JLabel lastName = new JLabel("Last Name: ");
	JLabel weightLabel = new JLabel("Weight: ");
	JLabel heightLabel = new JLabel("Height: ");
	JLabel BMICalc = new JLabel("",SwingConstants.CENTER);
	JLabel nameOutput = new JLabel();
	JLabel underWeight = new JLabel("Underweight = < 18.5");
	JLabel normal = new JLabel("Normal Weight = 18.5 - 24.9");
	JLabel overWeight = new JLabel("Overweight = 25 - 29.9");
	JLabel obese = new JLabel("Obese = Greater than 30");
	JTextField firstNameBox = new JTextField();
	JTextField lastNameBox = new JTextField();
	JTextField weightBox = new JTextField();
	JTextField feetHeightBox = new JTextField();
	JTextField inchHeightBox = new JTextField();
	JButton calculateButton = new JButton("Calculate BMI");
	JButton clearButton = new JButton("Clear Entries");
	
	int bmiOutput = 0;
	int heightInInches = 0;
	
	public static void main(String[] args) {
		
		//sets up the frame
		BMI bmi = new BMI();
		bmi.setSize(500,460);
		bmi.setResizable(false);
		bmi.setVisible(true);
		bmi.setTitle("BMI Calculator");
		bmi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//end of main method
	
	public BMI() {

		//sets up menu bar
		file.add(exit);
		
		menuBar.add(file);
		menuBar.add(help);
		setJMenuBar(menuBar);
		
		//allows for program to close from menubar
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		
		//Panel that allows for all GUI to be ad added here
		contentPane.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(null);
		add(contentPane);
		
		//sets title
		appLabel.setBounds(160, 10, 200, 30);
		appLabel.setFont(titleFont);
		
		//labels
		firstName.setBounds(35, 80, 100, 20);
		lastName.setBounds(35, 130, 100, 20);
		weightLabel.setBounds(260, 80, 100, 20);
		heightLabel.setBounds(260, 130, 100, 20);
		
		//text fields
		firstNameBox.setBounds(112, 82, 120, 20);
		lastNameBox.setBounds(112, 130, 120, 20);
		weightBox.setBounds(310, 80, 100, 20);
		feetHeightBox.setBounds(308, 130, 30, 20);
		inchHeightBox.setBounds(338, 130, 30, 20);
		
		//bmi button
		calculateButton.setBounds(200, 180, 100, 20);
		calculateButton.addActionListener(this);
		
		//clear button 
		clearButton.setBounds(200, 380, 100, 20);
		clearButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				//sets text boxes to blank
				firstNameBox.setText("");
				lastNameBox.setText("");
				weightBox.setText("");
				feetHeightBox.setText("");
				inchHeightBox.setText("");
				
				//resets the color of the bmi labels
				underWeight.setForeground(Color.BLACK);
				normal.setForeground(Color.BLACK);
				overWeight.setForeground(Color.BLACK);
				obese.setForeground(Color.BLACK);
				BMICalc.setForeground(Color.BLACK);
				
		}
	});
		
		//bmi info labels
		underWeight.setBounds(280, 250, 150, 20);
		normal.setBounds(280, 280, 200, 20);
		overWeight.setBounds(280, 310, 200, 20);
		obese.setBounds(280, 340, 200, 20);
		
	
		//adds everything to content pane to view in the app frame
		contentPane.add(appLabel, null);
		contentPane.add(firstName, null);
		contentPane.add(lastName, null);
		contentPane.add(firstNameBox, null);
		contentPane.add(lastNameBox, null);
		contentPane.add(weightLabel, null);
		contentPane.add(heightLabel, null);
		contentPane.add(weightBox, null);
		contentPane.add(feetHeightBox, null);
		contentPane.add(inchHeightBox, null);
		contentPane.add(calculateButton, null);
		contentPane.add(clearButton, null);
		contentPane.add(BMICalc, null);
		contentPane.add(nameOutput, null);
		contentPane.add(underWeight, null);
		contentPane.add(normal, null);
		contentPane.add(overWeight, null);
		contentPane.add(obese, null);
		
		//adds to the frame
		add(contentPane);
		
		
	}//ends BMI method
	
	/**
	 * Allows for the bmi button to calculate the bmi of the inputs. This
	 * allows for the correct highlight of the bmi status. THis method pulls
	 * all of the information from the text fields and converts them to strings
	 * and some inputs to integer to allow for bmi computation.
	 */
    public void actionPerformed(ActionEvent e) {
    	
    	//creates the string for the text fields
    	String firstNameString = firstNameBox.getText();
    	String lastNameString = lastNameBox.getText();
    	String weightString = weightBox.getText();
    	String heightFString = feetHeightBox.getText();
    	String heightIString = inchHeightBox.getText();
    	
    	//converts strings to integers
    	int weightInt = Integer.parseInt(weightString);
    	int heightFInt = Integer.parseInt(heightFString);
    	int heightIInt = Integer.parseInt(heightIString);
    	
    	//converts height to inches
    	heightInInches = (heightFInt * 12) + heightIInt;
    	
    	//computes the BMI of the user
    	bmiOutput = ((weightInt * 703) / (heightInInches * heightInInches)) ;

    	//prints out a output with the name 
    	nameOutput.setText(firstNameString + " " + lastNameString + " your BMI is: ");
    	nameOutput.setBounds(50, 210, 300, 20);
    	nameOutput.setFont(outputFont);
    	
    	//prints out the BMI
    	BMICalc.setText("" + bmiOutput);
    	BMICalc.setBounds(100, 270, 60, 60);
    	BMICalc.setFont(bmiFont);
    	BMICalc.setBorder(BorderFactory.createLineBorder(Color.black));
    	
    	String bmiString = BMICalc.getText();
    	int bmiInt = Integer.parseInt(bmiString);
    	
    	if(bmiInt < 18.5) {
    		BMICalc.setForeground(Color.BLUE);
    		underWeight.setForeground(Color.BLUE);
    	} else if(bmiInt >= 18.5 && bmiInt <= 24.9) {
    		BMICalc.setForeground(Color.GREEN);
    		normal.setForeground(Color.GREEN);
    	} else if(bmiInt >= 25 && bmiInt <= 29.9) {
    		BMICalc.setForeground(Color.ORANGE);
    		overWeight.setForeground(Color.ORANGE);
    	} else if(bmiInt > 30) {
    		BMICalc.setForeground(Color.RED);
    		obese.setForeground(Color.RED);
    	}	
 
    }//end of actionListener method
    
}//ends BMI class
