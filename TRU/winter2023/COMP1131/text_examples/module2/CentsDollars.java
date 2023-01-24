// ****************************************************************************
// CentsDollars.java    Java Foundations
//
// Converts cents to dollars and cents.
// ****************************************************************************

import java.util.Scanner;

public class CentsDollars {
  public static void main(String[] args) {
    int cents, dollars;

    Scanner scan = new Scanner(System.in);

    System.out.println("Input the cents: ");
    cents = scan.nextInt();

    dollars = cents / 100; // 100 cents per dollar
    cents = cents % 100; // Remainder of cents

    System.out.println("That is " + dollars + " dollars and " + cents +
        " cents.");

    scan.close();
  }
}