import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.*;

public class Dictionary {
	
	private String[] wordList = new String[212];
	private SecureRandom randomNumbers;
	
	public Dictionary() throws IOException {
		readFile();	
	}//end first constructor
	private void readFile() throws IOException {
		Scanner fileScan = new Scanner(new File("Hangman.txt"));
		for(int i = 0; i < 212; i++) {
			wordList[i] = fileScan.next();
		}
	}//end readFile
	public String chooseWord() throws IOException{
		int randomNumber;
	}//end chooseWord
	
}//end class
