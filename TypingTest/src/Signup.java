
import java.awt.Font;
import java.awt.event.*;
import java.util.HashMap;
import java.io.*;

import javax.swing.*;

public class Signup implements ActionListener{

	//static JFrame frame = new JFrame();
	static String file = "accountInfo.txt";
	static String line;
	public JTextField usernameText;
	public JPasswordField passwordText;
	Font f = new Font("Verdana", Font.PLAIN, 22);
	Font buttonf = new Font("Verdana", Font.PLAIN, 12);
	public String user, pass;
	JButton finish;// = new JButton();


	public HashMap<String,String> signupInfo;

	Signup() {
		JFrame signupFrame = new JFrame();
		signupInfo = new HashMap<>();
		usernameText = new JTextField("");
		passwordText = new JPasswordField("");
		finish = new JButton("Close");

		signupFrame.setSize(550,300);

		//store all the info from the text file into the hashmap
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			int numLines = 0;
			String readUser = "";
			String readPass = "";
			while ((line = reader.readLine()) != null) {
				numLines++;
				if(numLines == 1) {
					readUser = line;
				}
				else {
					readPass = line;
				}

				signupInfo.put(readUser, readPass);
				numLines = 0;
			}

		} catch (Exception IOX) {
			JOptionPane.showMessageDialog(signupFrame, "Error, please restart program.");
		}



		JLabel username = new JLabel("USERNAME");
		username.setBounds(60,50,180,60);
		username.setFont(f);
		signupFrame.add(username);

		JLabel password = new JLabel("PASSWORD");
		password.setBounds(60,120,180,60);
		password.setFont(f);
		signupFrame.add(password);

		usernameText.setBounds(260,60,180,45);
		signupFrame.add(usernameText);

		passwordText.setBounds(260,130,180,45);
		signupFrame.add(passwordText);

		finish.setBounds(400,210,100,30);
		finish.setFont(buttonf);
		finish.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				if (e.getSource() == finish) {
					String u = usernameText.getText();
					String p = passwordText.getText();
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

				//signupFrame.dispose();
			}
		});

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
