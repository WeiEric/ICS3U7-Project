
import java.awt.Color;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class KeyboardTemplate implements KeyListener{

	static JButton buttons[] = new JButton[57];
	static int codes[] = new int[57];
	public static JTextArea textbox = new JTextArea();
	static JFrame f = new JFrame();

	// import testing sentences

	static String compareEasy;
	static String compareMedium;
	static String compareHard;

	static JLabel easyText;// = new JLabel(compareEasy);
	static JLabel mediumText;// = new JLabel(compareMedium);
	static JLabel hardText;// = new JLabel(compareHard);

	public void importText() {

		try {

			// Easy
			String fileName = "easy.txt";
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			compareEasy = in.readLine();

			// Medium
			fileName = "medium.txt";
			in = new BufferedReader(new FileReader(fileName));
			compareMedium = in.readLine();

			// Hard
			fileName = "hard.txt";
			in = new BufferedReader(new FileReader(fileName));
			compareHard = in.readLine();

			easyText = new JLabel(compareEasy);
			mediumText = new JLabel(compareMedium);
			hardText = new JLabel(compareHard);

		} catch (IOException e) {
			compareEasy = "Something went wrong";
			compareMedium = "Something went wrong";
			compareHard = "Something went wrong";
			System.out.println("Error: file not found");
		}
	}

	//timer
	long startTime = System.nanoTime();
	long endTime;
	long duration;
	long seconds;

	public void displayKeyboard(JFrame f) {	

		//importText();

		f.setTitle("Easy test");
		f.setSize(810,600);

		//display instructions
		JLabel instruct = new JLabel("Press any key to start, and enter (on your keyboard) when you're finished!") ;
		instruct.setBounds(0,0,500,20);
		f.add(instruct);
		easyText.setBounds(0,50,500,20);
		f.add(easyText);

		//create text area for user to type in
		textbox.setBounds(2,140,780,110);
		f.add(textbox);


		//display keyboard
		//first row
		//keyboardTemplate b = new keyboardTemplate(f);
		makeButton("~", 5, 260, 52, 52, f, 0,192);
		makeButton("1", 57, 260, 52, 52, f,1,49);
		makeButton("2", 109, 260, 52, 52, f,2,50);
		makeButton("3", 161, 260, 52, 52, f,3,51);
		makeButton("4", 213, 260, 52, 52, f,4,52);
		makeButton("5", 265, 260, 52, 52, f,5,53);
		makeButton("6", 317, 260, 52, 52, f,6,54);
		makeButton("7", 369, 260, 52, 52, f,7,55);
		makeButton("8", 421, 260, 52, 52, f,8,56);
		makeButton("9", 473, 260, 52, 52, f,9,57);
		makeButton("0", 525, 260, 52, 52, f,10,48);
		makeButton("-", 577, 260, 52, 52, f,11,45);
		makeButton("+", 629, 260, 52, 52, f,12,61);
		makeButton("Backspace", 681, 260, 104, 52, f,13,8);

		//second row
		makeButton("Tab", 5, 312, 78, 52, f,14,9);
		makeButton("Q", 83, 312, 52, 52, f,15,81);
		makeButton("W", 135, 312, 52, 52, f,16,87);
		makeButton("E", 187, 312, 52, 52, f,17,69);
		makeButton("R", 239, 312, 52, 52, f,18,82);
		makeButton("T", 291, 312, 52, 52, f,19,84);
		makeButton("Y", 343, 312, 52, 52, f,20,89);
		makeButton("U", 395, 312, 52, 52, f,21,85);
		makeButton("I", 447, 312, 52, 52, f,22,73);
		makeButton("O", 499, 312, 52, 52, f,23,79);
		makeButton("P", 551, 312, 52, 52, f,24,80);
		makeButton("[", 603, 312, 52, 52, f,25,91);
		makeButton("]", 655, 312, 52, 52, f,26,93);
		makeButton("\\", 707, 312, 52, 52, f,27,92);

		//third row
		makeButton("CAPS", 5, 364, 78, 52, f,28,20);
		makeButton("A", 83, 364, 52, 52, f,29,65);
		makeButton("S", 135, 364, 52, 52, f,30,83);
		makeButton("D", 187, 364, 52, 52, f,31,68);
		makeButton("F", 239, 364, 52, 52, f,32,70);
		makeButton("G", 291, 364, 52, 52, f,33,71);
		makeButton("H", 343, 364, 52, 52, f,34,72);
		makeButton("J", 395, 364, 52, 52, f,35,74);
		makeButton("K", 447, 364, 52, 52, f,36,75);
		makeButton("L", 499, 364, 52, 52, f,37,76);
		makeButton(";", 551, 364, 52, 52, f,38,59);
		makeButton("\"", 603, 364, 52, 52, f,39,222);
		makeButton("Enter", 655, 364, 104, 52, f,40,10);

		//fourth row
		makeButton("Shift", 5, 416, 104, 52, f,41,16);
		makeButton("Z", 109, 416, 52, 52, f,42,90);
		makeButton("X", 161, 416, 52, 52, f,43,88);
		makeButton("C", 213, 416, 52, 52, f,44,67);
		makeButton("V", 265, 416, 52, 52, f,45,86);
		makeButton("B", 317, 416, 52, 52, f,46,66);
		makeButton("N", 369, 416, 52, 52, f,47,78);
		makeButton("M", 421, 416, 52, 52, f,48,77);
		makeButton(",", 473, 416, 52, 52, f,49,44);
		makeButton(".", 525, 416, 52, 52, f,50,46);
		makeButton("?", 577, 416, 52, 52, f,51,47);
		makeButton("â†‘", 655, 416, 52, 52, f,52,38);

		//last row
		makeButton("", 208, 468, 312, 52, f,53,32);
		makeButton("â†�", 604, 468, 52, 52, f,54,37);
		makeButton("â†“", 654, 468, 52, 52, f,55,40);
		makeButton("â†’", 706, 468, 52, 52, f,56,39);

		//add key listener
		textbox.addKeyListener(new KeyboardTemplate());

		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//startTime = System.nanoTime();

	}

	public void makeButton(String n, int x, int y, int w, int h, JFrame f, int buttonNum, int kcode) {
		JButton buttonName = new JButton(n);
		buttonName.setBounds(x,y,w,h);
		buttons[buttonNum] = buttonName;
		codes[buttonNum] = kcode;
		f.add(buttonName);

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if(Main.whichLevel == 1) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				endTime = System.nanoTime();
				duration = endTime - startTime;
				seconds = (long) Math.round(duration / 1000000000.0);
				if(textbox.getText().trim().equals(compareEasy)) {
					JOptionPane.showMessageDialog( f, "Correct! That took you " + seconds + " seconds");
					startTime = 0;
					endTime = 0;
				}
			}
		}

		if(Main.whichLevel == 2) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				endTime = System.nanoTime();
				duration = endTime - startTime;
				seconds = (long) Math.round(duration / 1000000000.0);
				if(textbox.getText().trim().equals(compareMedium)) {
					JOptionPane.showMessageDialog( f, "Correct! That took you " + seconds + " seconds");
					startTime = 0;
					endTime = 0;
				}
			}
		}

		if(Main.whichLevel == 3) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				endTime = System.nanoTime();
				duration = endTime - startTime;
				seconds = (long) Math.round(duration / 1000000000.0);
				if(textbox.getText().trim().equals(compareHard)) {
					JOptionPane.showMessageDialog( f, "Correct! That took you " + seconds + " seconds");
					startTime = 0;
					endTime = 0;
				}
			}
		}


		//find which key is being pressed and change the colour to blue
		for (int i = 0; i < 57; i++) {
			if (codes[i] == e.getKeyCode()) {
				buttons[i].setBackground(Color.decode("#99b3ff"));
			}
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		for (int i = 0; i < 57; i++) {
			if (codes[i] == e.getKeyCode()) {
				buttons[i].setBackground(null);
			}
		}

	}

}
