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

public class Shape {

  public Shape circle;

  public void area() {
    System.out.println("I'm the base area calculation for Shape.");
  }

  public void circumference() {
    System.out.println("I'm the base circumference calculation for Shape.");
  }

  public void boundingBox() {
    System.out.println("I'm a bounding rectangle around the shape's points");
  }

  public void display(Shape shapeArg) {
    if (shapeArg == circle) {
      shapeArg.circumference();
    }
    shapeArg.area();
    shapeArg.boundingBox();
  }

} // end of public class Shape