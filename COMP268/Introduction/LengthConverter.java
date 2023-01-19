import textio.TextIO;

/**
 * This program converts measurements expressed in inches, feet, yards
 * or miles into each possible units of measure. Measurement is input
 * by the user, followed by the unit of measure. ex. "17 feet", "1 inch"
 * "2.73 mi". Abbreviations in, ft, yd, and mi are accepted. The program
 * will continue to read and convert measurements until the user enters
 * an input of 0.
 */
public class LengthConverter {

    public static void main(String[] args) {

        double measurement; // Numerical measurement, input by user.
        String units; // Unit of measure for the input, input by user.

        double inches, feet, yards, miles; // measurement expressed in each
                                           // possible unit of measure.

        System.out.println("Enter measurements in inches, feet, yards, or miles.");
        System.out.println("For example: 1 inch 17 feet 2.73 miles");
        System.out.println("You can use abbreviations: in ft yd mi");
        System.out.println("I will convert your input into the other units");
        System.out.println("of measure.");
        System.out.println();

        while (true) {

            /* Get the user's input, and onvert units to lower case. */

            System.out.print("Enter your measurement, or 0 to end: ");
            measurement = TextIO.getDouble();
            if (measurement == 0)
                break; // Terminate the while loop.
            units = TextIO.getlnWord();
            units = units.toLowerCase();

            /* Convert the input measurement to inches. */

            if (units.equals("inch") || units.equals("inches") || units.equals("in")) {
                inches = measurement * 12;
            } else if (units.equals("foot") || units.equals("feet") || units.equals("ft")) {
                inches = measurement * 12;
            } else if (units.equals("yard") || units.equals("yards") || units.equals("yd")) {
                inches = measurement * 36;
            } else if (units.equals("mile") || units.equals("miles") || units.equals("mi")) {
                inches = measurement * 12 * 5280;
            } else {
                System.out.println("Sorry, but I don't understand \"" + units + "\".");
                continue; // back to start of while loop
            }

            /* Convert measurement in inches to feet, yards, and miles. */

            feet = inches / 12;
            yards = inches / 36;
            miles = inches / (12 * 5280);

            /* Output measurement in terms of each unit of measure. */

            System.out.println();
            System.out.println("That's equivalent to:");
            System.out.printf("%,14.8g inches%n", inches);
            System.out.printf("%,14.8g feet%n", feet);
            System.out.printf("%,14.8g yards%n", yards);
            System.out.printf("%,14.8g miles%n", miles);
            System.out.println();
        } // end while

        System.out.println();
        System.out.println("OK! Bye for now.");

    } // end main()

} // end class LengthConverter
