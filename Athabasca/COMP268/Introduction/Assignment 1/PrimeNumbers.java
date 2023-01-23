
/*
 * Name: Tanner Watmough
 * Student ID: 3554951
 * Date: July 26, 2022
 * 
 * Program Name: PrimeNumbers.java
 * Program Purpose: This program will print all of the prime numbers between 0 and 10,000. 
 * Version 1.0
 */

/*
 * DOCUMENTATION
 */

/*
 * <H3> Purpose and Description </H3>
 * <P>
 * This program will print all of the prime numbers between 0 and 10,000. This can be easily
 * adjusted to any number, although the output is already confusing and the program would need
 * to be adjusted (likely using arrays or another data structure)
 * </P>
 * 
 * <P>Program was written using Java 8.</P>
 * <P>Change to the directory containing the source code</P>
 * <P>Compile:    javac PrimeNumbers.java</P>
 * <P>Run:        java PrimeNumbers</P>
 */

/*
 * <H2>Classes</H2>
 * <P>
 * public class PrimeNumbers is the main public class for the application. It is the only class.
 * </P>
 *
 * <H2>PrimeNumbers Methods</H2>
 *<P>
 * public static void main(String[] args) {<BR>
 * This method is used to execute the applicaiton.
 * This method will excute Problem 5's Prime Numbers problem. It will display all prime numbers between 0 and 10,000. 
 *</P>
 */

/*
 * 
 * <H2>Test Plan</H2>
 * 
 * <H3>Problem 5</H3>
 * <P>
 * 1. Run the application.
 * EXPECTED:
 *   Displays all numbers between 0 and 10,000 that are Prime Numbers. 
 * ACTUAL:
 *   Displays all numbers between 0 and 10,000 that are Prime Numbers. 
 * </P>
 * <P>
 * 2. Good data cases:
 * EXPECTED:
 *   No user input so no good data cases.
 * ACTUAL:
 *   Successfully displays the numbers.
 * </P>
 * <P>
 * 3. Bad data cases:
 * EXPECTED:
 *   No user input so no bad data cases.
 * ACTUAL:
 *   Displays expected prime numbers.
 * </P>
 */

// CODE

public class PrimeNumbers {

  public static void main(String[] args) {
    int currentNumber = 0;
    int divisor = 0;

    for (currentNumber = 1; currentNumber <= 10000; currentNumber++) {

      int counter = 0;

      for (divisor = currentNumber; divisor >= 1; divisor--) {

        if (currentNumber % divisor == 0) {
          counter = counter + 1;
        }
      }

      if (counter == 2) {
        System.out.print(currentNumber + " ");
      }
    }

    System.out.println();

    /*
     * I tried numerous loop methods but couldn't seem to get the program working.
     * I ended up modifying the program listed here:
     * https://beginnersbook.com/2014/01/java-program-to-display-prime-numbers/
     * I understand how to go through the program and hence why I renamed the
     * variables to make it more clear what mathematically is going on. I
     * banged my head, took a walk, and still couldn't solve the problem for
     * a few hours before I went looking for an online solution to a common
     * programming problem.
     */

  } // end of main

} // end of public class PrimeNumbers