
/*
 * ===========================================================================
 * PascalTriangle.java
 * 
 * Tanner Watmough T00712721
 * COMP 1131 Assignment 5 Question 3
 * 
 * This file defines and runs the PascalTriangle class. It demonstrates the
 * use of recursion. 
 * 
 * ===========================================================================
 */
import java.util.Scanner;

class PascalTriangle {

  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    // Asks user to enter n-value.
    System.out.print("How many lines of the triangle? (n value): ");
    int n = scan.nextInt();

    // 2D array to store values.
    int[][] array = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j - i > 1; j--) {
        // Used for spacing.
        System.out.print("  ");
      }
      // Iterates through.
      for (int k = 0; k <= i; k++) {
        // Shows how you could populate an array similarly.
        array[i][k] = pascal(i, k);
        System.out.print(pascal(i, k) + "  ");
      }
      // New row
      System.out.println();
    }

    System.out.println();

    // This prints the array version of the pascal triangle.
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        // Stops the 0 values in array from printing. Otherwise its a square.
        if (array[i][j] == 0) {

        } else {
          // This helps with formatting. You can see in the comparisons between
          // the two printed triangles. This is the second one.
          if (array[i][j] >= 10) {
            System.out.print(array[i][j] + "  ");
          } else {
            System.out.print(array[i][j] + "   ");

          }
        }
      }
      // New row
      System.out.println();
    }

    scan.close();
  }

  public static int pascal(int row, int col) {
    // If outside position, make a 1.
    if (col == 0 || col == row) {
      return 1;
    } else {
      // Add the two in the pyramid. Uses recursion until reaches base case
      // (col == 0 || col == row)
      return pascal(row - 1, col - 1) + pascal(row - 1, col);
    }
  }
}
