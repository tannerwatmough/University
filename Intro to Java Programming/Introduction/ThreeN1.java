import textio.TextIO;

/**
 * <= is less than or equal to, != is not equal to,
 * N % 2 == 0 tests if N is even. This is the 3N+1
 * sequence from a positive integer specified by the user.
 * It also counts the number of terms in the sequence and
 * outputs it to the user.
 */

public class ThreeN1 {

    public static void main(String[] args) {

        int N;
        int counter;

        System.out.print("Starting point for sequence: ");
        N = TextIO.getlnInt();
        while (N <= 0) {
            System.out.print("The starting point must be positive. Please try again: ");
            N = TextIO.getlnInt();
        }
        // We now know that N > 0

        counter = 0;
        while (N != 1) {
            if (N % 2 == 0)
                N = N / 2;
            else
                N = 3 * N + 1;
            System.out.println(N);
            counter = counter + 1;
        }

        System.out.println();
        System.out.print("There were ");
        System.out.print(counter);
        System.out.println(" terms in the sequence.");

    }

}