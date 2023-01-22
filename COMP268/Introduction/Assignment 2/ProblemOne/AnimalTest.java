/*
 * Name: Tanner Watmough
 * Student ID: 3554951
 * Date: August 17, 2022
 * 
 * Program Name: AnimalTest.java
 * Program Purpose: Contains the main() routine to test the various animal classes, 
 * creating Animal objects of various subclasses.
 * Version 1.0
 */

/*
 * DOCUMENTATION
 */

/*
 * The main program runs a a main routine which creates various animal objects and calls
 * their sound() methods. 
 * 
 * <H2> Animal Test </H2>
 * 
 * <H3> Purpose and Description </H3>
 * <P>
 * This program creates the various animal objects specified in the other classes including
 * a cow object, duck object, pig object, sheep object, and the default animal object. 
 * Each object contains an extended Animal constructor and sound() method except for Animal
 * which is the superclass for the others and holds the default sound() method and constructor. 
 * It also allows the user to create their own animal objects and call the sound() method. 
 * </P>
 * 
 * <P>Program was written using Java 8.</P>
 * <P>Change to the directory containing the source code</P>
 * <P>Compile:    javac AnimalTest.java</P>
 * <P>Run:        java AnimalTest</P>
 */

/*
 * <H2>Classes</H2>
 * <P>
 * public class AnimalTest is the main public class for the application. It is the only class.
 * </P>
 *
 * <H2>AnimalTest Methods</H2>
 *<P>
 * public static void main(String[] args) {<BR>
 * This method is used to execute the applicaiton.
 * This method executes Problem 1's Animal Test. It creates various animal objects including a 
 * duck, cow, pig, sheep, and animal object and calls their sound() methods. It also allows the user to
 * create a single animal object which has its sound() method called upon the user creation. 
 *</P>
 */

/*
 * 
 * <H2>Test Plan</H2>
 * 
 * <H3>Problem 1</H3>
 * <P>
 * 1. Run the application.
 * EXPECTED:
 *   Terminal should display printed statements. User should be able to input to terminal: 
 *   I am a animal
 *   I am a pig
 *   I am a sheep
 *   I am a duck
 *   I am a cow
 *   An animal makes a sound based on the animal that it is.
 *   pig says "oink"
 *   sheep says "baah"
 *   duck says "quack"
 *   cow says "moo"
 *   Create an animal by typing its name: 
 * ACTUAL:
 *   Menu options display as expected and user can input to terminal. 
 * </P>
 * <P>
 * 2. Good data cases:
 * EXPECTED:
 *   Run the following test cases by typing the input value and pressing enter:
 *   cow   -> creates a new cow object and points to it as cow2. Once created it also calls its sound() method.
 *   sheep -> creates a new sheep object and points to it as sheep2. Once created it also calls its sound() method.
 *   pig   -> creates a new pig object and points to it as pig2. Once created it also calls its sound() method.
 *   duck  -> creates a new duck object and points to it as duck2. Once created it also calls its sound() method.
 * ACTUAL:
 *  'cow'  -> cow2 is created which displays "I am a cow" and calls the sound method and displays "cow says "moo""
 * </P>
 * <P>
 * 3. Bad data cases:
 * EXPECTED:
 *   Run the following test cases by typing the input value and pressing enter:
 *   'z' -> output should display an error message "Sorry, I didn't understand "z"."
 *   Program then exits. 
 * ACTUAL:
 *   'z' -> output displays "Sorry, I didn't understand "z"." and then the program exits.
 * </P>
 */

// CODE

// Packages for Scanner
import java.util.Scanner;

public class AnimalTest {

  public static void main(String[] args) {
    String choice;
    Animal animal1 = new Animal("animal");
    Animal pig1 = new Pig("pig");
    Animal sheep1 = new Sheep("sheep");
    Animal duck1 = new Duck("duck");
    Animal cow1 = new Cow("cow");

    animal1.sound();
    pig1.sound();
    sheep1.sound();
    duck1.sound();
    cow1.sound();

    System.out.println("Create an animal by typing its name: ");

    Scanner input = new Scanner(System.in);

    choice = input.next();
    choice = choice.toLowerCase();

    if (choice.equals("pig")) {
      Animal pig2 = new Pig("pig");
      pig2.sound();
    } else if (choice.equals("cow")) {
      Animal cow2 = new Cow("cow");
      cow2.sound();
    } else if (choice.equals("duck")) {
      Animal duck2 = new Duck("duck");
      duck2.sound();
    } else if (choice.equals("sheep")) {
      Animal sheep2 = new Sheep("sheep");
      sheep2.sound();
    } else {
      System.out.println("Sorry, I didn't understand \"" + choice + "\".");
    }

    input.close();

  } // end of main

} // end of AnimalTest