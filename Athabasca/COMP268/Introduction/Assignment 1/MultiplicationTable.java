
/*
 * Name: Tanner Watmough
 * Student ID: 3554951
 * Date: July 26, 2022
 * 
 * Program Name: MultiplicaitonTable.java
 * Program Purpose: Prints out the entire 12x12 multiplication table and matches the table
 * shown on Assignment One.
 * Version 1.0
 */

/*
 * DOCUMENTATION
 */

/*
 * <H2> Multiplication Table </H2>
 * 
 * <H3> Purpose and Description </H3>
 * <P> This program prints out the entire 12x12 multiplication table and matches the table 
 * shown on Assignment One. </P>
 * 
 * <P>All programs can be run from the same compiled file. Program was written using Java 8.</P>
 * <P>Change to the directory containing the source code</P>
 * <P>Compile:    javac MultiplicationTable.java</P>
 * <P>Run:        java MultiplicationTable</P>
 */

/*
 * <H2>Classes</H2>
 * <P>
 * public class MultiplicationTable is the main public class for the application. It is the only class.
 * </P>
 *
 * <H2>MultiplicationTable Methods</H2>
 *<P>
 * public static void main(String[] args) {<BR>
 * This method is used to execute the applicaiton.
 * This method executes Problem 1's multiplication table. It will display a 12 by 12 multiplication table.
 *</P>
 * 
 * <H3>Problem One</H3>
 * <P>
 * 1. Run the application.
 * EXPECTED:
 *   Prints a 12x12 multiplicaiton table like this:
 *      1 |   2 |   3 |   4 |   5 |   6 |   7 |   8 |   9 |  10 |  11 |  12 |
 *      2 |   4 |   6 |   8 |  10 |  12 |  14 |  16 |  18 |  20 |  22 |  24 |
 *      3 |   6 |   9 |  12 |  15 |  18 |  21 |  24 |  27 |  30 |  33 |  36 |
 *      4 |   8 |  12 |  16 |  20 |  24 |  28 |  32 |  36 |  40 |  44 |  48 |
 *      5 |  10 |  15 |  20 |  25 |  30 |  35 |  40 |  45 |  50 |  55 |  60 |
 *      6 |  12 |  18 |  24 |  30 |  36 |  42 |  48 |  54 |  60 |  66 |  72 |
 *      7 |  14 |  21 |  28 |  35 |  42 |  49 |  56 |  63 |  70 |  77 |  84 |
 *      8 |  16 |  24 |  32 |  40 |  48 |  56 |  64 |  72 |  80 |  88 |  96 |
 *      9 |  18 |  27 |  36 |  45 |  54 |  63 |  72 |  81 |  90 |  99 | 108 |
 *     10 |  20 |  30 |  40 |  50 |  60 |  70 |  80 |  90 | 100 | 110 | 120 |
 *     11 |  22 |  33 |  44 |  55 |  66 |  77 |  88 |  99 | 110 | 121 | 132 |
 *     12 |  24 |  36 |  48 |  60 |  72 |  84 |  96 | 108 | 120 | 132 | 144 |
 * ACTUAL:
 *   Multiplication table displays like above. 
 * </P>
 * <P>
 * 2. Good data cases:
 * EXPECTED:
 *   No user input for this method, so no good data cases.
 * ACTUAL:
 *  Displays expected multiplication table as in the run scenario. 
 * </P>
 * <P>
 * 3. Bad data cases:
 * EXPECTED:
 *   No user input for this method, so no bad data cases.
 * ACTUAL:
 *   Displays expected multiplication table as in the run scenario. 
 * </P>
 */

// CODE

public class MultiplicationTable {

  public static void main(String[] args) {
    int columnNumber;
    int rowNumber;

    /*
     * Easy way to do the multiplication table is to go through both column and row
     * number and multiply them together. %4d formats it so the table matches.
     */

    for (rowNumber = 1; rowNumber <= 12; rowNumber++) {
      for (columnNumber = 1; columnNumber <= 12; columnNumber++) {
        System.out.printf("%4d |", columnNumber * rowNumber);
      }
      System.out.println();
    }
    System.out.println();
  } // end of main

} // end of public class MultiplicaitonTable