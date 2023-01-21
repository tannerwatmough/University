/* ===========================================================================
 * Fractions.java
 * 
 * Tanner Watmough T00712721
 * COMP 1131 Assignment 1 Question 3
 * This application prompts the user for a numerator and denominator of a
 * fraction as integers, then displays the decimal equivalent of the fraction.
 * ===========================================================================
 */

import java.util.Scanner;

public class Fractions {

  public static void main(String[] args) {
    int numerator, denominator;
    double decimal;

    // Prompts user for pound value
    Scanner scan = new Scanner(System.in);
    System.out.println("Fractions to Decimal Converter ");
    System.out.print("Please enter the numerator: ");
    numerator = scan.nextInt();
    System.out.print("Please enter the denominator: ");
    denominator = scan.nextInt();
    System.out.println();

    /*
     * Converts the fraction to a decimal. Casting required to cue floating
     * point division instead of integer division.
     */
    decimal = (double) numerator / denominator;

    // Display Results
    System.out.println(numerator + "/" + denominator + " is equal to " + decimal);

    scan.close();
  }
}