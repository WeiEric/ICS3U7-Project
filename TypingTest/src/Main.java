import javax.swing.*;
import java.awt.event.*;

public class Main extends keyboardTemplate implements KeyListener, ActionListener{

	//frames
	static JFrame startFrame = new JFrame("Start the typing test");
	public static JFrame chooseFrame = new JFrame("Levels");
	static JFrame testFrame = new JFrame("Test");

	//buttons
	static JButton startBut = new JButton("START");
	static JButton easyBut = new JButton("EASY");
	static JButton mediumBut = new JButton("MEDIUM");
	static JButton hardBut = new JButton("HARD");
	static JButton backBut = new JButton("BACK");
	static JButton backButTest = new JButton("BACK");

	public static int whichLevel;

	public static void main(String[] args) {

		//starting frame
		startFrame.setSize(810,600);

		//start button
		startBut.setBounds(350,225,100,50);
		startBut.addActionListener(new Main());
		startFrame.add(startBut);

		startFrame.setLayout(null);
		startFrame.setVisible(true);
		startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//level choosing frame
		chooseFrame.setSize(810,600);

		//display buttons with choice of levels
		easyBut.setBounds(10,10,100,50);
		easyBut.addActionListener(new Main());
		chooseFrame.add(easyBut);
		mediumBut.setBounds(10,70,100,50);
		mediumBut.addActionListener(new Main());
		chooseFrame.add(mediumBut);
		hardBut.setBounds(10,130,100,50);
		hardBut.addActionListener(new Main());
		chooseFrame.add(hardBut);
		backBut.setBounds(10,190,100,50);
		backBut.addActionListener(new Main());
		chooseFrame.add(backBut);
		chooseFrame.setLayout(null);

		testFrame.setSize(810,600); 

		backButTest.setBounds(670,16,80,40);
		backButTest.addActionListener(new Main());
		testFrame.add(backButTest);

		testFrame.setLayout(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == startBut) {
			startFrame.setVisible(false);
			chooseFrame.setVisible(true);
		}	

		if(e.getSource() == easyBut) {
			whichLevel = 1;

			chooseFrame.setVisible(false);
			testFrame.getContentPane().removeAll();
			testFrame.add(backButTest);
			testFrame.setVisible(true);
			easyText.setBounds(0,0,500,300);
			testFrame.add(easyText);

			keyboardTemplate keyboard = new keyboardTemplate();
			keyboard.displayKeyboard(testFrame);
		}


		if(e.getSource() == mediumBut) {
			whichLevel = 2;

			chooseFrame.setVisible(false);
			testFrame.getContentPane().removeAll();
			testFrame.add(backButTest);
			testFrame.setVisible(true);
			mediumText.setBounds(10,20,500,300);
			testFrame.add(mediumText);

			keyboardTemplate keyboard = new keyboardTemplate();
			keyboard.displayKeyboard(testFrame);
		}

		if(e.getSource() == hardBut) {
			whichLevel = 3;

			chooseFrame.setVisible(false);
			testFrame.getContentPane().removeAll();
			testFrame.add(backButTest);
			testFrame.setVisible(true);
			hardText.setBounds(100,100,500,300);
			testFrame.add(hardText);

			keyboardTemplate keyboard = new keyboardTemplate();
			keyboard.displayKeyboard(testFrame);
		}

		else if(e.getSource() == backBut) {
			chooseFrame.setVisible(false);
			startFrame.setVisible(true);
		}

		else if(e.getSource() == backButTest) {
			testFrame.setVisible(false);
			chooseFrame.setVisible(true);
		}

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


}






