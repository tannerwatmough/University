/* ===========================================================================
 * WeightConverter.java
 * 
 * Tanner Watmough T00712721
 * COMP 1131 Assignment 1 Question 1
 * This application prompts the user for a weight in pounds and converts it
 * into kilograms and reports the result to the user.
 * ===========================================================================
 */

import java.util.Scanner;

public class WeightConverter {

  public static void main(String[] args) {
    final double POUNDS_TO_KILOGRAMS = 0.45359237;
    double pounds, kilograms;

    // Prompts user for pound value
    Scanner scan = new Scanner(System.in);
    System.out.println("Pounds to Kilogram Converter");
    System.out.print("Please enter the number of pounds: ");
    pounds = scan.nextDouble();

    // Converts the user entered pounds to kilograms
    kilograms = pounds * POUNDS_TO_KILOGRAMS;

    // Display Results
    System.out.println(pounds + " pounds is " + kilograms + " kilograms.");

    scan.close();
  }
}