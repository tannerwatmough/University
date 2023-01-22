/**
 * How many random people do you have to select before you
 * have found someone with every possible birthday (ignoring
 * leap years)? This program simulates the process.
 */

public class BirthdayProblem4 {

    /**
     * Simulate choosing people at random and checking the
     * day of the year they were born on. People are chosen
     * until all 365 possible birthdays (ignoring leap years)
     * have been found. Then the number of people surveyed
     * is output.
     * 
     * DISCUSSION
     * 
     * The third program is just a little bit trickier. We have to continue
     * selecting people at random until we have found 365 different birthdays. We
     * can use a counter to keep track of how many different birthdays we have
     * found. We have to continue until this counter reaches 365. We need a second
     * counter to keep track of how many different people we have checked. It's the
     * second counter whose value we want to output at the end. Now, we have to be
     * able to recognize whether a birthday we've just found is new, or whether
     * we've encountered it previously. For this, we can again use an array of
     * booleans. An algorithm for the simulation is:
     * 
     * Let used = new boolean[365]
     * Let count = 0 // The number of people checked
     * Let birthdaysFound = 0 // The number of different birthdays found
     * while birthdaysFound < 365:
     * Add one to count
     * Select a birthday at random
     * if used[birthday] is false:
     * Add one to birthdaysFound // since this is a new birthday
     * Let used[birthday] = true // so we don't count it again
     * Output the value of count
     * In Java, this algorithm becomes:
     * 
     * boolean[] used; // For recording the possible birthdays
     * // that have been seen so far.
     * int count; // The number of people who have been checked.
     * int birthdaysFound; // The number of different birthdays that
     * // have been found.
     * 
     * used = new boolean[365]; // Initially, all entries are false.
     * count = 0;
     * birthdaysFound = 0;
     * 
     * while (birthdaysFound < 365) {
     * // Select a birthday at random, from 0 to 364.
     * // If the birthday has not already been used,
     * // add 1 to birthdaysFound.
     * int birthday; // The selected birthday.
     * birthday = (int)(Math.random()*365);
     * count++;
     * if ( used[birthday] == false )
     * birthdaysFound++;
     * used[birthday] = true;
     * }
     * 
     * System.out.println( count + " people were checked." );
     * 
     * 
     */
    public static void main(String[] args) {

        boolean[] used; // For recording the possible birthdays
                        // that have been seen so far. A value
                        // of true in used[i] means that a person
                        // whose birthday is the i-th day of the
                        // year has been found.

        int count; // The number of people who have been checked.

        int birthdaysFound; // The number of different birthdays that
                            // have been found.

        used = new boolean[365]; // Initially, all entries are false.

        count = 0;

        birthdaysFound = 0;

        while (birthdaysFound < 365) {
            // Select a birthday at random, from 0 to 364.
            // If the birthday has not already been used,
            // add 1 to birthdaysFound.
            int birthday; // The selected birthday.
            birthday = (int) (Math.random() * 365);
            count++;
            if (used[birthday] == false)
                birthdaysFound++;
            used[birthday] = true;
        }

        System.out.println(count + " people were checked.");

    }

} // end class BirthdayProblem4
