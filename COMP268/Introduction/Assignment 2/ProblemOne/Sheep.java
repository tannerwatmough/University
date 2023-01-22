/*
 * Name: Tanner Watmough
 * Student ID: 3554951
 * Date: August 17, 2022
 * 
 * Program Name: Sheep.java
 * Program Purpose: Provides constructor for Sheep and it's sound() method. 
 * Version 1.0
 */

/*
 * DOCUMENTATION
 */

/*
 * 
 * <H2> Sheep Class </H2>
 * 
 * <H3> Purpose and Description </H3>
 * <P>
 * Provides extended constructor for Sheep and it's sound() method.
 * </P>
 * 
 * <P>Program was written using Java 8.</P>
 * <P>Change to the directory containing the source code</P>
 * <P>Compile:    javac Sheep.java</P>
 * <P>Run:        Unable to run as it is a class file with no main() routine. See AnimalTest.java to run program.
 */

/*
 * <H2>Classes</H2>
 * <P>
 * public class Sheep is the main public class for the application. It is the only class.
 * </P>
 *
 * <H2>Sheep Methods</H2>
 *<P>
 * public void Sheep(String animalArg) {<BR>
 * This method will take the arguments and use them to print out a statement
 * to the standard output for sheep. This is the extended constructor from Animal. 
 *</P>
 *<P>
 * public void sound() {<BR>
 * This method will print out the sheep sound message to standard output. It overrides
 * the Animal class sound() method. 
 *</P>
 */

/*
 * 
 * <H2>Test Plan</H2>
 * 
 * <H3>Sheep</H3>
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

public class Sheep extends Animal {

  public Sheep(String animalArg) {
    super("sheep");
  } // end of extended Sheep constructor

  public void sound() {
    System.out.println("sheep says \"baah\"");
  } // end of sound() method

} // end of class Sheep