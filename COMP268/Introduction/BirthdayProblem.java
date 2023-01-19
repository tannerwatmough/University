/**
 * Simulate choosing people at random and checking day of year they
 * were born on. If the birthday is the same as the one that was seen
 * previously, stop, and output the number of people who were checked.
 */
public class BirthdayProblem {

    public static void main(String[] args) {

        boolean[] used; // For recording the possible birthdays seen so far
                        // with a value of true in used[i] meaning the birthday
                        // is on the i-th day has been found already.

        int count; // The number of people who have been checked.

        int average;
        int i; // Iterations
        int iterationSum;
        int iterationCount;

        used = new boolean[365]; // Initially, all entries are false.

        count = 0;
        iterationCount = 10000;
        iterationSum = 0;

        for (i = 0; i <= iterationCount; i++) {
            while (true) {
                // Select a birthdya at random, from 0 to 364.
                // If the birthday has already been used, quit.
                // Otherwise, record the birthday as used.

                int birthday; // The selected birthday.
                birthday = (int) (Math.random() * 365);
                count++;

                System.out.printf("Person %d has birthday number %d%n", count, birthday);

                if (used[birthday]) {
                    // This day was found before, it's a dupliate, we are done.
                    break;
                }

                used[birthday] = true;

            } // end while

            iterationSum = iterationSum + count;
            System.out.println();
            System.out.println("A duplicate birthday was found after " + count + " tries.");
            System.out.println();

            count = 0;
            used = new boolean[365];

        }

        average = iterationSum / iterationCount;

        System.out.println("The average number of people after 1000 iterations was " + average);
        System.out.println("This means the average number of people before you find a shared birthday is " + average);
    }

}
