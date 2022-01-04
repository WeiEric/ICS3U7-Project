
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;

public class Home extends JFrame implements ActionListener {

	// Variable Declaration
	JButton play;
	JTextField title;

	Home() {

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

		// Title Screen
		title = new JTextField();
		title.setBounds(36, 36, 880, 236); // (posX, posY, X, Y)
		title.setFont(gameFont36P);
		title.setForeground(textColour);
		title.setBackground(backgroundColour);
		title.setEditable(false);
		title.setText("GAME TITLE"); // TODO NAME THE THING
		title.setAlignmentX(CENTER_ALIGNMENT);
		title.setAlignmentY(CENTER_ALIGNMENT);

		// Button(s)
		play = new JButton("Play");
		play.setBounds(360, 360, 236, 64);
		play.setForeground(textColour);
		play.setBackground(buttonBackgroundColour);
		play.setFont(gameFont36P);
		play.setBorder(textBorder);
		play.addActionListener(this);
		play.setAlignmentX(CENTER_ALIGNMENT);
		play.setAlignmentY(CENTER_ALIGNMENT);

		// Add Components
		//frame.add(inputTextField);
		this.add(title);
		this.add(play);

		// Layout
		this.setLayout(null);
		//frame.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == play) {
			new Play();
		}

	}

}
