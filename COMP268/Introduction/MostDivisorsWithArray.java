/**
 * This program counts the number of divisors for integers in the range
 * 1 to 10000. It finds the maximum divisor count. It outputs the
 * maximum divisor count and a list of all integers in the range that
 * have the maximum number of divisors.
 * 
 * DISCUSSION
 * 
 * This is a fairly straightforward exercise in using arrays. We need to save
 * 10000 numbers in an array. The numbers are the divisor counts for the numbers
 * 1 through 10000. The numbers that we want to store in the array are of type
 * int, so int is the base type of the array. In the program, I use an array
 * named saveCount of type int[] to store the data. It seems natural to store
 * the divisor count for N in array element saveCount[N], but note that in that
 * case, we don't use array element number 0, and we need an array element
 * number 10000. Ignoring element 0 is fine, but for saveCount[10000] to exist,
 * the length of the array must be at least 10001. I use an array of length
 * 10001:
 * 
 * saveCount = new int[10001];
 * (An alternative would be to store the advisor count for N in saveCount[N-1].
 * In that case, we wouldn't need the extra array element, and the length of the
 * array would be 10000.)
 * 
 * After computing each divisor count, we store the count in the array. At the
 * same time, we are keeping track of the maximum number of divisors. After the
 * end of the for loop that does the counting, we know the divisor count for
 * each number and we know the maximum number of divisors. We just have to go
 * through the array and print out every integer N for which the divisor count
 * is equal to the maximum:
 * 
 * System.out.println("Numbers with that many divisors include:");
 * for ( N = 1; N <= 10000; N++ ) {
 * if ( saveCount[N] == maxDivisors ) {
 * System.out.println( " " + N );
 * }
 * }
 * Note that this code checks whether the number in the array, saveCount[N], is
 * equal to the maximum, but it prints the array index, N, which is the integer
 * that has that many divisors.
 * 
 */

public class MostDivisorsWithArray {

    public static void main(String[] args) {

        int N; // One of the integers whose divisors we have to count.
        int maxDivisors; // Maximum number of divisors seen so far.

        int[] saveCount; // Store the number of divisors for each number

        saveCount = new int[10001];

        maxDivisors = 1; // Start with the fact that 1 has 1 divisor.
        saveCount[1] = 1;

        /*
         * Process all the remaining values of N from 2 to 10000, and store
         * all the divisor counts in the array. Update the value of maxDivisor
         * whenever we find a value of N that has more divisors than the current
         * value.
         */

        for (N = 2; N <= 10000; N++) {

            int D; // A number to be tested to see if it's a divisor of N.
            int divisorCount; // Number of divisors of N.

            divisorCount = 0;

            for (D = 1; D <= N; D++) { // Count the divisors of N.
                if (N % D == 0)
                    divisorCount++;
            }

            saveCount[N] = divisorCount; // Record the count for N in the array

            if (divisorCount > maxDivisors) {
                maxDivisors = divisorCount;
            }

        }

        System.out.println("Among integers between 1 and 10000,");
        System.out.println("The maximum number of divisors was " + maxDivisors);
        System.out.println("Numbers with that many divisors include:");
        for (N = 1; N <= 10000; N++) {
            if (saveCount[N] == maxDivisors) {
                System.out.println("   " + N);
            }
        }

    } // end main()

}