// ****************************************************************************
// Change.java    Java Foundations
//
// Calculates change.This is where they try to fit dollars into the amount back,
// then quarters, then dimes, then nickels, etc. 
// ****************************************************************************

import java.util.Scanner;

public class Change {
  public static void main(String[] args) {
    int change, twoonies, dollars, quarters, dimes, nickels, cents;

    Scanner scan = new Scanner(System.in);

    System.out.println("Enter change in cents:");
    change = scan.nextInt();

    twoonies = change / 200;
    change = change % 200;

    dollars = change / 100;
    change = change % 100;

    quarters = change / 25;
    change = change % 25;

    dimes = change / 10;
    change = change % 10;

    nickels = change / 5;
    change = change % 5;

    cents = change;

    System.out.println("Your change is: " + twoonies + " twoonies, " + dollars +
        " loonies, " + quarters + " quarters, " + dimes + " dimes, " + nickels +
        " nickels, and " + cents + " cents.");
    scan.close();
  }
}