/*
 * Name: Tanner Watmough
 * Student ID: 3554951
 * Date: August 17, 2022
 * 
 * Program Name: Hamster.java
 * Program Purpose: Provides constructor for Hamster and it's various instance methods.
 * Version 1.0
 */

/*
 * DOCUMENTATION
 */

/*
 * 
 * <H2> Hamster Class </H2>
 * 
 * <H3> Purpose and Description </H3>
 * <P>
 * Provides extended instance methods for Hamster. 
 * </P>
 * 
 * <P>Program was written using Java 8.</P>
 * <P>Change to the directory containing the source code</P>
 * <P>Compile:    javac Hamster.java</P>
 * <P>Run:        Unable to run as it is a class file with no main() routine. See RodentTest.java to run program.
 */

/*
 * <H2>Classes</H2>
 * <P>
 * public class Hamster is the main public class for the application. It is the only class.
 * </P>
 *
 * <H2>Hamster Methods</H2>
 *<P>
 * public void allBehaviors() {<BR>
 * This method calls all instance methods in one call. 
 *</P>
  *<P>
 * public void bathroom() {<BR>
 * This method will print out the extended Hamster bathroom message to standard output. It overrides the 
 * default Rodent() methods. 
 *</P>
  *<P>
 * public void eating() {<BR>
 * This method will print out the extended Hamster eating message to standard output. It overrides the 
 * default Rodent() methods. 
 *</P>
  *<P>
 * public void drinking() {<BR>
 * This method will print out the extended Hamster drinking message to standard output. It overrides the 
 * default Rodent() methods. 
 *</P>
  *<P>
 * public void sleeping() {<BR>
 * This method will print out the extended Hamster sleeping message to standard output. It overrides the 
 * default Rodent() methods. 
 *</P>
  *<P>
 * public void running() {<BR>
 * This method will print out the extended Hamster running message to standard output. It overrides the 
 * default Rodent() methods. 
 */

/*
 * 
 * <H2>Test Plan</H2>
 * 
 * <H3>Hamster</H3>
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

public class Hamster extends Rodent {

  public void bathroom() {
    int poopAmount = (int) (Math.random() * 150);
    System.out.println("Taking care of bathroom needs... The hamster pooped " + poopAmount + " pellets today.");
  }

  public void eating() {
    double foodAmount = (double) ((Math.random() * 6) + 6);
    // https://www.glenwayanimalhospital.com/sites/site-3808/documents/Hamster%20FAQ.pdf
    System.out.printf(
        "Eating... hamster pellets, veggies, and some nuts! The hamster ate %1.2f", foodAmount);
    System.out.println(" grams today.");
  }

  public void drinking() {
    System.out.println("Drinking... The hamster drank 10mls today.");
  }

  public void sleeping() {
    System.out.println("Sleeping... during the day. The hamster slept 12 hours today.");
  }

  public void running() {
    System.out.println("Running... in a hamster wheel!");
  }

  public void allBehaviours() {
    System.out.println("Hamster:");
    bathroom();
    eating();
    drinking();
    sleeping();
    running();
    System.out.println();
  }

} // end of public class Hamster
