/*
 * Name: Tanner Watmough
 * Student ID: 3554951
 * Date: August 17, 2022
 * 
 * Program Name: RodentTest.java
 * Program Purpose: Contains the main() routine to test the various Rodent classes, 
 * creating Rodent objects of various subclasses.
 * Version 1.0
 */

/*
 * DOCUMENTATION
 */

/*
 * The main program runs a a main routine which creates various rodent objects and calls
 * their allBehaviours() methods. 
 * 
 * <H2> Rodent Test </H2>
 * 
 * <H3> Purpose and Description </H3>
 * <P>
 * This program creates the various rodent objects specified in the other classes including
 * a gerbil object, mouse object, guinea pig object, and the hamster object. 
 * Each object contains extended behaviour methods method from Rodent, the superclass of the
 * others and holds the default behaviour methods.
 * </P>
 * 
 * <P>Program was written using Java 8.</P>
 * <P>Change to the directory containing the source code</P>
 * <P>Compile:    javac RodentTest.java</P>
 * <P>Run:        java RodentTest</P>
 */

/*
 * <H2>Classes</H2>
 * <P>
 * public class RodentTest is the main public class for the application. It is the only class.
 * </P>
 *
 * <H2>RodentTest Methods</H2>
 *<P>
 * public static void main(String[] args) {<BR>
 * This method is used to execute the applicaiton.
 * This method executes Problem 4's Rodent Test. It creates various rodent objects including a 
 * gerbil, guinea pig, mouse, and hamster object and calls their allBehaviours() method. 
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
 * Mice:
 * Taking care of bathroom needs... The mouse pooped 0.46 grams today.
 * Eating... grains, seeds, and fruit. Sometimes even meat! The mouse ate 3.87 grams today.       
 * Drinking... The mouse drank 4ml today.
 * Sleeping... during the day. The mouse slept 14 hours today.
 * Running... very close to walls to avoid predators. Their vision also isn't great!
 * 
 * Hamster:
 * Taking care of bathroom needs... The hamster pooped 75 pellets today.
 * Eating... hamster pellets, veggies, and some nuts! The hamster ate 6.95 grams today.
 * Drinking... The hamster drank 10mls today.
 * Sleeping... during the day. The hamster slept 12 hours today.
 * Running... in a hamster wheel!
 * 
 * Guinea Pig:
 * Taking care of bathroom needs... The guinea pig pooped 110 times today.
 * Eating... grains, veggies, and fruit. Absolutely no meat! The guinea pig ate 16.06 grams today.
 * Drinking... The guinea pig drank 70ml today.
 * Sleeping... during the night. The guinea pig slept 6 hours today.
 * Running... in a guinea pig olympics!
 * 
 * Gerbil:
 * Taking care of bathroom needs... The gerbil pooped 13 pellets today.
 * Eating... formulated pellets with some seeds, grains, and dried veggies! The gerbil ate 4 times today.
 * Drinking... The gerbil drank 4ml today.
 * Sleeping... during the night and some naps during the day.
 * Running... also on an exercise wheel!
 * ACTUAL:
 *   Output matches the above.
 * </P>
 * <P>
 * 2. Good data cases:
 * EXPECTED:
 *  No user input for this method, so no bad data cases.
 * ACTUAL:
 *  Displays as expected.
 * </P>
 * <P>
 * 3. Bad data cases:
 * EXPECTED:
 * No user input for this method, so no bad data cases.
 * ACTUAL:
 * Displays as expected.
 * </P>
 */

// CODE

public class RodentTest {

  public static void main(String[] args) {
    Rodent gerbil = new Gerbil();
    Rodent guineaPig = new GuineaPig();
    Rodent hamster = new Hamster();
    Rodent mouse = new Mouse();

    mouse.allBehaviours();
    hamster.allBehaviours();
    guineaPig.allBehaviours();
    gerbil.allBehaviours();

  } // end of main

} // end of class RodentTest
