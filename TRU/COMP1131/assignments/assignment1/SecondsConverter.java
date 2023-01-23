/* ===========================================================================
 * SecondsConverter.java
 * 
 * Tanner Watmough T00712721
 * COMP 1131 Assignment 1 Question 2
 * This application prompts the user for time in seconds and converts it
 * to an equivalent amount of time as a combination of hours, minutes, and
 * seconds.
 * ===========================================================================
 */

import java.util.Scanner;

public class SecondsConverter {

  public static void main(String[] args) {
    final int SECONDS_IN_HOURS = 3600, SECONDS_IN_MINUTES = 60;
    int seconds, minutes, hours;

    // Prompts user for seconds value
    Scanner scan = new Scanner(System.in);
    System.out.println("Seconds Converter");
    System.out.print("Please enter the number of seconds: ");
    seconds = scan.nextInt();

    // Converts the user entered seconds to hours, minutes, and seconds
    hours = seconds / SECONDS_IN_HOURS;
    seconds = seconds % SECONDS_IN_HOURS;

    minutes = seconds / SECONDS_IN_MINUTES;
    seconds = seconds % SECONDS_IN_MINUTES;

    // Display Results
    System.out.println(seconds + " seconds is equivalent to " + hours +
        " hour(s), " + minutes + " minute(s), and " + seconds + " second(s).");

    scan.close();
  }
}