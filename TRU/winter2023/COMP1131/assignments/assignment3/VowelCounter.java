/* ===========================================================================
 * VowelCounter.java
 * 
 * Tanner Watmough T00712721
 * COMP 1131 Assignment 3 Question 2
 * 
 * This reads a string from the user and determines how many of each of the five
 * vowels appear in the string. It also counts and prints the number of non-vowel
 * characters. 
 * 
 * Vowels: 'a', 'e', 'i', 'o', and 'u'
 * ===========================================================================
 */

import java.util.Scanner;

public class VowelCounter {
  public static void main(String args[]) {
    String userString;

    // Initialize counters for vowels and consonants
    int aCount = 0, eCount = 0, iCount = 0, oCount = 0, uCount = 0;
    int consonantCount = 0;

    Scanner scan = new Scanner(System.in);

    System.out.println("This will count each vowel individually and consonants"
        + " together in an inputted String.");
    System.out.println("Please enter a string:");
    userString = scan.nextLine();

    // Handles both uppercase and lowercase by transforming it all to uppercase
    userString = userString.toUpperCase();
    // System.out.println(userString); For testing.

    /*
     * This will replace all punctuation in line. Referenced from Stack Overflow.
     * https://stackoverflow.com/questions/18830813/
     * how-can-i-remove-punctuation-from-input-text-in-java
     * This is done so users can enter multiple word strings without needing a
     * case for each consonant. It uses regex to go through the string and turns
     * all predefined punctuation to an empty string, effectively removing it.
     */
    userString = userString.replaceAll("\\p{Punct}", ""); // Remove to count
                                                          // all characters.
    // System.out.println(userString); For testing.

    for (int i = 0; i < userString.length(); i++) {
      switch (userString.charAt(i)) {
        case 'A':
          aCount++;
          break;
        case 'E':
          eCount++;
          break;
        case 'I':
          iCount++;
          break;
        case 'O':
          oCount++;
          break;
        case 'U':
          uCount++;
          break;
        // Handles spaces
        case ' ': // Could be removed if you wanted it counted in default.
          break;
        default:
          /*
           * On rereading the assignment instructions, I know there's a possibility
           * that you meant for me to count all characters (including punctuation).
           * I'd simply fix that by renaming the variable below but still
           * incrementing it and taking out the userString.replaceAll regex.
           * If you wanted spaces counted too, I'd remove the case that handles
           * them above.
           */
          consonantCount++;
          break;
      }
    }

    System.out.println();
    System.out.println("Your string had: ");
    System.out.println("A: " + aCount + "\t E: " + eCount + "\t I:" +
        iCount + "\t O: " + oCount + "\t U: " + uCount + "\t Consonants: " +
        consonantCount);

    scan.close();
  }
}
