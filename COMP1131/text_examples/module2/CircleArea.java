// ****************************************************************************
// CircleArea.java    Java Foundations
//
// Calculates the area of a circle from its radius. The radius is input by
// the user. 
// ****************************************************************************

import java.util.Scanner;

public class CircleArea {
  // Calculate fuel efficiency based on values entered by user
  public static void main(String[] args) {
    int radius;
    double area;

    Scanner scan = new Scanner(System.in);

    System.out.print("Input the radius: ");
    radius = scan.nextInt();
    System.out.println();

    area = Math.PI * (radius * radius);

    System.out.print("The radius is: " + radius);
    System.out.print(" The area is: " + area);
    scan.close();
  }
}