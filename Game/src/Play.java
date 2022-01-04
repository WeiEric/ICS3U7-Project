
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;
import javax.swing.border.*;

public class Play extends JFrame implements ActionListener {

	// Variable Declaration
	String input;
	JButton submit;
	JTextArea inputTextArea;
	JTextArea displayTextArea;
	FileReader fileIn;
	BufferedReader in;
	FileWriter fileOut;
	BufferedWriter out;
	String fileName = "Easy.txt";
	String timerTXT = "Time.txt";
	String line;
	String displayText;
	long startTime;
	long endTime;
	long timePassed;

	Play() {

		// Colours (r, g, b) or (0x######)
		Color backgroundColour = new Color(192, 192, 192);
		Color borderColour = new Color(64, 64, 64);
		Color textColour = new Color(64, 64, 64);
		Color buttonBackgroundColour = new Color(214, 214, 214);

		// Dimensions (x, y)
		//Dimension inputTextFieldSize = new Dimension(960, 360);
		//Dimension inputTextSubmitSize = new Dimension(64, 360);
		Dimension frameSize = new Dimension(960, 720);

		// Borders (colour, thickness)
		Border textBorder = BorderFactory.createLineBorder(borderColour, 3);

		// Fonts
		Font gameFont12P = new Font("SansSerif", Font.BOLD, 12);

		// Frame setup
		//ImageIcon logo = new ImageIcon(null);
		this.setTitle("Typing Game"); //TODO: replace with game name
		//frame.setIconImage(logo.getImage()); //TODO: replace with game logo
		this.setSize(frameSize); // (x, y)
		this.setResizable(false);
		this.setVisible(true); // makes instance visible
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(backgroundColour); // Set background

		// Stopwatch Start
		startTime = System.nanoTime();
		System.out.println(System.nanoTime());
		
		// Text Display
		try {
			fileIn = new FileReader(fileName);
			in = new BufferedReader(fileIn);
			
			line = in.readLine();
			//while((line = in.readLine()) != null) {
				displayText = line;
			//}
			
		} catch (IOException e) {
			System.out.println("Something Went Wrong");
			displayText = "Something Went Wrong";
		}
		displayTextArea = new JTextArea();
		displayTextArea.setBounds(40, 40, 880, 240); // (posX, posY, X, Y)
		displayTextArea.setBorder(textBorder);
		displayTextArea.setWrapStyleWord(true);
		displayTextArea.setLineWrap(true);
		displayTextArea.setFont(gameFont12P);
		displayTextArea.setForeground(textColour);
		displayTextArea.setBackground(buttonBackgroundColour);
		displayTextArea.setEditable(false);
		displayTextArea.setText(displayText);

		// Text Input
		inputTextArea = new JTextArea();
		inputTextArea.setBounds(40, 400, 736, 240); // (posX, posY, X, Y)
		inputTextArea.setBorder(textBorder);
		inputTextArea.setWrapStyleWord(true);
		inputTextArea.setLineWrap(true);
		inputTextArea.setFont(gameFont12P);
		inputTextArea.setForeground(textColour);
		inputTextArea.setBackground(buttonBackgroundColour);
		
		// Text Input Submission
		submit = new JButton("Done");
		submit.setBounds(816, 400, 64, 240);
		submit.setForeground(textColour);
		submit.setBackground(buttonBackgroundColour);
		submit.setFont(gameFont12P);
		submit.setBorder(textBorder);
		submit.addActionListener(this);
		
		// Add Components
		//frame.add(inputTextField);
		this.add(displayTextArea);
		this.add(inputTextArea);
		this.add(submit);

		// Layout
		this.setLayout(null);
		//frame.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submit) {
			System.out.println(inputTextArea.getText());
			
			// Compare and look for mistakes, add mistake counter later
			if (displayText.equals(inputTextArea.getText().trim())) {
				new Win();
				
				// Record time to be displayed
				endTime = System.nanoTime();
				System.out.println(System.nanoTime());
				timePassed = (long) Math.round((endTime - startTime) / 1000000000.0);
				System.out.println(timePassed);
				try {
					fileOut = new FileWriter(timerTXT, false);
					out = new BufferedWriter(fileOut);
					out.write(String.valueOf(timePassed));
					out.close();
				} catch (IOException e1) {
					System.out.println("Something Went Wrong");
					
				}
				
			} else {
				new Lose();
			}
		}

	}

}
