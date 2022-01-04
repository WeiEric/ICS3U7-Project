
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;

public class Lose extends JFrame implements ActionListener {

	// Variable Declaration
	JButton toHome;
	JTextField youLose;

	Lose() {

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
		Font gameFont36P = new Font("SansSerif", Font.BOLD, 36);

		// Frame setup
		//ImageIcon logo = new ImageIcon(null);
		this.setTitle("Typing Game"); //TODO: replace with game name
		//frame.setIconImage(logo.getImage()); //TODO: replace with game logo
		this.setSize(frameSize); // (x, y)
		this.setResizable(false);
		this.setVisible(true); // makes instance visible
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(backgroundColour); // Set background

		// Lose Screen
		youLose = new JTextField();
		youLose.setBounds(36, 36, 880, 236); // (posX, posY, X, Y)
		youLose.setBorder(textBorder);
		youLose.setFont(gameFont36P);
		youLose.setForeground(textColour);
		youLose.setBackground(buttonBackgroundColour);
		youLose.setEditable(false);
		youLose.setText("Sorry, that wasn't correct. Try again next time!");
		youLose.setAlignmentX(CENTER_ALIGNMENT);
		youLose.setAlignmentY(CENTER_ALIGNMENT);

		// Text Input Submission
		toHome = new JButton("Back");
		toHome.setBounds(360, 360, 236, 64);
		toHome.setForeground(textColour);
		toHome.setBackground(buttonBackgroundColour);
		toHome.setFont(gameFont36P);
		toHome.setBorder(textBorder);
		toHome.addActionListener(this);
		toHome.setAlignmentX(CENTER_ALIGNMENT);
		toHome.setAlignmentY(CENTER_ALIGNMENT);

		// Add Components
		//frame.add(inputTextField);
		this.add(youLose);
		this.add(toHome);

		// Layout
		this.setLayout(null);
		//frame.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == toHome) {
			new Home();
		}

	}

}
