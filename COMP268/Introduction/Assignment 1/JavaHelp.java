/*
 * Name: Tanner Watmough
 * Student ID: 3554951
 * Date: July 26, 2022
 * 
 * Program Name: JavaHelp.java
 * Program Purpose: Works as a terminal menu that allows users to select an option from a menu of help
 * options. It covers common Java terms used in programming and gives a definition and reference link. 
 * Version 1.0
 */

/*
 * DOCUMENTATION
 */

/*
 * The main program runs a Java Help Menu.
 * 
 * <H2> Java Help </H2>
 * 
 * <H3> Purpose and Description </H3>
 * <P>
 * This works as a Terminal menu that allows the user to select an option from a menu of help
 * options. It covers common Java terms used in programming and gives a definiton and reference
 * link.
 * </P>
 * 
 * <P>Program was written using Java 8.</P>
 * <P>Change to the directory containing the source code</P>
 * <P>Compile:    javac JavaHelp.java</P>
 * <P>Run:        java JavaHelp</P>
 */

/*
 * <H2>Classes</H2>
 * <P>
 * public class JavaHelp is the main public class for the application. It is the only class.
 * </P>
 *
 * <H2>JavaHelp Methods</H2>
 *<P>
 * public static void main(String[] args) {<BR>
 * This method is used to execute the applicaiton.
 * This method executes Problem 4's Java Help menu. It will display a list of options to the user and will
 * display definitions for various Java terms to the console. The user will be able to ask for as many definitions
 * as they want until they enter the exit option. 
 *</P>
 *<P>
 * public static void helpMenu() {<BR>
 * This method will display the helpMenu for when Problem 4's subroutine, javaHelp(), is called. While it
 * could be implemented within javaHelp(), I find this way makes the code cleaner, but I'm open to feedback!
 *</P>
 */

/*
 * 
 * <H2>Test Plan</H2>
 * 
 * <H3>Problem 4</H3>
 * <P>
 * 1. Run the application.
 * EXPECTED:
 *   Terminal should display printed statements. User should be able to input to terminal: 
 *   Java Help Menu
 *   Select Help on:
 *       1.   If
 *       2.   Switch
 *       3.   For
 *       4.   While
 *       5.   Do-while
 *       x.   Exit
 * 
 *   Selection:
 * ACTUAL:
 *   Menu options display as expected and user can input to terminal. 
 * </P>
 * <P>
 * 2. Good data cases:
 * EXPECTED:
 *   Run the following test cases by typing the input value and pressing enter:
 *   1 -> if definition should be displayed and user allowed to select another option after.
 *   2 -> switch definition should be displayed and user allowed to select another option after.
 *   3 -> for definition should be displayed and user allowed to select another option after.
 *   4 -> while definition should be displayed and user allowed to select another option after.
 *   5 -> do-while definition should be displayed and user allowed to select another option after.
 *   x -> Exits subroutine back to main program menu. 
 * ACTUAL:
 *  Successfully displays all definitions, redisplays menu, and allows user to select another option unless 
 *  x is chosen which will exit the subroutine and return to the main program.
 * </P>
 * <P>
 * 3. Bad data cases:
 * EXPECTED:
 *   Run the following test cases by typing the input value and pressing enter:
 *   'z' -> output should display an error message and the menu options again and not crash. 
 * ACTUAL:
 *   Displays error message for invalid values, displays the menu again, and lets the user input another value.
 * </P>
 */

// CODE

// Packages for Scanner
import java.util.Scanner;

public class JavaHelp {

  public static void main(String[] args) {

    String choice;

    choice = "1";

    while (choice != "x") {
      Scanner input = new Scanner(System.in);

      helpMenu();

      /*
       * Today I learned implementing a string menu is 1000x easier
       * then an integer menu as integer vs. string numbers work
       * the same but allow almost any input without error exceptions.
       */

      choice = input.next();
      System.out.println();

      switch (choice) {
        case "1":
          System.out.print("if: ");
          System.out.println(
              "Use of the if statement to specify a block of Java code to be executed if a condition is true. It a control statement for the flow of a program.");
          System.out.println("Reference: https://www.w3schools.com/java/java_conditions.asp ");
          System.out.println();
          break;
        case "2":
          System.out.print("switch: ");
          System.out.println(
              "Use of the switch statement to select one of many code blocks to be executed. The switch expression is evaluated once, the value compared to the values of each case, and if there is a match, the associated block of code is executed.");
          System.out.println("Reference: https://www.w3schools.com/java/java_switch.asp ");
          System.out.println();
          break;
        case "3":
          System.out.print("for: ");
          System.out.println(
              "When you know exactly how many times you want to loop, or repeat, a block of code, use the for loop instead of a while loop. You can use special syntax in the for loop. for(statement 1; statement 2; statement 3) where statement 1 is executed one time usually to initialize the variable. The second statement defines the condition for executing the code block and if the condition is no longer true, the loop stops. Statement 3 is executed every time after the code block has been executed and is generally used to increment the variable to eventually break the loop.");
          System.out.println("Reference: https://www.w3schools.com/java/java_for_loop.asp ");
          System.out.println();
          break;
        case "4":
          System.out.print("while: ");
          System.out.println(
              "Loops can execute a block of code as long as a specified condition is reached. They save time, reduce errors, and make code more readable. The while loop loops through a block of code as long as a specified condition is true. ");
          System.out.println("Reference: https://www.w3schools.com/java/java_while_loop.asp ");
          System.out.println();
          break;
        case "5":
          System.out.print("do-while: ");
          System.out.println(
              "The do/while loop is a variant of the while loop. The loop will execute the code block once, always, before checking if the condition is true or false. It will then repeat the loop as long as the condition is true.");
          System.out.println("Reference: https://www.w3schools.com/java/java_while_loop.asp ");
          System.out.println();
          break;
        case "x":
          System.out.println("Thank you! Goodbye.");
          System.out.println();
          choice = "x";
          input.close();
          break;
        // Error message
        default:
          System.out.println("Error! Invalid entry, please try again with a value between 1-5 or x.");
      }
    }
  } // end of main

  public static void helpMenu() {
    /*
     * Display menu options. The subroutine was made to limit repetition and so the
     * user doesn't forget option choices if the console output becomes too
     * crowded.
     */
    System.out.println("Java Help Menu");
    System.out.println("Select Help on:");
    System.out.println("    1.   If");
    System.out.println("    2.   Switch");
    System.out.println("    3.   For");
    System.out.println("    4.   While");
    System.out.println("    5.   Do-while");
    System.out.println("    x.   Exit");
    System.out.println();
    System.out.print("Selection: ");
  } // end of helpMenu()

} // end of public class JavaHelp