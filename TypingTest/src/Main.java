
import java.awt.Font;
import java.awt.event.*;
import java.awt.Color;
import javax.swing.*;

/**
 * Class Main
 * Sets all the starting frame properties and contains menu and level selector
 * @author author
 *
 */
public class Main implements KeyListener, ActionListener{


	//title 
	static JLabel title = new JLabel("Typing Test");
	static JLabel titleShadow = new JLabel("Typing Test");
	static JLabel classCode = new JLabel("ICS3U7-02");
	static JLabel names = new JLabel("By Eric W. and Vivian T.");
	static JLabel levelTitle = new JLabel("Choose a level");
	static  JLabel levelShadow = new JLabel("Choose a level");

	//fonts
	static Font buttonFont = new Font("Verdana", Font.BOLD+Font.ITALIC, 22);
	static Font backFont = new Font("Verdana", Font.BOLD+Font.ITALIC, 16);
	static Font titleFont = new Font("Verdana", Font.BOLD+Font.ITALIC, 60);
	static Font nameFont = new Font("Verdana", Font.BOLD+Font.ITALIC, 15);

	//frames
	static JFrame startFrame = new JFrame("Start the typing test");
	static JFrame chooseFrame = new JFrame("Levels");
	static JFrame testFrame = new JFrame("Test");
	static JFrame signupFrame = new JFrame("Sign up");
	static JFrame loginFrame = new JFrame("Login");

	//buttons
	static JButton startBut = new JButton("START");
	static JButton loginBut = new JButton("LOGIN");
	static JButton signupBut = new JButton("SIGN UP");
	static JButton easyBut = new JButton("EASY");
	static JButton mediumBut = new JButton("MEDIUM");
	static JButton hardBut = new JButton("HARD");
	static JButton importBut = new JButton("IMPORT");
	static JButton backBut = new JButton("BACK");
	static JButton doneSignBut = new JButton("SIGN UP");
	static JButton backSignup = new JButton("BACK");

	static int whichLevel;
	public static void main(String[] args) {

		startFrame.getContentPane().setBackground(Color.decode("#b7b7a4"));
		startFrame.setSize(810,600);

		title.setFont(titleFont);
		title.setForeground(Color.white);

		title.setBounds(230,88,500,100);	
		startFrame.add(title);

		title.setBounds(228,88,500,100);
		startFrame.add(title);

		titleShadow.setBounds(235, 92, 500,100);
		titleShadow.setFont(titleFont);
		titleShadow.setForeground(Color.decode("#715d42"));
		startFrame.add(titleShadow);

		classCode.setBounds(620,470,100,50);
		classCode.setFont(nameFont);
		classCode.setForeground(Color.white);
		startFrame.add(classCode);

		names.setBounds(560,500,230,50);
		names.setFont(nameFont);
		names.setForeground(Color.white);
		startFrame.add(names);

		//start button
		startBut.setBounds(350,225,140,60);
		startBut.setFont(buttonFont);
		startBut.setBackground(Color.decode("#a6a397"));
		startBut.setBorder(BorderFactory.createLineBorder(Color.white, 5));
		startBut.setForeground(Color.white);
		startBut.addActionListener(new Main());
		startFrame.add(startBut);

		loginBut.setBounds(270,310,140,60);
		loginBut.setFont(buttonFont);
		loginBut.setBackground(Color.decode("#a6a397"));
		loginBut.setBorder(BorderFactory.createLineBorder(Color.white, 5));
		loginBut.setForeground(Color.white);
		loginBut.addActionListener(new Main());
		startFrame.add(loginBut);		 

		signupBut.setBounds(430,310,140,60);
		signupBut.setFont(buttonFont);
		signupBut.setBackground(Color.decode("#a6a397"));
		signupBut.setBorder(BorderFactory.createLineBorder(Color.white, 5));
		signupBut.setForeground(Color.white);
		signupBut.addActionListener(new Main());
		startFrame.add(signupBut);		

		loginFrame.setSize(550,330);
		loginFrame.setLayout(null);

		doneSignBut.setBounds(400,210,100,30);
		doneSignBut.setFont(buttonFont);
		doneSignBut.addActionListener(new Main());
		signupFrame.setSize(550,330);
		signupFrame.setLayout(null);

		startFrame.setLayout(null);
		startFrame.setVisible(true);
		startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//level choosing frame
		chooseFrame.setSize(810,600);
		chooseFrame.getContentPane().setBackground(Color.decode("#b7b7a4"));

		//choose frame title
		levelShadow.setBounds(165, 92, 500,100);
		levelShadow.setFont(titleFont);
		levelShadow.setForeground(Color.decode("#715d42"));
		chooseFrame.add(levelShadow);

		levelTitle.setBounds(158, 92, 500,100);
		levelTitle.setFont(titleFont);
		levelTitle.setForeground(Color.white);
		chooseFrame.add(levelTitle);

		//display buttons with choice of levels
		easyBut.setBounds(130,270,230,85);
		easyBut.setFont(buttonFont);
		easyBut.setBackground(Color.decode("#a6a397"));
		easyBut.setBorder(BorderFactory.createLineBorder(Color.white, 5));
		easyBut.setForeground(Color.white);
		easyBut.addActionListener(new Main());
		chooseFrame.add(easyBut);

		mediumBut.setBounds(440,270,230,85);
		mediumBut.setFont(buttonFont);
		mediumBut.setBackground(Color.decode("#a6a397"));
		mediumBut.setBorder(BorderFactory.createLineBorder(Color.white, 5));
		mediumBut.setForeground(Color.white);
		mediumBut.addActionListener(new Main());
		chooseFrame.add(mediumBut);

		hardBut.setBounds(130,390,230,85);
		hardBut.setFont(buttonFont);
		hardBut.setBackground(Color.decode("#a6a397"));
		hardBut.setBorder(BorderFactory.createLineBorder(Color.white, 5));
		hardBut.setForeground(Color.white);
		hardBut.addActionListener(new Main());
		chooseFrame.add(hardBut);

		importBut.setBounds(440,390,230,85);
		importBut.setFont(buttonFont);
		importBut.setBackground(Color.decode("#a6a397"));
		importBut.setBorder(BorderFactory.createLineBorder(Color.white, 5));
		importBut.setForeground(Color.white);
		importBut.addActionListener(new Main());
		chooseFrame.add(importBut);

		backBut.setBounds(640,30,130,60);
		backBut.setBackground(Color.decode("#a6a397"));
		backBut.setBorder(BorderFactory.createLineBorder(Color.white, 5));
		backBut.setForeground(Color.white);
		backBut.addActionListener(new Main());
		chooseFrame.add(backBut);

		chooseFrame.setLayout(null);

		testFrame.setSize(810,600); 

		testFrame.setLayout(null);

	}

	/*public Main() {
		startFrame.getContentPane().setBackground(Color.decode("#b7b7a4"));
		startFrame.setSize(810,600);

		title.setFont(titleFont);
		title.setForeground(Color.white);

		//make sure the text is in the right spot when startFrame is reopened
		// 	titleAnimate(); 
		title.setBounds(0,0,500,100);	
		startFrame.add(title);

		title.setBounds(228,88,500,100);
		startFrame.add(title);


		startFrame.getContentPane().validate();
		startFrame.repaint();

		startFrame.setVisible(true);
		startFrame.setLayout(null);
		startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}*/

	/*void titleAnimate(){
		int speed = 120; 
		ActionListener moveText = new ActionListener() {
			int count = 0;
			public void actionPerformed(ActionEvent evt) {
				if(count == 2) { 
					((Timer)evt.getSource()).stop();
				}

				title.setLocation((title.getLocationOnScreen().x+1),86);
				count++;
			}
		};

		new Timer(speed, moveText).start();

	}*/

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == startBut) {
			startFrame.setVisible(false);
			chooseFrame.setVisible(true);
		}	

		if (e.getSource() == loginBut) {
			Login l = new Login();
		}	

		if (e.getSource() == signupBut) {

			Signup s = new Signup();

		}	

		if (e.getSource() == doneSignBut) {
			signupFrame.setVisible(false);
			startFrame.setVisible(true);

		}

		if (e.getSource() == easyBut) {
			whichLevel = 1;

			Play play = new Play();

		}


		if (e.getSource() == mediumBut) {
			whichLevel = 2;
			Play play = new Play();

		}

		if (e.getSource() == hardBut) {
			whichLevel = 3;
			Play play = new Play();

		}

		if (e.getSource() == importBut) {
			whichLevel = 4;
			Play play = new Play();

		}

		else if(e.getSource() == backBut) {
			chooseFrame.setVisible(false);
			startFrame.setVisible(true);
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
	}


}
