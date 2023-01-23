
/*
 * Name: Tanner Watmough
 * Student ID: 3554951
 * Date: July 26, 2022
 * 
 * Program Name: TemperatureConverter.java
 * Program Purpose: Converts user inputted numbers between Farenheit and Celsius, allowing multiple conversions. 
 * Version 1.0
 */

/*
 * DOCUMENTATION
 */

/*
 * <H2> Temperature Converter </H2>
 * 
 * <H3> Purpose and Description </H3>
 * <P> 
 * This converts between Fahrenheit and Celsius and allows the user to do multiple converisons
 * </P>
 * 
 * 
 * <P>Program was written using Java 8.</P>
 * <P>Change to the directory containing the source code</P>
 * <P>Compile:    javac TemperatureConverter.java</P>
 * <P>Run:        java TemperatureConverter</P>
 */

/*
 * <H2>Classes</H2>
 * <P>
 * public class TemperatureConverter is the main public class for the application. It is the only class.
 * </P>
 *
 * <H2>TemperatureConverter Methods</H2>
 *<P>
 * public static void main(String[] args) {<BR>
 * This method is used to execute the applicaiton.
 * This method executes Problem 2's temperature converter. Converts Celsius and Fahrenheit 
 * interchangably with user input values.
 *</P>
 */

/*
 * 
 * <H2>Test Plan</H2>
 * 
 * <H3>Temperature Converter</H3>
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
 */

// CODE

// Packages for Scanner
import java.util.Scanner;

public class TemperatureConverter {

  public static void main(String[] args) {

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
        System.out.println("Thank you. Goodbye.");
        input.close();
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
          System.out.println("Error. Program closing.");
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

  } // end of main

} // end of public class TemperatureConverter