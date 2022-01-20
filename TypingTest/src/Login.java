
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;

import javax.swing.*;

public class Login implements ActionListener{

	static String file = "accountInfo.txt";
	static String line;
	public JTextField usernameText;
	public JPasswordField passwordText;
	Font f = new Font("Verdana", Font.PLAIN, 22);
	Font buttonf = new Font("Verdana", Font.PLAIN, 12);
	public String user, pass;
	JButton done;
	public HashMap<String,String> loginInfo;


	Login() {
		JFrame loginFrame = new JFrame();
		loginInfo = new HashMap<>();
		usernameText = new JTextField("");
		passwordText = new JPasswordField("");
		done = new JButton("Login");

		loginFrame.setSize(550,300);

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
				loginInfo.put(username, password);

			}

		} catch (Exception IOX) {
			JOptionPane.showMessageDialog(loginFrame, "Error, please restart program.");
		}

		JLabel username = new JLabel("USERNAME");
		username.setBounds(60,50,180,60);
		username.setFont(f);
		loginFrame.add(username);

		JLabel password = new JLabel("PASSWORD");
		password.setBounds(60,120,180,60);
		password.setFont(f);
		loginFrame.add(password);

		usernameText.setBounds(260,60,180,45);
		loginFrame.add(usernameText);

		passwordText.setBounds(260,130,180,45);
		loginFrame.add(passwordText);

		done.setBounds(400,210,100,30);
		done.setFont(buttonf);
		done.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				if (e.getSource() == done) {
					String u = usernameText.getText();
					String p = passwordText.getText();

					//check if the username exists 
					if(loginInfo.containsKey(u)) {
						if((loginInfo.get(u).equals(p))) { //check if password is equal to the id
							JOptionPane.showMessageDialog(loginFrame, "Login successful!");
							loginFrame.dispose();
						}
						else {
							JOptionPane.showMessageDialog(loginFrame, "Login unsuccessful.");
						}
					}

					else {
						JOptionPane.showMessageDialog(loginFrame, "Login unsuccessful.");
					}

				}

			}
		}
				);

		loginFrame.add(done);

		loginFrame.setLayout(null);
		loginFrame.setVisible(true);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
