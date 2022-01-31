import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.io.*;


public class Signup implements ActionListener{

	static String file = "accountInfo.txt";
	static String line;
	JTextField usernameText;
	JPasswordField passwordText;
	String user, pass;
	JButton finish;
	HashMap<String,String> signupInfo;
	Font buttonFont = new Font("Verdana", Font.BOLD+Font.ITALIC, 12);
	Font basicFont = new Font("Verdana", Font.BOLD+Font.ITALIC, 23);

	Signup() {
		JFrame signupFrame = new JFrame();
		signupInfo = new HashMap<>();
		usernameText = new JTextField("");
		passwordText = new JPasswordField("");
		finish = new JButton("Sign up");

		signupFrame.setSize(550,300);
		signupFrame.getContentPane().setBackground(Color.decode("#8e8475"));

		//store all the info from the text file into the hashmap

		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String username = "";
			String password = "";
			String splitInfo[];
			while ((line = reader.readLine()) != null) {
				//seperate the username and password from textfile
				//put information into hashmap
				splitInfo = line.split(" ");
				username = splitInfo[0];
				password = splitInfo[1];
				signupInfo.put(username, password);

			}


		} catch (Exception IOX) {
			JOptionPane.showMessageDialog(signupFrame, "Error, please restart program.");
		}

		JLabel username = new JLabel("USERNAME");
		username.setBounds(60,50,180,60);
		username.setFont(basicFont);
		username.setForeground(Color.white);
		signupFrame.add(username);

		JLabel password = new JLabel("PASSWORD");
		password.setBounds(60,120,180,60);
		password.setFont(basicFont);
		password.setForeground(Color.white);
		signupFrame.add(password);

		usernameText.setBounds(260,60,180,45);
		signupFrame.add(usernameText);

		passwordText.setBounds(260,130,180,45);
		signupFrame.add(passwordText);

		finish.setBounds(400,210,100,30);
		finish.setBackground(Color.decode("#a6a397"));
		finish.setBorder(BorderFactory.createLineBorder(Color.white, 5));
		finish.setForeground(Color.white);
		finish.setFont(buttonFont);
		finish.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				if (e.getSource() == finish) {
					String u = usernameText.getText();
					String p = passwordText.getText();

					//check if username is already taken
					if (signupInfo.containsKey(u) == true) {
						JOptionPane.showMessageDialog(signupFrame, "Username taken, please retry.");
						usernameText.setText("");
						passwordText.setText("");
					}

					else {
						signupInfo.put(u,p);

						//put the new account information into the text file
						try {
							BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
							writer.write(u + " " + p + "\n");

							writer.close();
							signupFrame.dispose();

						} catch (IOException iox) {
							JOptionPane.showMessageDialog(signupFrame, "Error, please retry.");

						}
					}
				}

			}
		}
				);

		signupFrame.add(finish);

		signupFrame.setLayout(null);
		signupFrame.setVisible(true);
		signupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
