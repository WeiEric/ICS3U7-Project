import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.io.*;

public class Signup implements ActionListener{

	static JFrame frame = new JFrame();
	static String file = "accountInfo.txt";
	static String line;
	public static JTextField usernameText = new JTextField();
	public static JPasswordField passwordText = new JPasswordField();
	static Font f = new Font("Verdana", Font.PLAIN, 22);
	static Font buttonf = new Font("Verdana", Font.PLAIN, 12);
	public static String user, pass;
	static JButton finish = new JButton();
	
	public static HashMap<String,String> signupInfo = new HashMap<>();

	public void makeAccount(JFrame signupFrame, JButton finish2) {
		
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
			JOptionPane.showMessageDialog(frame, "Error, please restart program.");
		}
		
		frame = signupFrame;
		finish = finish2;
		
		signupFrame.setSize(550,300);

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
		finish.addActionListener(new Signup());
		signupFrame.add(finish);

		signupFrame.setLayout(null);
		signupFrame.setVisible(true);
		signupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String u = usernameText.getText();
		String p = passwordText.getText();

		if (e.getSource() == finish) {
			signupInfo.put(u,p);
			
			//put the new account information into the text file
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
				writer.write("\n");
				writer.write(u);
				writer.write("\n");
				writer.write(p);
				
				writer.close();
			} catch (IOException iox) {
				JOptionPane.showMessageDialog(frame, "Error, please retry.");

			}
		}
		
	}

}	



