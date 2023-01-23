/*
 * Name: Tanner Watmough
 * Student ID: 3554951
 * Date: August 17, 2022
 * 
 * Program Name: Pig.java
 * Program Purpose: Provides constructor for Pig and it's sound() method. 
 * Version 1.0
 */

/*
 * DOCUMENTATION
 */

/*
 * 
 * <H2> Pig Class </H2>
 * 
 * <H3> Purpose and Description </H3>
 * <P>
 * Provides extended constructor for Pig and it's sound() method.
 * </P>
 * 
 * <P>Program was written using Java 8.</P>
 * <P>Change to the directory containing the source code</P>
 * <P>Compile:    javac Pig.java</P>
 * <P>Run:        Unable to run as it is a class file with no main() routine. See AnimalTest.java to run program.
 */

/*
 * <H2>Classes</H2>
 * <P>
 * public class Pig is the main public class for the application. It is the only class.
 * </P>
 *
 * <H2>Pig Methods</H2>
 *<P>
 * public void Pig(String animalArg) {<BR>
 * This method will take the arguments and use them to print out a statement
 * to the standard output for pig. This is the extended constructor from Animal. 
 *</P>
 *<P>
 * public void sound() {<BR>
 * This method will print out the pig sound message to standard output. It overrides
 * the Animal class sound() method. 
 *</P>
 */

/*
 * 
 * <H2>Test Plan</H2>
 * 
 * <H3>Pig</H3>
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

public class Pig extends Animal {

  public Pig(String animalArg) {
    super("pig");
  } // end of extended constructor for pig

  public void sound() {
    System.out.println("pig says \"oink\"");
  } // end of sound() method for Pig

} // end of class Pig