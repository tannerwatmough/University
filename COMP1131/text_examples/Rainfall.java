/* ===========================================================================
 * Rainfall.java   
 * 
 * This calculates the rain fall average over three months. It demonstrates
 * declaring and initializing variables and computes the average. It then 
 * prints out the results. I've upgraded it to also allow unguarded user 
 * input. 
 */

import java.util.Scanner;

public class Rainfall {
  public static void main(String[] args) {
    /*
     * One error they want you to make is to use int instead of double for the
     * averages which would make it integer division instead of floating point
     * division because they say the variables are 12, 14, and 8.
     */
    double april = 12, may = 14, june = 8, average;
    Scanner scan = new Scanner(System.in);

    System.out.println("Rainfall for April: \t" + april);
    System.out.println("Rainfall for May: \t" + may);
    System.out.println("Rainfall for June: \t" + june);

    average = (april + may + june) / 3;
    System.out.println("Average rainfall: \t" + average);

    System.out.println("Enter numeric rainfall values for April, May, and June");
    april = scan.nextDouble();
    may = scan.nextDouble();
    june = scan.nextDouble();

    /*
     * Could improve by making the next five lines into a method as you should
     * not repeat yourself in code.
     */
    System.out.println("Rainfall for April: \t" + april);
    System.out.println("Rainfall for May: \t" + may);
    System.out.println("Rainfall for June: \t" + june);

    average = (april + may + june) / 3;
    System.out.println("Average rainfall: \t" + average);
  }
}