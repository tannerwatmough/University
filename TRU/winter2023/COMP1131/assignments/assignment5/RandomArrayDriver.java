/* ===========================================================================
 * RandomArrayDriver.java
 * 
 * Tanner Watmough T00712721
 * COMP 1131 Assignment 5 Question 1
 * 
 * This is a simple driver for the RandomArray class. It creates a RandomArray
 * object based on the user's desired array size and populates the array with
 * random numbers from 0 to the array's size. It then prints out the values of
 * the array, averageValue(), maxValue(), and minValue() methods to the output. 
 * ===========================================================================
 */

import java.util.Scanner;

public class RandomArrayDriver {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    // Gets user value for random array size.
    System.out.println("Please enter the size of array you want.");
    int arraySize = scan.nextInt();

    // Ensures arraySize is greater than 0 to avoid Null/Negative Array errors.
    while (arraySize <= 0) {
      System.out.println("Size of array must be greater than 0");
      arraySize = scan.nextInt();
    }
    System.out.println();

    // Creates new RandomArray based on inputted size.
    RandomArray array = new RandomArray(arraySize);

    // Prints out the array using the toString method and calls and outputs
    // the averageValue(), maxValue(), and minValue() method values.
    System.out.println(array);
    System.out.println("Average: " + array.averageValue());
    System.out.println("Max: " + array.maxValue());
    System.out.println("Min: " + array.minValue());

    scan.close();
  }
}
