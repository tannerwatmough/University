/* ===========================================================================
 * DegreesRadians.java   
 * 
 * This converts degrees to radians. There are PI radians per 180 degrees, so 
 * to convert an angle given in degrees to radians do: 
 * rad = degrees * Math.PI/180
 */

import java.util.Scanner;

public class DegreesRadians {
  public static void main(String[] args) {
    double rad, degrees = 30;
    Scanner scan = new Scanner(System.in);

    System.out.println("Enter the degrees you want converted to radians");
    degrees = scan.nextDouble();

    rad = degrees * Math.PI / 180;
    System.out.println("Degrees: " + degrees);
    System.out.println("Radians: " + rad);

    scan.close();
  }
}