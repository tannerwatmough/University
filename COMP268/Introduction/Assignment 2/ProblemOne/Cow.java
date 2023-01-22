/*
 * Name: Tanner Watmough
 * Student ID: 3554951
 * Date: August 17, 2022
 * 
 * Program Name: Cow.java
 * Program Purpose: Provides constructor for Cow and it's sound() method. 
 * Version 1.0
 */

/*
 * DOCUMENTATION
 */

/*
 * 
 * <H2> Cow Class </H2>
 * 
 * <H3> Purpose and Description </H3>
 * <P>
 * Provides extended constructor for Cow and it's sound() method.
 * </P>
 * 
 * <P>Program was written using Java 8.</P>
 * <P>Change to the directory containing the source code</P>
 * <P>Compile:    javac Cow.java</P>
 * <P>Run:        Unable to run as it is a class file with no main() routine. See AnimalTest.java to run program.
 */

/*
 * <H2>Classes</H2>
 * <P>
 * public class Cow is the main public class for the application. It is the only class.
 * </P>
 *
 * <H2>Cow Methods</H2>
 *<P>
 * public void Cow(String animalArg) {<BR>
 * This method will take the arguments and use them to print out a statement
 * to the standard output for cow. This is the constructor
 * for the animal objects. 
 *</P>
 *<P>
 * public void sound() {<BR>
 * This method will print out the cow sound message to standard output. It overrides
 * the Animal class sound() method. 
 *</P>
 */

/*
 * 
 * <H2>Test Plan</H2>
 * 
 * <H3>Cow</H3>
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

public class Cow extends Animal {

  public Cow(String animalArg) {
    super("cow");
  } // end of extended Cow constructor

  public void sound() {
    System.out.println("cow says \"moo\"");
  } // end of Cow sound() method.

} // end of Cow class