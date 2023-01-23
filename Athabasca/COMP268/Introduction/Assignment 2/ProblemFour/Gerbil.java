/*
 * Name: Tanner Watmough
 * Student ID: 3554951
 * Date: August 17, 2022
 * 
 * Program Name: Gerbil.java
 * Program Purpose: Provides constructor for Gerbil and it's various instance methods.
 * Version 1.0
 */

/*
 * DOCUMENTATION
 */

/*
 * 
 * <H2> Gerbil Class </H2>
 * 
 * <H3> Purpose and Description </H3>
 * <P>
 * Provides extended instance methods for Gerbil. 
 * </P>
 * 
 * <P>Program was written using Java 8.</P>
 * <P>Change to the directory containing the source code</P>
 * <P>Compile:    javac Gerbil.java</P>
 * <P>Run:        Unable to run as it is a class file with no main() routine. See RodentTest.java to run program.
 */

/*
 * <H2>Classes</H2>
 * <P>
 * public class Gerbil is the main public class for the application. It is the only class.
 * </P>
 *
 * <H2>Gerbil Methods</H2>
 *<P>
 * public void allBehaviors() {<BR>
 * This method calls all instance methods in one call. 
 *</P>
  *<P>
 * public void bathroom() {<BR>
 * This method will print out the extended Gerbil bathroom message to standard output. It overrides the 
 * default Rodent() methods. 
 *</P>
  *<P>
 * public void eating() {<BR>
 * This method will print out the extended Gerbil eating message to standard output. It overrides the 
 * default Rodent() methods. 
 *</P>
  *<P>
 * public void drinking() {<BR>
 * This method will print out the extended Gerbil drinking message to standard output. It overrides the 
 * default Rodent() methods. 
 *</P>
  *<P>
 * public void sleeping() {<BR>
 * This method will print out the extended Gerbil sleeping message to standard output. It overrides the 
 * default Rodent() methods. 
 *</P>
  *<P>
 * public void running() {<BR>
 * This method will print out the extended Gerbil running message to standard output. It overrides the 
 * default Rodent() methods. 
 */

/*
 * 
 * <H2>Test Plan</H2>
 * 
 * <H3>Gerbil</H3>
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

public class Gerbil extends Rodent {

  public void bathroom() {
    int poopAmount = (int) ((Math.random() * 20) + 5);
    // https://www.gerbilwelfare.com/how-often-do-gerbils-poop/#:~:text=Gerbils%20poop%20a%20few%20times,ideal%20pets%20for%20young%20children.
    System.out.println("Taking care of bathroom needs... The gerbil pooped " + poopAmount + " pellets today.");
  }

  public void eating() {
    int foodAmount = (int) ((Math.random() * 2) + 3);
    // https://pocketpetcentral.com/how-often-and-how-much-should-you-feed-a-gerbil/
    System.out.println(
        "Eating... formulated pellets with some seeds, grains, and dried veggies! The gerbil ate " + foodAmount
            + " times today.");
  }

  public void drinking() {
    System.out.println("Drinking... The gerbil drank 4ml today.");
  }

  public void sleeping() {
    System.out.println("Sleeping... during the night and some naps during the day.");
  }

  public void running() {
    System.out.println("Running... also on an exercise wheel!");
  }

  public void allBehaviours() {
    System.out.println("Gerbil:");
    bathroom();
    eating();
    drinking();
    sleeping();
    running();
    System.out.println();
  }

} // end of public class Gerbil
