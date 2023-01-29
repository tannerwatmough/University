/* ===========================================================================
 * Sphere.java
 * 
 * Tanner Watmough T00712721
 * COMP 1131 Assignment 2 Question 3
 * This application reads the radius of a sphere and calculates and displays
 * the circumference, volume, and surface area. 
 * 
 * Where r is radius:
 * Circumference = 2 * PI * r
 * Volume = (4.0/3.0) * PI * Math.pow(r, 3)
 * Surface Area = 4 * PI * Math.pow(r, 2)
 * ===========================================================================
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class Sphere {

  public static void main(String[] args) {
    double radius = 1, surfArea, volume, circumference;
    boolean prompt = true;

    Scanner scan = new Scanner(System.in);
    /*
     * Formatter to limit fractional portion to at most 3 places.
     * Also adds thousands place separators for large values.
     */
    DecimalFormat fmt = new DecimalFormat("#,###,##0.###");

    System.out.println("Values of a Sphere");

    // Prompt user for radius. Keeps prompting until positive radius given.
    while (prompt) {
      System.out.println("Please enter a positive radius: ");
      radius = scan.nextDouble();
      if (radius > 0) {
        prompt = false;
      }
    }

    System.out.println();

    // Calculate circumference of sphere
    circumference = 2 * Math.PI * radius;

    // Calculate volume of sphere. Integer division causes significant errors.
    volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);

    // Calculate surface area of sphere
    surfArea = 4 * Math.PI * Math.pow(radius, 2);

    // Display Results
    System.out.println("Circumference: \t" + fmt.format(circumference));
    System.out.println("Volume: \t" + fmt.format(volume));
    System.out.println("Surface Area: \t" + fmt.format(surfArea));

    scan.close();
  }
}