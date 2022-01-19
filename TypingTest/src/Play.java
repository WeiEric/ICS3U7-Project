

import java.io.*;

import javax.swing.JLabel;

public class Play {

	// level selector
	public static int whichLevel;



	/*	
	// import sentences
	public void importText(JLabel easyText, JLabel mediumText, JLabel hardText, String compareEasy, String compareMedium, String compareHard) {
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
	 */

	// testing sentences
	static JLabel easyText = new JLabel("The big ugly tree destroys the beauty of the house.");
	static JLabel mediumText = new JLabel("Once you join me, we can go visit the aquarium at the mall.");
	static JLabel hardText = new JLabel("He thought the movie was great except for the scene with the cantaloupe.");

	static String compareEasy = "The big ugly tree destroys the beauty of the house.";
	static String compareMedium = "Once you join me, we can go visit the aquarium at the mall.";
	static String compareHard = "He thought the movie was great except for the scene with the cantaloupe.";



	// timer
	static long startTime;
	static long endTime;
	static long duration;
	static long seconds;


}
