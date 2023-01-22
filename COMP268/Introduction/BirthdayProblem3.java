/**
 * This program simulates selecting 365 people at random and finding
 * how many different birthdays they have among them.
 * 
 * DISCUSSION
 * 
 * For the second program, we know exactly how many people we want to check:
 * 365. This calls for using a for loop. The information we need for each
 * birthday is whether or not that birthday has occurred. For that, we can use
 * an array of booleans. After the for loop, value stored in position i of the
 * array will true if the i-th day of the year has occurred as a birthday and is
 * false if not. After checking 365 people, we have to go through the boolean
 * array and count the number of entries in the array that are true. This is the
 * number of different birthdays that have been found. The algorithm can be
 * expressed as:
 * 
 * Let used = new boolean[365]
 * Repeat 365 times:
 * Select a birthday at random
 * Store true into the corresponding location in the array, used
 * Let count = 0
 * for day = 0 to 364:
 * If used[day] is true:
 * Add 1 to count
 * Output the value of count
 * This translates easily into Java code:
 * 
 * boolean used[]; // used[i] will be true if a person is found
 * // whose birthday is the i-th day of the year.
 * 
 * used = new boolean[365]; // Initially, all entries are false!
 * 
 * for (i = 0; i < 365; i++) {
 * // Select a random birthday and record it.
 * int birthday; // The selected birthday.
 * birthday = (int)(Math.random()*365);
 * used[birthday] = true;
 * }
 * 
 * int count = 0;
 * 
 * for (day = 0; day < 365; day++) {
 * // If this day occurred as a birthday, count it.
 * if (used[day] == true)
 * count++;
 * }
 * 
 * System.out.println("Among 365 people, there were " + count
 * + " different birthdays.");
 * It might be worth noting that the test "if (used[day] == true)" can be
 * written more simply—and elegantly—as "if (used[day])". Also, the three lines
 * in the first for loop could be reduced to the single command
 * "used[(int)(Math.random()*365)] = true;". Of course, this one-line version is
 * harder to understand.
 * 
 * 
 * 
 */

public class BirthdayProblem3 {

    /**
     * Simulate choosing people at random and checking the
     * day of the year they were born on. The number of
     * different days found among 365 people is counted
     * and output.
     */
    public static void main(String[] args) {

        boolean used[]; // used[i] will be true if a person is found
                        // whose birthday is on the i-th day of the year.

        used = new boolean[365]; // Initially, all entries are false.

        /*
         * Choose 365 days at random, and mark each day by
         * setting the corresponding entry in the array, used,
         * to true. (If the value is already true, it doesn't
         * matter. We are only interested in whether or not
         * the birthday occurs, not how many times it occurs.)
         */

        int i;
        for (i = 0; i < 365; i++) {
            int birthday; // The selected birthday.
            birthday = (int) (Math.random() * 365);
            used[birthday] = true;
        }

        /*
         * Now, count how many entries in the used array are true.
         * This is how many different birthdays were found.
         */

        int count = 0;
        int day;

        for (day = 0; day < 365; day++) {
            // If this day occurred as a birthday, count it.
            if (used[day] == true)
                count++;
        }

        System.out.println("Among 365 people, there were " + count
                + " different birthdays.");

    }

} // end class BirthdayProblem3
