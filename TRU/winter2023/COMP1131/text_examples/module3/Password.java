/* ============================================================================
 * Password.java
 * Author: Tanner Watmough
 * 
 * This program checks a user's password to see if passes the tests of:
 *  - At least 7 characters long
 *  - Contains both upper and lower case alphabetical characters
 *  - Contains at least 1 digit
 * ============================================================================
 */

import java.util.Scanner;

public class Password {
  public static void main(String[] args) {
    String userPassword;
    boolean goodPassword = false;

    Scanner scan = new Scanner(System.in);

    // Continues to prompt for password until it passes all checks
    while (!goodPassword) {
      // User password input
      System.out.println("Enter your password: ");
      userPassword = scan.nextLine();

      /*
       * Reinitialize checks for each password so you don't have partial passes
       * accumulate into a full pass.
       */
      int check = 0;

      // Checks if password length is greater than 6 characters.
      if (userPassword.length() > 6) {
        check++;
        System.out.println("Passed length");
      }

      /*
       * Checks to make sure userPassword isn't the same as both lowercase and
       * uppercase values. This ensures at least one upper and one lowercase
       * character in the password.
       */
      if (!userPassword.equals(userPassword.toLowerCase()) &&
          !userPassword.equals(userPassword.toUpperCase())) {
        check++;
        System.out.println("Passed upper and lowercase");
      }

      // Initializes boolean for digit check
      boolean isDigit = false;

      // Checks if the string contains at least one digit 0-9.
      for (int i = 0; i < userPassword.length(); i++) {
        if (userPassword.charAt(i) == '0' || userPassword.charAt(i) == '1' ||
            userPassword.charAt(i) == '2' || userPassword.charAt(i) == '3' ||
            userPassword.charAt(i) == '4' || userPassword.charAt(i) == '5' ||
            userPassword.charAt(i) == '6' || userPassword.charAt(i) == '7' ||
            userPassword.charAt(i) == '8' || userPassword.charAt(i) == '9') {
          isDigit = true;
        }
      }

      /*
       * If check found digit, it's made true and increments check.
       * This is required as if I incremented for each digit found, you could
       * have a password pass solely on containing at least 3 digits.
       */
      if (isDigit) {
        check++;
        System.out.println("Passed digit requirement");
      }

      // If check passed all three requirements, exit loop.
      if (check < 3) {
        System.out.println("That password is not acceptable");
      } else {
        goodPassword = true;
      }
    }

    // If loop exits, you have a good password.
    System.out.println("Acceptable password");

    scan.close();
  }
}