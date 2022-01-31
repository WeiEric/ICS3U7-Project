
import java.io.*;
/**
 * Class Import
 * Imports text
 * @author author
 *
 */
public class Import {

	/**
	 * reads the first line of text from the specified plain text document
	 * @param fileName Name of the text file where text is located
	 * @return the first line of the specified text document. If document does not exist, returns string "Something Went Wrong :P"
	 */
	public static String getText(String fileName) {

		String text;
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			text = in.readLine();
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			text = "Something Went Wrong :P";
			e.printStackTrace();
		}

		return text;

	}

}
