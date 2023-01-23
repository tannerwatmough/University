/*
 * Name: Tanner Watmough
 * Student ID: 3554951
 * Date: August 17, 2022
 * 
 * Program Name: Animal.java
 * Program Purpose: Provides constructor for subclasses and the sound() method. 
 * Version 1.0
 */

/*
 * DOCUMENTATION
 */

/*
 * 
 * <H2> Animal Class </H2>
 * 
 * <H3> Purpose and Description </H3>
 * <P>
 * Provides constructor for subclasses and the sound() method for child classes of Animal. 
 * </P>
 * 
 * <P>Program was written using Java 8.</P>
 * <P>Change to the directory containing the source code</P>
 * <P>Compile:    javac Animal.java</P>
 * <P>Run:        Unable to run as it is a class file with no main() routine. See AnimalTest.java to run program.
 */

/*
 * <H2>Classes</H2>
 * <P>
 * public class Animal is the main public class for the application. It is the only class.
 * </P>
 *
 * <H2>Animal Methods</H2>
 *<P>
 * public void Animal(String animalArg) {<BR>
 * This method will take the arguments and use them to print out a statement
 * to the standard output to say which animal it is. This is the constructor
 * for the animal objects. 
 *</P>
 *<P>
 * public void sound() {<BR>
 * This method will print out the default message for Animal to standard output.
 * Child classes that call this method will override it with their own messages. 
 *</P>
 */

/*
 * 
 * <H2>Test Plan</H2>
 * 
 * <H3>Animal</H3>
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

public class Animal {

  private String animalArg;

  public Animal(String animalArg) {
    this.animalArg = animalArg;
    System.out.println("I am a " + animalArg);
  } // end of Animal constructor

  public void sound() {
    System.out.println("An animal makes a sound based on the animal that it is.");
  } // end of default sound method

} // end of Animal class
