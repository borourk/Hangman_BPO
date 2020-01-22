import java.io.*;
/** This class executes commands to run a simple game of Hangman with the user
 * 
 * @author benjaminorourk
 * @version 1.0
 * Project 1
 * Spring/2020
 */
public class HangmanApplication {
	public static void main(String[] args) throws IOException{

		Hangman hangman = new Hangman();
		hangman.playGame();
	}//end main method
}//end class
