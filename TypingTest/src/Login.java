import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.io.*;

/**
 * Class Login, implements ActionListener
 * Logs user in based on information from accountInfo.txt
 * If username and password match one in accountInfo document, user is logged in
 * @author [ insert author here ]
 *
 */

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
	Font buttonFont = new Font("Verdana", Font.BOLD+Font.ITALIC, 12);
	Font basicFont = new Font("Verdana", Font.BOLD+Font.ITALIC, 23);


	Login() {
		JFrame loginFrame = new JFrame();
		loginInfo = new HashMap<>();
		usernameText = new JTextField("");
		passwordText = new JPasswordField("");
		done = new JButton("Login");

		loginFrame.setSize(550,300);
		loginFrame.getContentPane().setBackground(Color.decode("#8e8475"));

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
		username.setFont(basicFont);
		username.setForeground(Color.white);
		loginFrame.add(username);

		JLabel password = new JLabel("PASSWORD");
		password.setBounds(60,120,180,60);
		password.setFont(basicFont);
		password.setForeground(Color.white);
		loginFrame.add(password);

		usernameText.setBounds(260,60,180,45);
		loginFrame.add(usernameText);

		passwordText.setBounds(260,130,180,45);
		loginFrame.add(passwordText);

		done.setBounds(400,210,100,30);
		done.setBackground(Color.decode("#a6a397"));
		done.setBorder(BorderFactory.createLineBorder(Color.white, 5));
		done.setForeground(Color.white);
		done.setFont(buttonFont);
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
							usernameText.setText("");
							passwordText.setText("");
						}
					}
					
					else {
						JOptionPane.showMessageDialog(loginFrame, "Login unsuccessful.");
						usernameText.setText("");
						passwordText.setText("");
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
