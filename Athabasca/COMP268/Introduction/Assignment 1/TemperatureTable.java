
/*
 * Name: Tanner Watmough
 * Student ID: 3554951
 * Date: July 26, 2022
 * 
 * Program Name: TemperatureTable.java
 * Program Purpose: Prints out a table that matches Assignment One with 100 temp conversions for both
 * Celsius and Farenheit. 
 * Version 1.0
 */

/*
 * DOCUMENTATION
 */

/*
 * <H2> Temperature Table </H2>
 * 
 * <H3> Purpose and Description </H3>
 * <P> 
 * Prints out a table that matches Assignment One with 100 temperature conversions for both
 * Celsius and Fahrenheit. 
 * </P>
 * 
 * <P>Program was written using Java 8.</P>
 * <P>Change to the directory containing the source code</P>
 * <P>Compile:    javac TemperatureTable.java</P>
 * <P>Run:        java TemperatureTable</P>
 */

/*
 * <H2>Classes</H2>
 * <P>
 * public class TemperatureTable is the main public class for the application. It is the only class.
 * </P>
 *
 * <H2>Temperature Table Methods</H2>
 *<P>
 * public static void main(String[] args) {<BR>
 * This method is used to execute the applicaiton.
 * This method executes Problem 3's temperature table. It will display a table that has the conversions for 
 * Fahrenheit to Celsius and Celsius to Fahrenheit. It displays 100 values incremented by +5 from -40 for 
 * both Fahrenheit and Celsius. 
 *</P>
 */

/*
 * 
 * <H3>Problem 3</H3>
 * <P>
 * 1. Run the application.
 * EXPECTED:
 *   Terminal should output a temperature table like this: 
 *  Temperature      |       Temperature    
     (degrees)       |        (degrees)
    F          C     |       C         F
 -40.000    -40.000  |    -40.000   -40.000
 -35.000    -37.222  |    -35.000   -31.000
 -30.000    -34.444  |    -30.000   -22.000
 -25.000    -31.667  |    -25.000   -13.000
 -20.000    -28.889  |    -20.000    -4.000
 -15.000    -26.111  |    -15.000     5.000
 -10.000    -23.333  |    -10.000    14.000
  -5.000    -20.556  |     -5.000    23.000
   0.000    -17.778  |      0.000    32.000
   5.000    -15.000  |      5.000    41.000
  10.000    -12.222  |     10.000    50.000
  15.000     -9.444  |     15.000    59.000
  20.000     -6.667  |     20.000    68.000
  25.000     -3.889  |     25.000    77.000
  30.000     -1.111  |     30.000    86.000
  35.000      1.667  |     35.000    95.000
  40.000      4.444  |     40.000   104.000
  45.000      7.222  |     45.000   113.000
  50.000     10.000  |     50.000   122.000
  55.000     12.778  |     55.000   131.000
  60.000     15.556  |     60.000   140.000
  65.000     18.333  |     65.000   149.000
  70.000     21.111  |     70.000   158.000
  75.000     23.889  |     75.000   167.000
  80.000     26.667  |     80.000   176.000
  85.000     29.444  |     85.000   185.000
  90.000     32.222  |     90.000   194.000
  95.000     35.000  |     95.000   203.000
 100.000     37.778  |    100.000   212.000
 105.000     40.556  |    105.000   221.000
 110.000     43.333  |    110.000   230.000
 115.000     46.111  |    115.000   239.000
 120.000     48.889  |    120.000   248.000
 125.000     51.667  |    125.000   257.000
 130.000     54.444  |    130.000   266.000
 135.000     57.222  |    135.000   275.000
 140.000     60.000  |    140.000   284.000
 145.000     62.778  |    145.000   293.000
 150.000     65.556  |    150.000   302.000
 155.000     68.333  |    155.000   311.000
 160.000     71.111  |    160.000   320.000
 165.000     73.889  |    165.000   329.000
 170.000     76.667  |    170.000   338.000
 175.000     79.444  |    175.000   347.000
 180.000     82.222  |    180.000   356.000
 185.000     85.000  |    185.000   365.000
 190.000     87.778  |    190.000   374.000
 195.000     90.556  |    195.000   383.000
 200.000     93.333  |    200.000   392.000
 205.000     96.111  |    205.000   401.000
 210.000     98.889  |    210.000   410.000
 215.000    101.667  |    215.000   419.000
 220.000    104.444  |    220.000   428.000
 225.000    107.222  |    225.000   437.000
 230.000    110.000  |    230.000   446.000
 235.000    112.778  |    235.000   455.000
 240.000    115.556  |    240.000   464.000
 245.000    118.333  |    245.000   473.000
 250.000    121.111  |    250.000   482.000
 255.000    123.889  |    255.000   491.000
 260.000    126.667  |    260.000   500.000
 265.000    129.444  |    265.000   509.000
 270.000    132.222  |    270.000   518.000
 275.000    135.000  |    275.000   527.000
 280.000    137.778  |    280.000   536.000
 285.000    140.556  |    285.000   545.000
 290.000    143.333  |    290.000   554.000
 295.000    146.111  |    295.000   563.000
 300.000    148.889  |    300.000   572.000
 305.000    151.667  |    305.000   581.000
 310.000    154.444  |    310.000   590.000
 315.000    157.222  |    315.000   599.000
 320.000    160.000  |    320.000   608.000
 325.000    162.778  |    325.000   617.000
 330.000    165.556  |    330.000   626.000
 335.000    168.333  |    335.000   635.000
 340.000    171.111  |    340.000   644.000
 345.000    173.889  |    345.000   653.000
 350.000    176.667  |    350.000   662.000
 355.000    179.444  |    355.000   671.000
 360.000    182.222  |    360.000   680.000
 365.000    185.000  |    365.000   689.000
 370.000    187.778  |    370.000   698.000
 375.000    190.556  |    375.000   707.000
 380.000    193.333  |    380.000   716.000
 385.000    196.111  |    385.000   725.000
 390.000    198.889  |    390.000   734.000
 395.000    201.667  |    395.000   743.000
 400.000    204.444  |    400.000   752.000
 405.000    207.222  |    405.000   761.000
 410.000    210.000  |    410.000   770.000
 415.000    212.778  |    415.000   779.000
 420.000    215.556  |    420.000   788.000
 425.000    218.333  |    425.000   797.000
 430.000    221.111  |    430.000   806.000
 435.000    223.889  |    435.000   815.000
 440.000    226.667  |    440.000   824.000
 445.000    229.444  |    445.000   833.000
 450.000    232.222  |    450.000   842.000
 455.000    235.000  |    455.000   851.000
 * ACTUAL:
 * Table is displayed like the above example. 
 * </P>
 * <P>
 * 2. Good data cases:
 * EXPECTED:
 *   No user input, no good data cases.
 * ACTUAL:
 *   Displays table as expected in the run scenairo. 
 * </P>
 * <P>
 * 3. Bad data cases:
 * EXPECTED:
 *   No user input, no bad data cases.
 * ACTUAL:
 *   Displays table as expected in the run scenairo. 
 * </P>
 *
 */

// CODE

public class TemperatureTable {

  public static void main(String[] args) {

    double columnOne, celsius, fahrenheit;
    int i;

    // Start at -40 because it's the first row values.
    columnOne = -40;
    celsius = -40;
    fahrenheit = -40;

    System.out.println("    Temperature      |       Temperature    ");
    System.out.println("     (degrees)       |        (degrees)     ");
    System.out.println("    F          C     |       C         F    ");

    for (i = 1; i < 101; i++) {
      // The wonky spacing and formating was trial and error to match the ex. table.
      System.out.printf("%8.3f   %8.3f  | %10.3f %9.3f", columnOne, celsius, columnOne,
          fahrenheit);
      System.out.println();
      // The first columns on both sides of the table are the same, incremented by 5.
      columnOne = columnOne + 5;
      // columnOne is equivalent to the corresponding temperature unit converted.
      celsius = ((columnOne - 32) * 5 / 9);
      fahrenheit = (((columnOne * 9) / 5) + 32);
    }
    System.out.println();
  } // end of main

} // end of public class TemperatureTable