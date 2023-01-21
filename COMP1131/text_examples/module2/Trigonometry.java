/* ===========================================================================
 * Trigonometry.java   
 * 
 * This calculates the sine and cosine of radians, computes the square of those
 * two values, adds two squares, and saves the result. It then writes out the
 * three variables. I've upgraded it to also allow unguarded user input. 
 */

import java.util.Scanner;

public class Trigonometry {
  public static void main(String[] args) {
    double value = 0.5236, cosX, sinX, sum;
    Scanner scan = new Scanner(System.in);

    sinX = Math.sin(value);
    cosX = Math.cos(value);
    sum = (sinX * sinX) + (cosX * cosX);

    System.out.println("sine: " + sinX + " cosine: " + cosX + " sum: " + sum);

    System.out.println("Enter a numeric radian to calculate it's sine, cosine" +
        ", square of those values, adds the two squares, and saves the result.");
    value = scan.nextDouble();

    /*
     * Could improve by making the next four lines into a method as you should
     * not repeat yourself in code.
     */

    sinX = Math.sin(value);
    cosX = Math.cos(value);
    sum = (sinX * sinX) + (cosX * cosX);

    System.out.println("sine: " + sinX + " cosine: " + cosX + " sum: " + sum);

    scan.close();
  }
}