/* ===========================================================================
 * NameTransform.java
 * 
 * Tanner Watmough T00712721
 * COMP 1131 Assignment 2 Question 1
 * 
 * This application prompts and reads user's first and last name (separately),
 * then displays a string composed of the first four characters of the user
 * last name, followed by the first two letters of user first name, and followed
 * by a random number in range of 10 to 99. 
 * ===========================================================================
 */

import java.util.*;

public class NameTransform {

  public static void main(String[] args) {
    int randomNumber = 0;
    boolean prompt = true;
    // Compiler error if not "initialized" (no String objects are created)
    String fName = null, lName = null;
    // Creates a new pseudorandom number generator
    Random rand = new Random();
    Scanner scan = new Scanner(System.in);

    System.out.println("Account Name Generator");

    // Creates loop so user cannot enter empty string
    while (prompt) {
      // Prompts user for first and last name
      System.out.print("Please enter your first name: ");
      fName = scan.nextLine(); // nextLine in case user has two first names.
      System.out.print("Please enter your last name: ");
      lName = scan.nextLine();
      System.out.println();

      // Exits loop if fName isn't empty and lName is at least four characters.
      if (fName.length() != 0 && lName.length() > 4) {
        prompt = false;
        break; // doesn't run through error messages
      }

      // Gives hints for why they must reenter their names.
      if (fName.length() == 0) {
        System.out.println("First Name must be at least one character.");
      }
      if (lName.length() < 4) {
        System.out.println("Last Name must be at least four characters.");
      }

      System.out.println();
    }

    scan.close();

    // Last name shortened to first 4 chars (min. 4 chars assumed)
    lName = lName.substring(0, 4);

    // First name shortened to first 2 chars
    if (fName.length() < 2) {
      /*
       * This is done because the assignment does not specify a minimum of
       * 2 characters can be assumed for first name. While exceedingly rare,
       * 1 character names are possible.
       */
      fName = fName.substring(0, 1);
    } else {
      fName = fName.substring(0, 2);
    }

    // Assigns random number between 10 and 99 (inclusive)
    randomNumber = rand.nextInt(90) + 10; // 0-89 generated, 10 added for 10-99

    // Display Results
    System.out.println(lName + fName + randomNumber);

    /*
     * Alternatively, you could remove randomNumber and do the rand.nextInt in
     * the system print out statement. Like so:
     * System.out.println(lName + fName + (rand.nextInt(90) + 10));
     */
  }
}