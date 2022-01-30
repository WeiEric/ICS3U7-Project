import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Class KeyboardTemplate, child of Play, implements KeyListener
 * Provides a template for a full QWERTY keyboard as well as game logic that isn't present in its parent class Play, such as the stopping of the timer when the enter key is pressed.
 * @author [ insert author here ]
 *
 */
public class KeyboardTemplate implements KeyListener, ActionListener{

	static JButton buttons[] = new JButton[57];
	static int codes[] = new int[57];
	private int kcode;
	JTextArea textbox = new JTextArea();	
	JTextArea exampleText = new JTextArea();

	//fonts
	Font instrucFont = new Font("Verdana", Font.BOLD+Font.ITALIC, 16);
	Font backFont = new Font("Verdana", Font.BOLD+Font.ITALIC, 16);
	Font labelFont = new Font("Verdana", Font.BOLD+Font.ITALIC, 15);
	Font textboxFont = new Font("Verdana", Font.PLAIN, 15);
	Font timerFont = new Font("Verdana", Font.PLAIN, 30);

	// testing sentences
	String easyShow = "The basic technique stands in contrast to hunt and peck typing in which the typist keeps his or her eyes\n on the source copy at all times. Touch typing also involves the use of the home row method,"
			+ " where \n typists keep their wrists up, rather than resting them on a desk or keyboard (which can cause carpal \n tunnel syndrome).";
	String mediumShow = " Self-confidence is a tricky subject for many people. For some, it's impossible to feel good about \n  themselves without outside validation. When you're in a situation where the people in your "
			+ "life \n  aren't helping you to feel better about yourself, this can become a problem in your day to day life.";
	String hardShow = "During the 1970s, companies experienced rapid technological change which caused the major companies to \n enhance their strategic planning and focus on ways to organizational effectiveness. This "
			+ "resulted \n in developing more jobs and opportunities for people to show their skills which were directed to \n effective applying employees toward the fulfillment.";

	String compareEasy = "The basic technique stands in contrast to hunt and peck typing in which the typist keeps his or her eyes on the source copy at all times. Touch typing also involves the use of the home row method, where "
			+ "typists keep their wrists up, rather than resting them on a desk or keyboard (which can cause carpal tunnel syndrome).";
	String compareMedium = "Self-confidence is a tricky subject for many people. For some, it's impossible to feel good about themselves without outside validation. When you're in a situation where the people in your "
			+ "life aren't helping you to feel better about yourself, this can become a problem in your day to day life.";
	String compareHard = "During the 1970s, companies experienced rapid technological change which caused the major companies to enhance their strategic planning and focus on ways to organizational effectiveness. This "
			+ "resulted in developing more jobs and opportunities for people to show their skills which were directed to effective applying employees toward the fulfillment.";


	static long startTime;

	//stopwatch 
	Timer timer;
	static boolean startWatch = true;
	JLabel timerDisplay = new JLabel();

	static int totalTime = 0;
	static int seconds = 0;
	static int minutes = 0;
	static int hours= 0;

	String secDisplay = String.format("%02d", seconds);
	String minDisplay = String.format("%02d", minutes);
	String hourDisplay = String.format("%02d", hours);


	/**
	 * Creates a full QWERTY keyboard in frame f, as well as starts the timer
	 * @param f target frame where a keyboard is needed
	 */

	KeyboardTemplate() {	

		JFrame f = new JFrame();
		f.setSize(810,600);
		f.getContentPane().setBackground(Color.decode("#b7b7a4"));


		JButton backBut = new JButton("BACK");
		if (Main.whichLevel == 1) {
			f.setTitle("Easy test");
			exampleText.setBounds(5,66,780,80);
			exampleText.setText(easyShow);
			exampleText.setFont(textboxFont);
			exampleText.setBackground(Color.decode("#b7b7a4"));
			f.add(exampleText);

		} else if (Main.whichLevel == 2) {
			f.setTitle("Medium test");
			exampleText.setBounds(5,66,780,80);
			exampleText.setText(mediumShow);
			exampleText.setFont(textboxFont);
			exampleText.setBackground(Color.decode("#b7b7a4"));
			f.add(exampleText);

		} else if (Main.whichLevel == 3) {
			f.setTitle("Hard test");
			exampleText.setBounds(5,66,780,80);
			exampleText.setText(hardShow);
			exampleText.setFont(textboxFont);
			exampleText.setBackground(Color.decode("#b7b7a4"));
			f.add(exampleText);

		} else {
			f.setTitle("Custom test");
		}

		backBut.setBounds(670,16,80,40);
		backBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == backBut) {
					f.dispose();
				}

			}
		});

		f.add(backBut);

		//display instructions
		JLabel instructions = new JLabel("Press any key to start, and enter (on your keyboard)");
		JLabel instructions2 = new JLabel ("when you're finished!") ;
		instructions.setBounds(10,10,700,20);
		instructions.setFont(instrucFont);
		instructions.setForeground(Color.white);
		//f.add(instructions);

		instructions2.setBounds(10,35,500,20);
		instructions2.setFont(instrucFont);
		instructions2.setForeground(Color.white);
		//f.add(instructions2);

		//create text area for user to type in
		textbox.setBounds(5,150,780,106);
		textbox.setFont(textboxFont);
		textbox.setLineWrap(true);
		f.add(textbox);

		//display keyboard
		//first row
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
		makeButton("↑", 655, 416, 52, 52, f,52,38);

		//last row
		makeButton("", 208, 468, 312, 52, f,53,32);
		makeButton("←", 604, 468, 52, 52, f,54,37);
		makeButton("↓", 654, 468, 52, 52, f,55,40);
		makeButton("→", 706, 468, 52, 52, f,56,39);

		timerDisplay.setText(hourDisplay + ":" + minDisplay + ":" + secDisplay);

		timerDisplay.setBounds(60,6,300,60);
		timerDisplay.setFont(timerFont);
		f.add(timerDisplay);

		timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				totalTime = totalTime + 1000;
				hours = (totalTime / 3600000);
				minutes = (totalTime / 60000) % 60;
				seconds = (totalTime / 1000) % 60;

				secDisplay = String.format("%02d", seconds);
				minDisplay = String.format("%02d", minutes);
				hourDisplay = String.format("%02d", hours);
				timerDisplay.setText(hourDisplay + ":" + minDisplay + ":" + secDisplay);

			}});

		//add key listener
		textbox.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}			

			@Override
			public void keyPressed(KeyEvent e) {				

				//check which level is entered
				if(Main.whichLevel == 1) {
					if (startWatch == true) { //make sure timer only starts once
						start();
						startWatch = false;		
					}

					if(e.getKeyCode() == KeyEvent.VK_ENTER) { //check if enter is pressed and display corresponding information
						long endTime = System.nanoTime();
						long duration = endTime - startTime;
						long seconds = (long) (duration/ 1000000000.0);
						if(textbox.getText().trim().equals(compareEasy)) {
							JOptionPane.showMessageDialog( f, "Correct! That took you" + seconds + " seconds");
						}
						textbox.setText("");
						startWatch = true;
						stop();
						reset();
						f.dispose();
					}
				}

				if(Main.whichLevel == 2) {
					if (startWatch == true) {
						start();
						startWatch = false;
					}

					if(e.getKeyCode() == KeyEvent.VK_ENTER) {
						long endTime = System.nanoTime();
						long duration = endTime - startTime;
						long seconds = (long) (duration/ 1000000000.0);
						if(textbox.getText().trim().equals(compareMedium)) {
							JOptionPane.showMessageDialog( f, "Correct! That took you" + seconds + " seconds");
						}
						textbox.setText("");

						startWatch = true;
						stop();
						reset();
						f.dispose();

					}
				}

				if(Main.whichLevel == 3) {

					if (startWatch == true) {
						start();
						startWatch = false;
					}

					if(e.getKeyCode() == KeyEvent.VK_ENTER) {
						long endTime = System.nanoTime();
						long duration = endTime - startTime;
						long seconds = (long) (duration/ 1000000000.0);
						if(textbox.getText().trim().equals(compareHard)) {
							JOptionPane.showMessageDialog( f, "Correct! That took you" + seconds + " seconds");
						}
						textbox.setText("");
						startWatch = true;
						stop();
						reset();
						f.dispose();
					}
				}


				//find which key is being pressed and change the colour
				for (int i = 0; i < 57; i++) {
					if (codes[i] == e.getKeyCode()) {
						buttons[i].setBackground(Color.decode("#ccd5ae"));
					}
				}
			}

			//change back colour once released
			@Override
			public void keyReleased(KeyEvent e) {
				for (int i = 0; i < 57; i++) {
					if (codes[i] == e.getKeyCode()) {
						buttons[i].setBackground(Color.decode("#a6a397"));

					}
				}


			}


		});

		f.setFocusable(true);
		f.revalidate();
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		startTime = System.nanoTime();

	}

	/**
	 * Makes button with given parameters
	 * @param n Name of button
	 * @param x X position of button
	 * @param y Y position of button
	 * @param w width of button
	 * @param h height of button
	 * @param f target frame where buttons will exist in
	 * @param buttonNum button ID number
	 * @param kcode button keyboard code
	 */

	public void makeButton(String n, int x, int y, int w, int h, JFrame f, int buttonNum, int kcode) {
		JButton buttonName = new JButton(n);
		buttonName.setBackground(Color.decode("#a6a397"));
		buttonName.setBorder(BorderFactory.createLineBorder(Color.white, 5));
		buttonName.setForeground(Color.white);
		buttonName.setBounds(x,y,w,h);
		buttons[buttonNum] = buttonName;
		codes[buttonNum] = kcode;
		f.add(buttonName);

	}

	//timer methods
	void start() {
		timer.start();
	}

	void stop() {
		timer.stop();
	}


	void reset() {
		totalTime = 0;
		seconds = 0;
		minutes = 0;
		hours = 0;
	}


	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {


	}


}

