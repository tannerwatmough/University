
/**
 * This program finds an integer between 1 and 10000 that has
 * the largest number of divisors. It prints out the maximum
 * number of divisors and an integer that has that many divisors.
 * 
 * DISCUSSION
 * 
 * Let's use a variable named maxDivisors to keep track of the largest number of
 * divisors we have seen so far and use numWithMax to store the number that had
 * that many divisors. We have to compute the number of divisors of each integer
 * from 1 to 10000. Whenever we find a larger number of divisors than
 * maxDivisors, we have to make note of that fact by changing the values of
 * maxDivisors and numWithMax. At the end of the process, maxDivisors will be
 * the absolute maximum number of divisors and numWithMax will be a number that
 * had that many divisors. These are the values we want to print out. We can
 * express this with a pseudocode algorithm
 * 
 * for each integer N from 1 to 10000:
 * Count the number of divisors of N
 * If that number is greater than maxDivisors:
 * Let maxDivisors = the number of divisors of N
 * Let numWithMax = N
 * Output maxDivisors and numWithMax
 * However, there is a problem here: The very first time maxDivisors is used in
 * the test "If that number is greater than maxDivisors," the variable
 * maxDivisors hasn't yet been assigned a value. The computer will report this
 * as an error. This can be fixed by assigning a value to maxDivisors before the
 * beginning of the for loop. One way to do this is to handle N=1 as a special
 * case before the loop and then to let N go from 2 to 10000 in the for loop. We
 * know that N=1 has just 1 divisor:
 * 
 * Let maxDivisors = 1 // number of divisors of 1
 * Let numWithMax = 1
 * for each integer N from 2 to 10000:
 * Count the number of divisors of N
 * If that number is greater than maxDivisors:
 * Let maxDivisors = the number of divisors of N
 * Let numWithMax = N
 * Output maxDivisors and numWithMax
 * Here's a curious thing: If you leave out the line "numWithMax = 1" from the
 * program, the computer will report a syntax error where you try to output the
 * value of numWithMax. It will say that the variable numWithMax might not have
 * been initialized. That is, it might never have been assigned a value. Now,
 * you know that it will be assigned a value (since when N=2 is processed,
 * numWithMax will become 2). However, when the computer compiles the program,
 * it doesn't know whether the body of the if statement will ever be executed,
 * so it doesn't know whether numWithMax will ever be assigned a value. The
 * syntax rule is that every variable must be "definitely assigned" before its
 * value is used. This means that it is assigned a value on every possible
 * execution path through the program. Definite assignment was discussed in
 * Subsection 3.1.4.
 * 
 * We still have to expand the step "Count the number of divisors of N." This
 * was already done in Subsection 3.4.2 for the example program
 * CountDivisors.java. This step requires another for loop, so we have here an
 * example of one for loop nested inside another. Here is a complete algorithm,
 * which can be translated into a program:
 * 
 * Let maxDivisors = 1 // number of divisors of 1
 * Let numWithMax = 1
 * for each integer N from 2 to 10000:
 * Let divisorCount = 0
 * for each D from 1 to N:
 * if D is a divisor of N:
 * add 1 to divisorCount
 * If divisorCount is greater than maxDivisors:
 * Let maxDivisors = the number of divisors of N
 * Let numWithMax = N
 * Output maxDivisors and numWithMax
 * This can be translated pretty much directly into a program. By the way, the
 * maximum number of divisors is 64. There are two numbers between 1 and 10000
 * that have 64 divisors, 7560 and 9240. The program will output the first of
 * these. (It would output the second if the test "if (divisorCount >
 * maxDivisors)" were changed to "if (divisorCount >= maxDivisors)". Do you see
 * why?)
 * 
 */

public class MostDivisors {

    public static void main(String[] args) {

        int N; // One of the integers whose divisors we have to count.
        int maxDivisors; // Maximum number of divisors seen so far.
        int numWithMax; // A value of N that had the given number of divisors.

        maxDivisors = 1; // Start with the fact that 1 has 1 divisor.
        numWithMax = 1;

        /*
         * Process all the remaining values of N from 2 to 10000, and
         * update the values of maxDivisors and numWithMax whenever we
         * find a value of N that has more divisors than the current value
         * of maxDivisors.
         */

        for (N = 2; N <= 10000; N++) {

            int D; // A number to be tested to see if it's a divisor of N.
            int divisorCount; // Number of divisors of N.

            divisorCount = 0;

            for (D = 1; D <= N; D++) { // Count the divisors of N.
                if (N % D == 0)
                    divisorCount++;
            }

            if (divisorCount > maxDivisors) {
                maxDivisors = divisorCount;
                numWithMax = N;
            }

        }

        System.out.println("Among integers between 1 and 10000,");
        System.out.println("The maximum number of divisors is " + maxDivisors);
        System.out.println("A number with " + maxDivisors + " divisors is " + numWithMax);

    } // end main()

}
