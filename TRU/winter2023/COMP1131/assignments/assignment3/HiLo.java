/* ===========================================================================
 * HiLo.java
 * 
 * Tanner Watmough T00712721
 * COMP 1131 Assignment 3 Question 1
 * 
 * This application plays a High-Low guessing game with the computer picking
 * random numbers between 1 and 100 (inclusive), then prompting the user to 
 * guess. It will prompt the user if their guess was high or low and let them
 * quit at any point. 
 * 
 * The user will be allowed to guess until they get it right or quit. 
 * 
 * The number of guesses are counted unless they are out of range and they will 
 * be told so. 
 * 
 * Guesses value reported to user when they get the correct answer.
 * 
 * At the end of each game, either when quitting or correctly guessing, prompt 
 * the user if they wish to play again. 
 * 
 * ===========================================================================
 */

import java.util.*;

public class HiLo {
  public static void main(String[] args) {
    /*
     * Idea of MAX taken from textbook example of Guessing. This is the more
     * robust solution for easily changing program parameters.
     */
    final int MAX = 100;
    int answer, guess, numOfGuesses;
    String replay = "y";

    Scanner scan = new Scanner(System.in);
    Random generator = new Random();

    // Lets lowercase or uppercase y restart the game.
    while (replay.equalsIgnoreCase("y")) {
      // Reset guesses to make nested while loop true again.
      guess = -1;

      // Reset number of guesses to 0 for new games.
      numOfGuesses = 0;

      // Generates a random number between 0 and the MAX - 1.
      answer = generator.nextInt(MAX) + 1;

      System.out.print("I'm thinking of a number between 1 and " + MAX +
          ". Guess what it is. Enter 0 to quit at anytime: ");

      // Allows continuous guessing until answer is guessed or user quits.
      while (guess != answer && guess != 0) {
        guess = scan.nextInt();

        // Presents number of guesses when user gets correct and prompts replay
        if (guess == answer) {
          System.out.println("You got it! Good guessing!");
          numOfGuesses++;
          System.out.println("You got the answer in " + numOfGuesses + " guesses.");
        } // makes sure guess is less than the answer but not below 1.
        else if (guess < answer && guess > 0) { //
          System.out.println("The answer is higher than " + guess + "! Guess again.");
          numOfGuesses++;
        } // makes sure guess is greater than the answer but not above 100.
        else if (guess > answer && guess <= 100) {
          System.out.println("The answer is lower than " + guess + "! Guess again.");
          numOfGuesses++;
        } else if (guess == 0) {
          // Required so the out of range message doesn't print.
          System.out.println("Quitting round");
        }
        // Covers out of range guesses. numOfGuesses not incremented.
        else {
          System.out.println("Your guess was out of range. Please guess between 1" +
              " and 100 or type 0 to quit.");
        }

      }

      // Checks if user wishes to replay. Will replay if they enter 'y' or 'Y'
      System.out.println("Would you like to play again? (y/n): ");

      replay = scan.next();
    }

    scan.close();
  }
}