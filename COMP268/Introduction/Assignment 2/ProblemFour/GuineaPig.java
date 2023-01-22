/*
 * Name: Tanner Watmough
 * Student ID: 3554951
 * Date: August 17, 2022
 * 
 * Program Name: GuineaPig.java
 * Program Purpose: Provides constructor for GuineaPig and it's various instance methods.
 * Version 1.0
 */

/*
 * DOCUMENTATION
 */

/*
 * 
 * <H2> GuineaPig Class </H2>
 * 
 * <H3> Purpose and Description </H3>
 * <P>
 * Provides extended instance methods for GuineaPig. 
 * </P>
 * 
 * <P>Program was written using Java 8.</P>
 * <P>Change to the directory containing the source code</P>
 * <P>Compile:    javac GuineaPig.java</P>
 * <P>Run:        Unable to run as it is a class file with no main() routine. See RodentTest.java to run program.
 */

/*
 * <H2>Classes</H2>
 * <P>
 * public class GuineaPig is the main public class for the application. It is the only class.
 * </P>
 *
 * <H2>GuineaPig Methods</H2>
 *<P>
 * public void allBehaviors() {<BR>
 * This method calls all instance methods in one call. 
 *</P>
  *<P>
 * public void bathroom() {<BR>
 * This method will print out the extended Guinea Pig bathroom message to standard output. It overrides the 
 * default Rodent() methods. 
 *</P>
  *<P>
 * public void eating() {<BR>
 * This method will print out the extended Guinea Pig eating message to standard output. It overrides the 
 * default Rodent() methods. 
 *</P>
  *<P>
 * public void drinking() {<BR>
 * This method will print out the extended Guinea Pig drinking message to standard output. It overrides the 
 * default Rodent() methods. 
 *</P>
  *<P>
 * public void sleeping() {<BR>
 * This method will print out the extended Guinea Pig sleeping message to standard output. It overrides the 
 * default Rodent() methods. 
 *</P>
  *<P>
 * public void running() {<BR>
 * This method will print out the extended Guinea Pig running message to standard output. It overrides the 
 * default Rodent() methods. 
 */

/*
 * 
 * <H2>Test Plan</H2>
 * 
 * <H3>GuineaPig</H3>
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

public class GuineaPig extends Rodent {

  public void bathroom() {
    int poopAmount = (int) ((Math.random() * 100) + 50);
    System.out.println("Taking care of bathroom needs... The guinea pig pooped " + poopAmount + " times today.");
  }

  public void eating() {
    // https://www.humanesociety.org/resources/guinea-pig-feeding
    double foodAmount = (double) ((Math.random() * 8) + 10);
    System.out.printf(
        "Eating... grains, veggies, and fruit. Absolutely no meat! The guinea pig ate %1.2f", foodAmount);
    System.out.println(" grams today.");
  }

  public void drinking() {
    // https://guineapig101.com/guinea-pig-water/
    System.out.println("Drinking... The guinea pig drank 70ml today.");
  }

  public void sleeping() {
    // https://guineadad.com/blogs/news/are-guinea-pigs-nocturnal#:~:text=What%20Time%20Do%20Guinea%20Pigs,to%20sleep%20when%20I%20sleep.
    System.out.println("Sleeping... during the night. The guinea pig slept 6 hours today.");
  }

  public void running() {
    // https://www.youtube.com/watch?v=cotkdOCD1eY
    System.out.println("Running... in a guinea pig olympics!");
  }

  public void allBehaviours() {
    System.out.println("Guinea Pig:");
    bathroom();
    eating();
    drinking();
    sleeping();
    running();
    System.out.println();
  }

} // end of public class Mouse
