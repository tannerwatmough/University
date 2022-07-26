import textio.TextIO;

/**
 * Computes amount of interest earned on an investment over 5 years.
 * The initial amount of investment and interest are input by user.
 * The value of the investment at the end of each year is output.
 */
public class Interest3 {

    public static void main(String[] args) {

        double principal; // The value of the investment.
        double rate; // The annual interest rate.

        /* Get the initial investment and interest rate from the user. */

        System.out.print("Enter the initial investment: ");
        principal = TextIO.getlnDouble();

        System.out.println();
        System.out.println("Enter the annual interest rate.");
        System.out.println("Enter a decimal, not a percentage: ");
        rate = TextIO.getlnDouble();
        System.out.println();

        /* Simulate the investment for 5 years. */

        int years; // Counts the number of years that have passed.

        years = 0;
        while (years < 5) {
            double interest; // Interest for this year.
            interest = principal * rate;
            principal = principal + interest; // Add it to principal.
            years = years + 1; // Count current year.
            System.out.print("The value of the investment after ");
            System.out.print(years);
            System.out.print(" years is $");
            System.out.printf("%1.2f", principal);
            System.out.println();
        }

    }

}