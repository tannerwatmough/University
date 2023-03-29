
/* ===========================================================================
 * BugDriver.java
 * 
 * Tanner Watmough T00712721
 * COMP 1131 Assignment 4 Question 1
 * 
 * This is a simple driver for the Bug class. It allows the user to interact
 * with a Bug object to move and turn it along a 2D horizonstal axis. The
 * toString method will print the current position and direction the bug is
 * facing. 
 * 
 * Finally the user has the option to exit.
 * ===========================================================================
 */
import java.util.Scanner;

public class BugDriver {
  public static void main(String[] args) {
    boolean run = true;
    String userInput;

    // Creates a new Bug object and Scanner
    Bug bug = new Bug();
    Scanner scan = new Scanner(System.in);

    System.out.println("Bug Mover");
    // Support method to print all commands the bug will take.
    // It is in the driver because the driver implements the commands and
    // simply acts on the Bug object.
    commands();

    // Keeps the program running until the user decides to quit.
    while (run) {
      userInput = scan.next();

      // An input "safe" way as all input is treated as String so no
      // type mismatch errors should occur.
      switch (userInput) {
        // Calls the bug object's move method to increment or decrement position
        case "m":
          bug.move();
          break;
        // Calls the bug object's turn method to reverse directions.
        case "t":
          bug.turn();
          break;
        // Outputs current position and direction of current bug object.
        case "o":
          System.out.println(bug);
          break;
        // Outputs current position and direction graphically to output.
        case "g":
          bug.graphicOutput();
          break;
        // Calls commmands method to give user the valid commands list.
        case "c":
          commands();
          break;
        // Unlisted command to setPosition of Bug on wire. Used for testing.
        case "setPos":
          System.out.print("Enter position value: ");
          int pos = scan.nextInt();
          bug.setPosition(pos);
          break;
        // Quit program.
        case "q":
          run = false;
          System.out.println("Exiting program...");
          break;
        // For invalid user input. Prompts user to call the commands method
        default:
          System.out.println("Invalid entry. Type 'c' for commands.");
          break;
      }
    }

    scan.close();
  }

  // Commands method simply outputs user friendly commands list with what each
  // command does.
  private static void commands() {
    System.out.println("Type 'm' to move");
    System.out.println("Type 't' to turn directions");
    System.out.println("Type 'o' to output current position and direction");
    System.out.println("Type 'g' for \"graphical\" output");
    System.out.println("Type 'c' for commands");
    System.out.println("Type 'q' to quit.");
  }
}