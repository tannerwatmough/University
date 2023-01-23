import textio.TextIO;

public class CreateProfile {

    public static void main(String[] args) {

        String name; // The user's name.
        String email; // The user's email address.
        double salary; // The user's yearly salary.
        String favColor; // The user's favorite color.

        TextIO.putln("Good afternoon! This program will create");
        TextIO.putln("your profile file, if you will just answer");
        TextIO.putln("a few simple questions.");
        TextIO.putln();

        /* Gather responses from the user. */

        TextIO.put("What is your name?      ");
        name = TextIO.getln();
        TextIO.put("What is your email address?   ");
        email = TextIO.getln();
        TextIO.put("What is your yearly income?   ");
        salary = TextIO.getlnDouble();
        TextIO.put("What is your favorite color?  ");
        favColor = TextIO.getln();

        /* Write the user's information to the file named profile.txt. */

        TextIO.writeUserSelectedFile(); // subsquent output goes to this file. This is the selection dialog test.
        TextIO.putln("Name:     " + name);
        TextIO.putln("Email:     " + email);
        TextIO.putf("Yearly Income:  %,1.2f%n", salary);
        /*
         * %, adds commas for the number based on locale settings.The letter at the end,
         * f, is used to
         * specify floating point numbers. The digits after the decimal, 2, specifies
         * the number of digits
         * to use after the decimal point while 1 represents the minimum characters to
         * ouput which is as many
         * as necessary in this case. %12.3f would be a floating point format with 3
         * digits after the decimal
         * in a right justified in a field of length 12. -12 for left justified.
         * The , after the string is used instead of conocating + because you can only
         * conocate strings and
         * salary is a type of double, not a string.
         */
        TextIO.putln("Favorite Color:   " + favColor);

        /* Print a final message to standard output. */

        TextIO.writeStandardOutput();
        TextIO.putln("Thank you. Your profile has been written to profile.txt.");

    }
}