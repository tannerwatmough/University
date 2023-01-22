/*
 * Name: Tanner Watmough
 * Student ID: 3554951
 * Date: August 17, 2022
 * 
 * Program Name: Rodent.java
 * Program Purpose: Provides constructor for subclasses and it's various instance methods.
 * Version 1.0
 */

/*
 * DOCUMENTATION
 */

/*
 * 
 * <H2> Rodent Class </H2>
 * 
 * <H3> Purpose and Description </H3>
 * <P>
 * Provides various instance methods for child classes of Rodent.
 * </P>
 * 
 * <P>Program was written using Java 8.</P>
 * <P>Change to the directory containing the source code</P>
 * <P>Compile:    javac Rodent.java</P>
 * <P>Run:        Unable to run as it is a class file with no main() routine. See RodentTest.java to run program.
 */

/*
 * <H2>Classes</H2>
 * <P>
 * public class Rodent is the main public class for the application. It is the only class.
 * </P>
 *
 * <H2>Rodent Methods</H2>
 *<P>
 * public void allBehaviors() {<BR>
 * This method is an abstract method in this class as it will host all other class methods for easier
 * calls in child classes. 
 *</P>
  *<P>
 * public void bathroom() {<BR>
 * This method will print out the default bathroom message to standard output. Child classes
 * will override this method with their own messages.
 *</P>
  *<P>
 * public void eating() {<BR>
 * This method will print out the default eating message to standard output. Child classes
 * will override this method with their own messages.
 *</P>
  *<P>
 * public void drinking() {<BR>
 * This method will print out the default drinking message to standard output. Child classes
 * will override this method with their own messages.
 *</P>
  *<P>
 * public void sleeping() {<BR>
 * This method will print out the default sleeping message to standard output. Child classes
 * will override this method with their own messages.
 *</P>
  *<P>
 * public void running() {<BR>
 * This method will print out the default running message to standard output. Child classes
 * will override this method with their own messages.
 */

/*
 * 
 * <H2>Test Plan</H2>
 * 
 * <H3>Rodent</H3>
 * <P>
 * 1. Run the application.
 * EXPECTED:
 *   Will not run as it is a class without a main() routine.
 * ACTUAL:
 *   Does not run as it has no main() routine. 
 * </P>
 * <P>
 * 2. Good data cases:
 * EXPECTED:
 *  No user input. No main() routine to run. 
 * ACTUAL:
 *  No user input. No main() routine to run. 
 * </P>
 * <P>
 * 3. Bad data cases:
 * EXPECTED:
 *  No user input. No main() routine to run. 
 * ACTUAL:
 *  No user input. No main() routine to run. 
 * </P>
 */

// CODE

public class Rodent {
  // Originally I tried to call all of the functions here in allBehaviours() but
  // it overrides the subclass changes to the other subroutines.
  public void allBehaviours() {

  }

  public void bathroom() {
    System.out.println("Taking care of bathroom needs...");
  }

  public void eating() {
    System.out.println("Eating...");
  }

  public void drinking() {
    System.out.println("Drinking...");
  }

  public void sleeping() {
    System.out.println("Sleeping...");
  }

  public void running() {
    System.out.println("Running...");
  }

} // end of public class Rodent