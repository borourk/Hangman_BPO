
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
/** This code initiates the game Hangman and records the users wins and losses
 * 
 * @author benjaminorourk
 * @version 1.0
 * Project 1
 * Spring/2020
 */
	public class Hangman {
			
		private int rdWins = 0;//Wins per round
		private int rdLosses = 0;//Losses per round
		private int W;//Total amount of Wins throughout the game
		private int L;//Total amount of Losses throughout the game
		private String currentWord;//Value of the random word selected from the dictionary
		private Dictionary dt = new Dictionary();//Dictionary object to select word
		/**
		 * @throws IOException
		 */
	public Hangman() throws IOException{ 
		currentWord = dt.chooseWord();
	}//end constructor
	/**
	 * Loads user's win/loss record from file
	 * @throws IOException
	 */
	private void loadWL() throws IOException{ 
		Scanner fileScan = new Scanner(new File("Hangman.txt"));
		while (fileScan.hasNextInt()) {
			int win = fileScan.nextInt();
			int loss = fileScan.nextInt();
			System.out.println("All time number of wins: " + win + " All time number of losses: " + loss);
		}
	}//end loadWL
	/** 
	 * Converts user's total win/loss record to a file.
	 * @throws IOException
	 */
	private void writeWL() throws IOException{ 
		Scanner fileScan = new Scanner(new File("Hangman.txt"));
		int win = fileScan.nextInt();
		int loss = fileScan.nextInt();
		int totalWin = win + W;
		int totalLoss = loss + L;
		FileWriter wr = new FileWriter("Hangman.txt", false);
		wr.write(" " + totalWin + " " + totalLoss);
		wr.close();
	}//end writeWL
	/**
	 * Implements loop for the main game.
	 * @throws IOException
	 */
	public void playGame() throws IOException{
		int guesses = 5;
		ArrayList<Character> word = new ArrayList<Character>();
		for(int j = 0; j < currentWord.length(); j++)
			word.add('_');
		Scanner scan = new Scanner(System.in);
		System.out.println("\tWould You Like to Play Hangman Y/N?");
		char chr = scan.next().charAt(0);
		while(chr == 'Y' || chr == 'y'){ //Loop for the game
			W = 0;
			L = 0;
			System.out.println("\nYou have " + guesses + " incorrect guesses left.");{
			if (guesses > 0)
				for(int i = 0; i < word.size(); i++){
					System.out.print(word.get(i) + " ");
				}
				System.out.print("\nWhat is your guess? ");
				String guessWord = scan.next();
				if (guessWord.equals(currentWord)){
				rdWins++;
				W++;
				System.out.println("\nYou guessed the correct word! You won!");
				System.out.println("You have won " + rdWins + " times this round. You have lost " + rdLosses + " times this round.");
				writeWL();
				loadWL();
				System.out.println("\n\tWould You Like to Play Again? Y/N?");
				chr = scan.next().charAt(0);
				currentWord = dt.chooseWord();
				word.clear();
				for(int i = 0; i < currentWord.length(); i++)
					word.add('_');
				guesses = 5;
				}
				else{
					char guess = guessWord.charAt(0);
					int g = 0;
					for(int k = 0; k < currentWord.length(); k++) {
						if (guess == currentWord.charAt(k)) {
							word.set(k, guess);
							g++;
						}
					}
					if(g == 0){
						guesses --;
					}
					String wordCheck = "";
					for (Character i : word){
						wordCheck += i;
					}
					if (wordCheck.equals(currentWord)){
						System.out.println("\n" + currentWord);
						rdWins++;
						W++;
						System.out.println("\nYou won!");
						System.out.println("You have won " + rdWins + " times this round. You have lost " + rdLosses + " times this round.");
						writeWL();
						loadWL();
						System.out.println("\n\tWould You Like to Play Again? Y/N?");
						chr = scan.next().charAt(0);
						currentWord = dt.chooseWord();
						word.clear();
						for(int l = 0; l < currentWord.length(); l++)
						word.add('_');
						guesses = 5;
					}
				}
			}
			else {
				rdLosses++;
				L++;
				System.out.println("\nYou are out of guesses. You lost.\nThe word was " + currentWord);
				System.out.println("You have won " + rdWins + " times this round. You have lost " + rdLosses + " times this round.");
				writeWL();
				loadWL();
				System.out.println("\n\tWould You Like to Play Again? Y/N?");
				chr = scan.next().charAt(0);
				currentWord = dt.chooseWord();
				word.clear();
				for(int l = 0; l < currentWord.length(); l++)
					word.add('_');
				guesses = 5;
				}
			}
			if(chr != 'Y' || chr != 'y'){
				System.out.println("\n\t<<END>>");
			}
	}//playGame
}//end class

