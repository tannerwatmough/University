
/*
 * Name: Tanner Watmough
 * Student ID: 3554951
 * Date: July 26, 2022
 * 
 * Program Name: AssignmentOne.java
 * Program Purpose: Meet all requirements of Assignmnet 1. 
 * Version 1.0
 */

/*
 * DOCUMENTATION
 */

/*
 * The main program runs a menu that will call the various programs outlined in Assignmnet One.
 * 
 * <H2> Multiplication Table </H2>
 * 
 * <H3> Purpose and Description </H3>
 * <P> This program prints out the entire 12x12 multiplication table and matches the table 
 * shown on Assignment One. </P>
 * 
 * <H2> Temperature Converter </H2>
 * 
 * <H3> Purpose and Description </H3>
 * <P> 
 * This converts between Fahrenheit and Celsius and allows the user to do multiple converisons
 * </P>
 * 
 * <H2> Temperature Table </H2>
 * 
 * <H3> Purpose and Description </H3>
 * <P> 
 * Prints out a table that matches Assignment One with 100 temperature conversions for both
 * Celsius and Fahrenheit. 
 * </P>
 * 
 * <H2> Java Help </H2>
 * 
 * <H3> Purpose and Description </H3>
 * <P>
 * This works as a Terminal menu that allows the user to select an option from a menu of help
 * options. It covers common Java terms used in programming and gives a definiton and reference
 * link.
 * </P>
 * 
 * <H2> Prime Numbers </H2>
 * 
 * <H3> Purpose and Description </H3>
 * <P>
 * This program will print all of the prime numbers between 0 and 10,000. This can be easily
 * adjusted to any number, although the output is already confusing and the program would need
 * to be adjusted (likely using arrays or another data structure)
 * </P>
 * 
 * <P>All programs can be run from the same compiled file. Program was written using Java 8.</P>
 * <P>Change to the directory containing the source code</P>
 * <P>Compile:    javac AssignmentOne.java</P>
 * <P>Run:        java AssignmentOne</P>
 */

/*
 * <H2>Classes</H2>
 * <P>
 * public class AssignmentOne is the main public class for the application. It is the only class.
 * </P>
 *
 * <H2>AssignmentOne Methods</H2>
 *<P>
 * public static void main(String[] args) {<BR>
 * This method is used to execute the applicaiton.
 *</P>
 *<P>
 * public static void displayMenu() {<BR>
 * This method displays the main menu options called in main to choose the subroutine to execute.
 *</P>
 *<P>
 * public static void multiplicationTable() {<BR>
 * This method executes Problem 1's multiplication table. It will display a 12 by 12 multiplication table.
 *</P>
 *<P>
 * public static void temperatureConverter() {<BR>
 * This method executes Problem 2's temperature converter. Converts Celsius and Fahrenheit 
 * interchangably with user input values.
 *</P>
 *<P>
 * public static void temperatureTable() {<BR>
 * This method executes Problem 3's temperature table. It will display a table that has the conversions for 
 * Fahrenheit to Celsius and Celsius to Fahrenheit. It displays 100 values incremented by +5 from -40 for 
 * both Fahrenheit and Celsius. 
 *</P>
 *<P>
 * public static void javaHelp() {<BR>
 * This method executes Problem 4's Java Help menu. It will display a list of options to the user and will
 * display definitions for various Java terms to the console. The user will be able to ask for as many definitions
 * as they want until they enter the exit option. 
 *</P>
 *<P>
 * public static void helpMenu() {<BR>
 * This method will display the helpMenu for when Problem 4's subroutine, javaHelp(), is called. While it
 * could be implemented within javaHelp(), I find this way makes the code cleaner, but I'm open to feedback!
 *</P>
 *<P> 
 * public static void primeNumbers() {<BR>
 * This method will excute Problem 5's Prime Numbers problem. It will display all prime numbers between 0 and 10,000. 
 *</P>
 */

/*
 * 
 * <H2>Test Plan</H2>
 * 
 * <H3>MAIN</H3>
 * <P>
 * 1. Run the application.
 * EXPECTED:
 *   Terminal should display printed statements. User should be able to input to terminal: 
 *   Choose which part of the assignmnet you wish to access.
 *   1    Problem One - Multiplication Table 
 *   2    Problem Two - Temperature Converter
 *   3    Problem Three - Temperature Table  
 *   4    Problem Four - Java Help System    
 *   5    Problem Five - Prime Numbers       
 *   6    Quit Program
 *   Choose your option: 
 * ACTUAL:
 *   Menu options display as expected and user can input to terminal. 
 * </P>
 * <P>
 * 2. Good data cases:
 * EXPECTED:
 *   Run the following test cases by typing the input value and pressing enter:
 *   1 -> method multiplicationTable() should be successfully called
 *   2 -> method temperatureConverter() should be successfully called
 *   3 -> method temperatureTable() should be successfully called
 *   4 -> method javaHelp() should be successfully called
 *   5 -> method primeNumbers() should be successfully called
 *   6 -> Program should exit.
 * ACTUAL:
 *  Successfully calls the corresponding methods. 
 * </P>
 * <P>
 * 3. Bad data cases:
 * EXPECTED:
 *   Run the following test cases by typing the input value and pressing enter:
 *   'z' -> output should display an error message and the menu options again and not crash. 
 * ACTUAL:
 *   Displays error message for invalid values, displays the menu again, and lets the user input another value.
 * </P>
 * 
 * 
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
 * 
 * 
 * 
 * <H3>Problem Two</H3>
 * <P>
 * 1. Run the application.
 * EXPECTED:
 *   The program should display the following and allow user input afterward:
 *   This program converts Temperatures from Fahrenheit to Celsius and vice versa.
 *   Please enter just the numerical temperature:
 * ACTUAL:
 *   Displays the above appropriately.
 * </P>
 * <P>
 * 2. Good data cases:
 * EXPECTED:
 *   A decimal or whole number can be entered. After the program should display this if value is valid:
 *   Please enter the units (F/C): 
 *   This will allow user input again of a valid unit F, C, celsius, or Fahrenheit (of any case value).
 *   A valid unit will display: 
 *   A temperature of x degrees Celsius is equivalent to y degrees Fahrenheit.
 *   Where x and y are equal to the number and units entered by the user. The conversion should be correct
 *   and match temperature conversions from other temperature converters online. 
 *   After, the program should ask you if you'd like to do another conversion, Y or N (of any case). 
 *   Y will repeat the above program while N will exit the subroutine back to the main program. 
 * ACTUAL:
 *   The user can enter a decimal or whole number, C, F, celsius, or fahrenheit, and get a success conversion with 
 *   the user values. The conversions from this calculator match those of the online conversion.
 *   Doing more conversions works and allows for continous entry of temperature conversions.
 *   Entering N to more conversions will successfully exit to the main program. 
 * </P>
 * <P>
 * 3. Bad data cases:
 * EXPECTED:
 *   An invalid number should not crash the program. 
 *   An invalid unit should not crash the program and allow the user to enter the units again. 
 *   An invalid response to Do you wish to do another conversion? (Y/N): should not crash and should allow the
 *   user to enter another response. After two failed responses, it should exit the subroutine.
 * ACTUAL:
 *   An invalid number doesn't crach the program but does skip over to asking if they'd like to another conversion.
 *   This solution is not ideal and might lead to user frustration, esepcially if the calculation is more complex
 *   and requires more inputs before which would have been wiped out with one error. If you have a suggestion to fix
 *   this, I would greatly appreciate it! 
 *   An invalid unit does not crash the program. It will say it doesn't understand, like the above, and go to the next
 *   conversion question.
 *   I've implemented an invalid response which will catch. I need a better way of doing this in a loop, however, as 
 *   I limited it to two tries due to the inefficient coding solution I implemented. I didn't want to have infintie 
 *   try-catch code blocks but I was unable to implement a working loop structure for the try-catch statements (related
 *   to my problems with the invalid number problem).
 * </P>
 * 
 * 
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
 * 
 * 
 * <H3>Problem 4</H3>
 * <P>
 * 1. Run the application.
 * EXPECTED:
 *   Terminal should display printed statements. User should be able to input to terminal: 
 *   Java Help Menu
 *   Select Help on:
 *       1.   If
 *       2.   Switch
 *       3.   For
 *       4.   While
 *       5.   Do-while
 *       x.   Exit
 * 
 *   Selection:
 * ACTUAL:
 *   Menu options display as expected and user can input to terminal. 
 * </P>
 * <P>
 * 2. Good data cases:
 * EXPECTED:
 *   Run the following test cases by typing the input value and pressing enter:
 *   1 -> if definition should be displayed and user allowed to select another option after.
 *   2 -> switch definition should be displayed and user allowed to select another option after.
 *   3 -> for definition should be displayed and user allowed to select another option after.
 *   4 -> while definition should be displayed and user allowed to select another option after.
 *   5 -> do-while definition should be displayed and user allowed to select another option after.
 *   x -> Exits subroutine back to main program menu. 
 * ACTUAL:
 *  Successfully displays all definitions, redisplays menu, and allows user to select another option unless 
 *  x is chosen which will exit the subroutine and return to the main program.
 * </P>
 * <P>
 * 3. Bad data cases:
 * EXPECTED:
 *   Run the following test cases by typing the input value and pressing enter:
 *   'z' -> output should display an error message and the menu options again and not crash. 
 * ACTUAL:
 *   Displays error message for invalid values, displays the menu again, and lets the user input another value.
 * </P>
 *
 * 
 * 
 * <H3>Problem 5</H3>
 * <P>
 * 1. Run the application.
 * EXPECTED:
 *   Displays all numbers between 0 and 10,000 that are Prime Numbers. 
 * ACTUAL:
 *   Displays all numbers between 0 and 10,000 that are Prime Numbers. 
 * </P>
 * <P>
 * 2. Good data cases:
 * EXPECTED:
 *   No user input so no good data cases.
 * ACTUAL:
 *   Successfully displays the numbers.
 * </P>
 * <P>
 * 3. Bad data cases:
 * EXPECTED:
 *   No user input so no bad data cases.
 * ACTUAL:
 *   Displays expected prime numbers.
 * </P>
 */

// CODE

// Packages for Scanner
import java.util.Scanner;

public class AssignmentOne {

  public static void main(String[] args) {
    /*
     * This was done for simplicity in keeping all of the problems in one file
     * without overwhelming the output console. This should make it easier for
     * marking I hope.
     */

    String userChoice = "1";

    while (userChoice != "6") {
      /*
       * DISREGARD. This was fixed by using a String menu instead of an integer
       * based menu. I've left my old thoughts for reflective purposes I did end
       * up going with Scanner instead of TextIO as there is apparently limited
       * usage outside of the course. The only issue is that I am not yet proficient
       * enough to fully catch all exception errors. This is where TextIO can be
       * beneficial but I did want to use it as a crutch. You may find some exception
       * errors.
       */
      Scanner input = new Scanner(System.in);

      displayMenu();

      /*
       * Gets user input for menu option. Used
       * https://computinglearner.com/how-to-create-a-java-console-menu-application/
       * as a reference to help get this right. UPDATE: Ended up implementing menu
       * as String based instead of integer based to avoid exception errors and use of
       * string characters as options.
       */
      userChoice = input.next();
      switch (userChoice) {
        case "1":
          // Problem 1 - Multiplication Table - DONE
          multiplicationTable();
          break;
        case "2":
          // Problem 2 - Temperature Converter - DONE
          temperatureConverter();
          break;
        case "3":
          // Problem 3 - Table of Fahrenheit-Celsius Conversions - DONE
          temperatureTable();
          break;
        case "4":
          // Problem 4 - Java Help System - DONE
          javaHelp();
          break;
        case "5":
          // Problem 5 - Prime Numbers - DONE
          primeNumbers();
          break;
        case "6":
          // Quit - DONE
          System.out.println("Thank you! Goodbye.");
          userChoice = "6";
          break;
        default:
          // Error message
          System.out.println("Error! Invalid entry, please try again with a value between 1-6.");
      }
    }
  }

  // DISPLAY MENU

  public static void displayMenu() {
    /*
     * Display menu options. The subroutine was made to limit repetition and so the
     * user doesn't forget option choices if the console output becomes too
     * crowded
     */

    System.out.println("Choose which part of the assignmnet you wish to access.");
    System.out.println();
    System.out.println("    1    Problem One - Multiplication Table");
    System.out.println("    2    Problem Two - Temperature Converter");
    System.out.println("    3    Problem Three - Temperature Table");
    System.out.println("    4    Problem Four - Java Help System");
    System.out.println("    5    Problem Five - Prime Numbers");
    System.out.println("    6    Quit Program");
    System.out.println();
    System.out.print("Choose your option: ");
  }

  // PROBLEM 1 - Multiplication Table. This is the enitreity of Problem 1.

  public static void multiplicationTable() {
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
  }

  // PROBLEM 2 - Temperature Converter between Celisus and Fahrenheit .

  public static void temperatureConverter() {

    Scanner input = new Scanner(System.in);

    String units, conversionResponse; // Celsius or fahrenheit to be entered by the user.
    double temperature, fahrenheit, celsius; // Real number temperature to be entered by the user.
    boolean moreConversions = true; // A boolean to see if the user wishes to enter more conversions.

    // Prints program description to terminal
    System.out.println();
    System.out.println("This program converts Temperatures from Fahrenheit to Celsius and vice versa.");

    // Initializes values for fahrenheit and celsius.
    fahrenheit = 0;
    celsius = 0;
    temperature = 0;

    // A while loop to keep the program running as long as the use wishes to do more
    // conversions.
    while (moreConversions = true) {

      System.out.print("Please enter just the numerical temperature: ");

      /*
       * This will take the next numerical value entered by the user and save it as a
       * double. If an invalid option is given, it will print an error message and ask
       * if you'd like to do another conversion.
       */
      try {
        temperature = input.nextDouble();
      } catch (Exception e) {
        System.out.println("Error. Numerical value required.");
      }

      System.out.print("Please enter the units (F/C): ");
      // Takes a string value from user, f or c in any case, & converts to lowercase.
      units = input.next();
      units = units.toLowerCase();
      System.out.println();

      /*
       * Checks if the user entered celsius or c for units and executes the conversion
       * to fahrenheit. It then uses formatted printing to put in the value of
       * temperature (the value entered by the user initally) and of variable
       * fahrenheit which used temperature in the converison calculation to get the
       * fahrenheit reading.
       * 
       * If the user entered fahrenheit or f for units, it will use the entered
       * temperature in the conversion calculation to celsius and store it in variable
       * celsius. It will then use formatted printing to ouput the temperature and the
       * converted celsius value.
       * 
       * If the user entered an invalid response, it will print an error message
       * saying the program did not understand the untis they entered. It will proceed
       * to ask if they wish to do another conversion, giving them another chance to
       * enter a value.
       */
      if (units.equals("celsius") || units.equals("c")) {
        fahrenheit = temperature * 9 / 5 + 32;
        System.out.printf("A temperature of %-1.2f degrees Celsius is equivalent to %-1.2f degrees Fahrenheit.",
            temperature, fahrenheit);
      } else if (units.equals("fahrenheit") || units.equals("f")) {
        celsius = (temperature - 32) * 5 / 9;
        System.out.printf(
            "A temperature of %-1.2f degrees Fahrenheit is equivalent to %-1.2f degrees Celsius.",
            temperature, celsius);
      } else {
        System.out.println("Sorry, I didn't understand \"" + units + "\".");
      }

      // This part of the program covers if the user wishes to do more conversions.
      System.out.println();
      System.out.print("Do you wish to do another conversion? (Y/N): ");
      // Gets the next string input from the user and converts to lowercase.
      conversionResponse = input.next();
      conversionResponse = conversionResponse.toLowerCase();

      /*
       * If user response was y, it will do another conversion. If n, it will set to
       * false and exit later in the subroutine. If an invalid character is entered,
       * it will give an error message and instructions. It will once again ask if you
       * want to do another conversion. This time if an invalid character is entered,
       * it will set the moreConversions variable to false which will exit this
       * subroutine.
       */
      if (conversionResponse.equals("y")) {
        moreConversions = true;
      } else if (conversionResponse.equals("n")) {
        moreConversions = false;
        System.out.println();
        break;
      } else {
        System.out.println("Error. Try again. Answer must be a capital or lowercase y or n.");
        System.out.print("Do you wish to do another conversion? (Y/N): ");
        conversionResponse = input.next();
        conversionResponse = conversionResponse.toLowerCase();
        if (conversionResponse.equals("y")) {
          moreConversions = true;
        } else if (conversionResponse.equals("n")) {
          moreConversions = false;
          System.out.println();
          break;
        } else {
          System.out.println("Error. Returning to main menu.");
          moreConversions = false;
          System.out.println();
          break;
        }
      }

      System.out.println();

      /*
       * Before the loop repeats, it checks to see if moreConversions if false and
       * exits this subroutine if so.
       */
      if (moreConversions == false) {
        System.out.println("Thank you. Goodbye.");
      }
    }

  }

  // PROBLEM 3 - Print out a table of Fahrenheit-Celsius conversions.

  public static void temperatureTable() {

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
  } // end of temperatureTable

  // PROBLEM 4 - Java Help Menu

  public static void javaHelp() {
    String subchoice;

    subchoice = "1";

    while (subchoice != "x") {
      Scanner subInput = new Scanner(System.in);

      helpMenu();

      /*
       * Today I learned implementing a string menu is 1000x easier
       * then an integer menu as integer vs. string numbers work
       * the same but allow almost any input without error exceptions.
       */

      subchoice = subInput.next();
      System.out.println();

      switch (subchoice) {
        case "1":
          System.out.print("if: ");
          System.out.println(
              "Use of the if statement to specify a block of Java code to be executed if a condition is true. It a control statement for the flow of a program.");
          System.out.println("Reference: https://www.w3schools.com/java/java_conditions.asp ");
          System.out.println();
          break;
        case "2":
          System.out.print("switch: ");
          System.out.println(
              "Use of the switch statement to select one of many code blocks to be executed. The switch expression is evaluated once, the value compared to the values of each case, and if there is a match, the associated block of code is executed.");
          System.out.println("Reference: https://www.w3schools.com/java/java_switch.asp ");
          System.out.println();
          break;
        case "3":
          System.out.print("for: ");
          System.out.println(
              "When you know exactly how many times you want to loop, or repeat, a block of code, use the for loop instead of a while loop. You can use special syntax in the for loop. for(statement 1; statement 2; statement 3) where statement 1 is executed one time usually to initialize the variable. The second statement defines the condition for executing the code block and if the condition is no longer true, the loop stops. Statement 3 is executed every time after the code block has been executed and is generally used to increment the variable to eventually break the loop.");
          System.out.println("Reference: https://www.w3schools.com/java/java_for_loop.asp ");
          System.out.println();
          break;
        case "4":
          System.out.print("while: ");
          System.out.println(
              "Loops can execute a block of code as long as a specified condition is reached. They save time, reduce errors, and make code more readable. The while loop loops through a block of code as long as a specified condition is true. ");
          System.out.println("Reference: https://www.w3schools.com/java/java_while_loop.asp ");
          System.out.println();
          break;
        case "5":
          System.out.print("do-while: ");
          System.out.println(
              "The do/while loop is a variant of the while loop. The loop will execute the code block once, always, before checking if the condition is true or false. It will then repeat the loop as long as the condition is true.");
          System.out.println("Reference: https://www.w3schools.com/java/java_while_loop.asp ");
          System.out.println();
          break;
        case "x":
          System.out.println("Thank you! Goodbye.");
          System.out.println();
          subchoice = "x";
          break;
        // Error message
        default:
          System.out.println("Error! Invalid entry, please try again with a value between 1-5 or x.");
      }
    }
  } // end of class javaHelp

  public static void helpMenu() {
    /*
     * Display menu options. The subroutine was made to limit repetition and so the
     * user doesn't forget option choices if the console output becomes too
     * crowded. It is a subroutine of javaHelp().
     */
    System.out.println("Java Help Menu");
    System.out.println("Select Help on:");
    System.out.println("    1.   If");
    System.out.println("    2.   Switch");
    System.out.println("    3.   For");
    System.out.println("    4.   While");
    System.out.println("    5.   Do-while");
    System.out.println("    x.   Exit");
    System.out.println();
    System.out.print("Selection: ");
  } // end of class helpMenu

  // PROBLEM 5 - Prime Numbers from 1 to 10,000.

  public static void primeNumbers() {

    int currentNumber = 0;
    int divisor = 0;

    for (currentNumber = 1; currentNumber <= 10000; currentNumber++) {

      int counter = 0;

      for (divisor = currentNumber; divisor >= 1; divisor--) {

        if (currentNumber % divisor == 0) {
          counter = counter + 1;
        }
      }

      if (counter == 2) {
        System.out.print(currentNumber + " ");
      }
    }

    System.out.println();

    /*
     * I tried numerous loop methods but couldn't seem to get the program working.
     * I ended up modifying the program listed here:
     * https://beginnersbook.com/2014/01/java-program-to-display-prime-numbers/
     * I understand how to go through the program and hence why I renamed the
     * variables to make it more clear what mathematically is going on. I
     * banged my head, took a walk, and still couldn't solve the problem for
     * a few hours before I went looking for an online solution to a common
     * programming problem.
     */

  } // end of class primeNumbers

} // end of public class AssignmentOne