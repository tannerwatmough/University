/*
 * Name: Tanner Watmough
 * Student ID: 3554951
 * Date: August 17, 2022
 * 
 * Program Name: Mouse.java
 * Program Purpose: Provides constructor for Mouse and it's various instance methods.
 * Version 1.0
 */

/*
 * DOCUMENTATION
 */

/*
 * 
 * <H2> Mouse Class </H2>
 * 
 * <H3> Purpose and Description </H3>
 * <P>
 * Provides extended instance methods for Mouse. 
 * </P>
 * 
 * <P>Program was written using Java 8.</P>
 * <P>Change to the directory containing the source code</P>
 * <P>Compile:    javac Mouse.java</P>
 * <P>Run:        Unable to run as it is a class file with no main() routine. See RodentTest.java to run program.
 */

/*
 * <H2>Classes</H2>
 * <P>
 * public class Mouse is the main public class for the application. It is the only class.
 * </P>
 *
 * <H2>Mouse Methods</H2>
 *<P>
 * public void allBehaviors() {<BR>
 * This method calls all instance methods in one call. 
 *</P>
  *<P>
 * public void bathroom() {<BR>
 * This method will print out the extended Mouse bathroom message to standard output. It overrides the 
 * default Rodent() methods. 
 *</P>
  *<P>
 * public void eating() {<BR>
 * This method will print out the extended Mouse eating message to standard output. It overrides the 
 * default Rodent() methods. 
 *</P>
  *<P>
 * public void drinking() {<BR>
 * This method will print out the extended Mouse drinking message to standard output. It overrides the 
 * default Rodent() methods. 
 *</P>
  *<P>
 * public void sleeping() {<BR>
 * This method will print out the extended Mouse sleeping message to standard output. It overrides the 
 * default Rodent() methods. 
 *</P>
  *<P>
 * public void running() {<BR>
 * This method will print out the extended Mouse running message to standard output. It overrides the 
 * default Rodent() methods. 
 */

/*
 * 
 * <H2>Test Plan</H2>
 * 
 * <H3>Mouse</H3>
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

public class Mouse extends Rodent {

  public void bathroom() {
    double poopAmount = (double) (Math.random() + 0.25); // Mice poop between 0.25 and 1 gram a day
    // https://www.livescience.com/54909-why-do-mice-poop-so-much.html
    System.out.printf("Taking care of bathroom needs... The mouse pooped %1.2f", poopAmount);
    System.out.println(" grams today.");
  }

  public void eating() {
    double foodAmount = (double) ((Math.random() * 5) + 2);
    // https://web.jhu.edu/animalcare/procedures/mouse.html#:~:text=The%20average%20daily%20consumption%20of,g%20and%204%20ml%20respectively.
    System.out.printf(
        "Eating... grains, seeds, and fruit. Sometimes even meat! The mouse ate %1.2f", foodAmount);
    System.out.println(" grams today.");
  }

  public void drinking() {
    System.out.println("Drinking... The mouse drank 4ml today.");
  }

  public void sleeping() {
    // https://www.livescience.com/28028-mice.html#:~:text=Mice%20are%20nocturnal%2C%20meaning%20they,very%20social%20with%20other%20mice.
    System.out.println("Sleeping... during the day. The mouse slept 14 hours today.");
  }

  public void running() {
    System.out.println("Running... very close to walls to avoid predators. Their vision also isn't great!");
  }

  public void allBehaviours() {
    System.out.println("Mice:");
    bathroom();
    eating();
    drinking();
    sleeping();
    running();
    System.out.println();
  }

} // end of public class Mouse
