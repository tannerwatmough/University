/* ===========================================================================
 * Distance.java
 * 
 * Tanner Watmough T00712721
 * COMP 1131 Assignment 2 Question 2
 * This application prompts user for the x and y coordinates of position one
 * and the x and y coordinates of position two and calculates the distance
 * between the two points. 
 * ===========================================================================
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class Distance {

  public static void main(String[] args) {
    double x1, x2, y1, y2, distance;

    Scanner scan = new Scanner(System.in);
    /*
     * This pattern ensures the entered doubles (as coordinates can be decimals)
     * match the test outputs in the Assignment 2 outline. So if whole numbers
     * are used like (1, 2), they are displayed as 1 and 2 and not 1.0 and 2.0
     * in the output. But if (1.5, 2.3) are used, it will appropriately use
     * up to three spots.
     */
    DecimalFormat fmt = new DecimalFormat("0.###");

    System.out.println("Distance Calculator");

    // Prompts user for coordinates
    System.out.print("Please enter the x of position one: ");
    x1 = scan.nextDouble();
    System.out.print("Please enter the y of position one: ");
    y1 = scan.nextDouble();
    System.out.print("Please enter the x of position two: ");
    x2 = scan.nextDouble();
    System.out.print("Please enter the y of position two: ");
    y2 = scan.nextDouble();
    System.out.println();

    // Compute distance between two coordinate pairs.
    distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));

    /*
     * Alternatively:
     * distance = x2 - x1;
     * distance = Math.pow(distance, 2); Squares x2-x1
     * distance += Math.pow((y2 - y1), 2); Adds x2-x1 squared to y2-y1 squared.
     * distance = Math.sqrt(distance);
     * 
     * Hopefully that helps clarify the equation for future reference for myself
     */

    // Display Results
    System.out.println("(" + fmt.format(x1) + ", " + fmt.format(y1) + ") and ("
        + fmt.format(x2) + ", " + fmt.format(y2) + ") are distance "
        + fmt.format(distance));

    scan.close();
  }
}