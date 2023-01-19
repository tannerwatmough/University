import textio.TextIO;

/**
 * This class implements a simple program that will compute
 * the amount of interest that is earned on an investment over
 * a period of one year. The initial amount of the investment
 * and the interest rate are input by the user. The value of
 * the investment at the end of the year is output. The
 * rate must be input as a decimal, not a percentage (for
 * example, 0.05 rather than 5).
 */
public class Interest2 {
    public static void main(String[] args) {

        double principal; // the value of the investment.
        double rate; // the annual interest rate
        double interest; // the interest earned during the year.
        double time; // the time in years. 1 is 1 year, 0.5 is 6 months, etc.

        System.out.print("Enter the intiial investment: ");
        principal = TextIO.getlnDouble();

        System.out.print("Enter the time in years (1 = 1 year, 0.5 = 6 months): ");
        time = TextIO.getlnDouble();

        System.out.print("Enter the annual interest rate (as a decimal): ");
        rate = TextIO.getlnDouble();

        interest = principal * rate * time; // Compute this year's interest.
        principal = principal + interest; // Add it to principal.

        System.out.printf("The amount of interest is $%1.2f%n", interest);
        System.out.printf("The value after " + time + " years is $%1.2f%n", principal);

    } // end of main()

} // end of class Interest2
