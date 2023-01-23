/* My program. TextIO for the input from the user. User input with it is automatically string so it must be
* converted to double (for the decimal points in change). The total amount of coins needs to be multiplied by
* its fractional value of a dollar, the end display amount. The correct dollar amount of each coin is then 
* added and displayed in a format with as many numbers as needed and with the local regions normal number 
* spacing, commas in North America for example. 
*/

import textio.TextIO;

public class ChangeCalculator {

    public static void main(String[] args) {
        String quarters;
        String dimes;
        String nickels;
        String pennies;
        double totalmoney;

        System.out.println("Welcome! This program will calculate how much money you have in change!");
        System.out.println("How many quarters do you have?: ");
        quarters = TextIO.getln();
        System.out.println("How many dimes do you have?: ");
        dimes = TextIO.getln();
        System.out.println("How many nickels do you have?: ");
        nickels = TextIO.getln();
        System.out.println("How many pennies do you have?: ");
        pennies = TextIO.getln();

        double quartersdb = Double.parseDouble(quarters);
        double dimesdb = Double.parseDouble(dimes);
        double nickelsdb = Double.parseDouble(nickels);
        double penniesdb = Double.parseDouble(pennies);

        quartersdb = quartersdb * 0.25;
        dimesdb = dimesdb * 0.10;
        nickelsdb = nickelsdb * 0.05;
        penniesdb = penniesdb * 0.01;

        totalmoney = quartersdb + dimesdb + nickelsdb + penniesdb;
        System.out.print("The total amount of change you have is:  ");
        System.out.printf("$%,1.2f", totalmoney);

    }
}

// EXERCISE PROMPT
// Write a program that helps the user count his change. The program should ask
// how many quarters the user has, then how many dimes, then how many nickels,
// then how many pennies. Then the program should tell the user how much money
// he has, expressed in dollars.

// DISCUSSION

// The program will need variables to represent the number of each type of coin.
// Since the number of coins has to be an integer, these variables are of type
// int. I'll call the variables quarters, dimes, nickels, and pennies.

// The total value of the coins, when expressed in dollars, can be a non-integer
// number such as 1.57 or 3.02. Since the total value in dollars is a real
// number, I will use a variable of type double to represent it. The variable is
// named dollars

// The outline of the program is clear enough:

// Declare the variables.
// Ask the user for the number of each type of coin, and read the responses.
// Compute the total value of the coins, in dollars.
// Display the result to the user.
// The function TextIO.getlnInt() can be used to read each of the user's
// responses. The alternative function TextIO.getInt() could also be used, but
// it is less safe. Suppose, for example, that the user responds to the request
// to type in the number of quarters by entering "7 quarters". After
// TextIO.getlnInt() reads the number 7, it will discard the extra input
// "quarters". TextIO.getInt() will read the 7 correctly, but the extra input is
// not discarded. Later, when the program tries to read the number of dimes, it
// sees the left-over input and tries to read that, without giving the user a
// chance to type in another response. You might want to experiment and see what
// happens if you change getlnInt() to getInt(). (Of course, if the user's
// response is "I have 7 quarters" or "seven", then you are out of luck in any
// case.)

// Since one quarter is worth 0.25 dollars, the number of dollars in N quarters
// is 0.25*N. Similarly, a dime is worth 0.10 dollars, a nickel is 0.05 dollars,
// and a penny is 0.01 dollars. So, to get the total value of all the user's
// coins, I just have to add up (0.25*quarters) + (0.10*dimes) + (0.05*nickels)
// + (0.01*pennies). This value is assigned to the variable, dollars, and that
// is the result that is displayed to the user. Formatted output, using
// System.out.printf, can be used to specify that the output value should be
// printed with two digits after the decimal point.

// Alternatively, I could first have computed the total number of cents in all
// the coins, and then divided by 100 to convert the amount into dollars:

// int totalCents; // Total number of cents in the coins.

// totalCents = 25*quarters + 10*dimes + 5*nickels + pennies;
// dollars = totalCents/100.0;
// Since totalCents is of type int, it is essential here that I compute dollars
// as totalCents/100.0 and not as totalCents/100. The value computed by
// totalCents/100 is an integer. For example, if totalCents is 397, then
// totalCents/100 is 3. Using totalCents/100.0 forces the computer to compute
// the answer as a real number, giving 3.97.

// A second version of the program, using a Scanner for input, is also given.
// (See Subsection 2.4.6.) A Scanner named stdio is created, and integers are
// read using the function stdio.nextInt(). This method corresponds to
// TextIO.getInt(), not TextIO.getlnInt(). To get something equivalent to
// TextIO.getlnInt(), we can follow the call to stdio.nextInt() with a call to
// stdio.nextLine(). The call to stdio.nextLine() will read and discard any
// extra characters on the same line after the integer that was read by
// stdio.nextInt(). If you are not worried about the user typing extra stuff on
// a line, you can leave out the calls to stdio.nextInt().

// TEXTBOOK SOLUTION - TEXTIO
// import textio.TextIO;

// public class CountChange {

// /* This program will add up the value of a number of quarters,
// dimes, nickels, and pennies. The number of each type of
// coin is input by the user. The total value is reported
// in dollars. This program depends on the non-standard class,
// TextIO.
// */

// public static void main(String[] args) {

// int quarters; // Number of quarters, to be input by the user.
// int dimes; // Number of dimes, to be input by the user.
// int nickels; // Number of nickels, to be input by the user.
// int pennies; // Number of pennies, to be input by the user.

// double dollars; // Total value of all the coins, in dollars.

// /* Ask the user for the number of each type of coin. */

// System.out.print("Enter the number of quarters: ");
// quarters = TextIO.getlnInt();

// System.out.print("Enter the number of dimes: ");
// dimes = TextIO.getlnInt();

// System.out.print("Enter the number of nickels: ");
// nickels = TextIO.getlnInt();

// System.out.print("Enter the number of pennies: ");
// pennies = TextIO.getlnInt();

// /* Add up the values of the coins, in dollars. */

// dollars = (0.25 * quarters) + (0.10 * dimes)
// + (0.05 * nickels) + (0.01 * pennies);

// /* Report the result back to the user. */

// System.out.println();
// System.out.print("The total in dollars is $");
// System.out.printf("%1.2f", dollars); // Formatted output!
// System.out.println();

// } // end main()

// } // end class

// TEXTBOOK SOLUTION - SCANNER
// import java.util.Scanner;

// public class CountChangeWithScanner {

// public static void main(String[] args) {

// int quarters; // Number of quarters, to be input by the user.
// int dimes; // Number of dimes, to be input by the user.
// int nickels; // Number of nickels, to be input by the user.
// int pennies; // Number of pennies, to be input by the user.

// Scanner stdio = new Scanner( System.in );

// double dollars; // Total value of all the coins, in dollars.

// /* Ask the user for the number of each type of coin. */

// System.out.print("Enter the number of quarters: ");
// quarters = stdio.nextInt();
// stdio.nextLine();

// System.out.print("Enter the number of dimes: ");
// dimes = stdio.nextInt();
// stdio.nextLine();

// System.out.print("Enter the number of nickels: ");
// nickels = stdio.nextInt();
// stdio.nextLine();

// System.out.print("Enter the number of pennies: ");
// pennies = stdio.nextInt();
// stdio.nextLine();

// /* Add up the values of the coins, in dollars. */

// dollars = (0.25 * quarters) + (0.10 * dimes)
// + (0.05 * nickels) + (0.01 * pennies);

// /* Report the result back to the user. */

// System.out.println();
// System.out.print("The total in dollars is $");
// System.out.printf("%1.2f", dollars); // Formatted output!
// System.out.println();

// } // end main()

// } // end class