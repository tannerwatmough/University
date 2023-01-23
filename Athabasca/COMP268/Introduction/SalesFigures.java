import textio.TextIO;

/**
 * This program reads from a file named "sales.dat". Each line of the
 * file contains the name of a city, followed by a colon, followed by
 * either a number giving the amount of sales in that city or by a
 * message saying why the sales figure is not available. The program
 * prints the total sales for all cities and the number of cites for
 * which the figure was not available.
 * 
 * DISCUSSION
 * 
 * The statement TextIO.readFile("sales.dat") can be used at the beginning of
 * the program to make TextIO read from the file instead of from the user's
 * input. This statement throws an IllegalArgumentException if the file can't be
 * found. Although it's not required by the statement of the problem, it would
 * be nice to detect the exception and print an error message about the missing
 * file. This can be done as follows, using System.exit to end the program if
 * the error occurs:
 * 
 * try {
 * TextIO.readFile("sales.dat");
 * }
 * catch (IllegalArgumentException e) {
 * System.out.println("Can't open file \"sales.dat\" for reading!");
 * System.out.println("Please make sure the file is present before");
 * System.out.println("running the program.");
 * System.exit(1); // Terminates the program.
 * }
 * We have two main quantities to keep track of in the program: The total amount
 * of sales and the number of cities for which data is missing. These quantities
 * can be represented by two variables, salesTotal of type double and
 * missingCount of type int. These variables are initialized to zero before
 * processing any data from the file, and their values are output at the end of
 * the program, after reading the entire file.
 * 
 * The main processing loop of the program is the while loop mentioned in the
 * statement of the exercise, which begins while (TextIO.eof() == false). (In my
 * program, I've chosen to use the equivalent but more elegant test while ( !
 * TextIO.eof() ); you should try to understand why this is equivalent—and why
 * it is more elegant!) In pseudocode form, we want a loop that does the
 * following:
 * 
 * while there are more lines in the file:
 * read the name of the city and the colon that follows it
 * read the rest of the line into a string
 * try to convert the string into a number
 * if the conversion succeeds, add the number to the total sales
 * otherwise add 1 to the count of missing data
 * To read past the name of the city, we can simply read characters using
 * TextIO.getChar() until we get to the colon:
 * 
 * do { // Read past characters up to the ':'.
 * ch = TextIO.getChar();
 * } while (ch != ':');
 * where ch is a variable of type char. We can read the rest of the line using
 * TextIO.getln(). (As a side note, it's important here that we read the entire
 * line, including the carriage return at the end. TextIO.getln() does this. If
 * we neglected to read the carriage return at the end of the line, TextIO.eof()
 * would not detect the end of the file correctly. After the data from the last
 * line is read, the carriage return character would still be there in the file
 * waiting to be read; since there is still something left to read in the file,
 * TextIO.eof() would be false false and the while loop would continue, even
 * though all the cities have already been processed. In fact, the program would
 * crash while looking for the next ':', which is not there. Text processing can
 * be surprisingly subtle!)
 * 
 * Once we have the information in the form of a String, we can try to convert
 * the string into a number with Double.parseDouble. If the string is not a
 * number, this will throw an exception of type NumberFormatException. We can
 * catch the error in a try..catch statement. The "missing data" processing is
 * done in the catch part of this statement. In the program, this takes the
 * form:
 * 
 * try {
 * sales = Double.parseDouble(dataString);
 * salesTotal += sales; // This is skipped if the conversion fails.
 * }
 * catch (NumberFormatException e) {
 * // The dataString is not a number, so it counts as
 * // missing data. Add 1 to the missing data count.
 * missingCount++;
 * }
 * (Note that my solution assumes that the data file (if it exists at all) has
 * exactly the format that is specified in the problem. The problem would be
 * more difficult if we had to check the format of the file, to see whether it
 * conforms to the specification.)
 * 
 */

public class SalesFigures {

    public static void main(String[] args) {

        /* Open file for reading; if it can't be opened, end the program */

        try {
            TextIO.readFile("sales.dat");
        } catch (IllegalArgumentException e) {
            System.out.println("Can't open file \"sales.dat\" for reading!");
            System.out.println("Please make sure the file is present before");
            System.out.println("running the program.");
            System.exit(1); // Terminates the program.
        }

        /* Read the file, keeping track of total sales and missing data. */

        double salesTotal; // Total of all sales figures seen so far.
        int missingCount; // Number of cities for which data is missing.

        salesTotal = 0;
        missingCount = 0;

        while (!TextIO.eof()) { // process one line of data.

            char ch; // For reading past the name of the city.
            String dataString; // Contents of line, after the city name.
            double sales; // The sales figure for the city.

            do { // Read past characters up to the ':'.
                ch = TextIO.getChar();
            } while (ch != ':');

            dataString = TextIO.getln(); // Get the rest of the line.

            try {
                sales = Double.parseDouble(dataString);
                salesTotal += sales; // This is skipped if the conversion fails.
            } catch (NumberFormatException e) {
                // The dataString is not a number, so it counts as
                // missing data. Add 1 to the missing data count.
                missingCount++;
            }

        } // end while

        /* Report the results. */

        System.out.printf("Total sales recorded from all cities: $%1.2f\n\n", salesTotal);
        if (missingCount == 0)
            System.out.println("Data was received from all cities.");
        else if (missingCount == 1)
            System.out.println("Data was missing from 1 city.");
        else
            System.out.printf("Data was missing from %d cities.\n", missingCount);

    } // end main()

} // end class SalesFigures