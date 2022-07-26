import java.util.InputMismatchException;
import java.util.Scanner;

public class AssignmentOne {

    public static void main(String[] args) {
        /**
         * This was done for simplicity in keeping all of the problems in one file
         * without overwhelming the output console. This should make it easier for
         * marking I hope.
         */

        int userChoice = 1;

        while (userChoice != 6) {
            Scanner input = new Scanner(System.in);

            displayMenu();

            /*
             * Gets user input for menu option. Used
             * https://computinglearner.com/how-to-create-a-java-console-menu-application/
             * to help get this right.
             */
            try {
                userChoice = input.nextInt();
                switch (userChoice) {
                    case 1:
                        // Problem 1 - Multiplication Table
                        multiplicationTable();
                        break;
                    case 2:
                        // Problem 2 - Temperature Converter
                        temperatureConverter();
                        break;
                    case 3:
                        // Problem 3
                        break;
                    case 4:
                        // Problem 4
                        break;
                    case 5:
                        // Problem 5
                        break;
                    case 6:
                        // Quit
                        System.out.println("Thank you! Goodbye.");
                        input.close();
                        break;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter an integer value between 1 and 6");
                input.next();
            } catch (Exception ex) {
                System.out.println("An unexpected error happened. Please try again.");
                input.next();
            }
        }
    }

    public static void displayMenu() {
        /**
         * Display menu options. The subroutine was made to limit repetition and so the
         * user doesn't forget option choices if the console output becomes too
         * crowded
         */

        System.out.println("Choose which part of the assignmnet you wish to access.");
        System.out.println();
        System.out.println("    1    Problem One - Multiplication Table");
        System.out.println("    2    Problem Two - Temperature Converter");
        System.out.println("    3    Problem Three");
        System.out.println("    4    Problem Four");
        System.out.println("    5    Problem Five");
        System.out.println("    6    Quit Program");
        System.out.println();
        System.out.print("Choose your option: ");
    }

    public static void multiplicationTable() {
        // Problem 1 - Multiplication Table. This is the enitreity of Problem 1.
        int columnNumber;
        int rowNumber;

        for (rowNumber = 1; rowNumber <= 12; rowNumber++) {
            for (columnNumber = 1; columnNumber <= 12; columnNumber++) {
                System.out.printf("%4d |", columnNumber * rowNumber);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void temperatureConverter() {
        // Problem 2 - Temperature Converter between Celisus and Farenheit.
        Scanner input = new Scanner(System.in);

        String units; // Celsius or Farenheit to be entered by the user.
        double temperature, farenheit, celsius; // Real number temperature to be entered by the user.

        System.out.println();
        System.out.println("This program will convert Celsius to Farenheit and vice versa.");
        System.out.println("Ex. 21 C or 32 Farenheit");
        System.out.println();

        System.out.println("Please enter just the numerical temperature.");
        temperature = input.nextDouble();

        System.out.println("Please enter your temperature unit. Ex. C, Celsius, F, Farenheit");
        units = input.nextLine();
        units = units.toLowerCase();

        farenheit = 0;
        celsius = 0;

        if (units.equals("celsius") || units.equals("c")) {
            farenheit = temperature * 9 / 5 + 32;
        } else if (units.equals("farenheit") || units.equals("f")) {
            celsius = (temperature - 32) * 5 / 9;
        } else {
            System.out.println("Sorry, I didn't understand \"" + units + "\".");
        }

        System.out.println();
        System.out.println(temperature + celsius + farenheit);
        System.out.printf("Your entered temperature of %,4.2g%n ", temperature + units);
        System.out.printf("That is %,4.2g%n Celsius and %,4.2g%n Farenheit", celsius, farenheit);
        input.close();
    }
}
