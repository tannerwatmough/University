/**
 * How many random people do you have to select before you find
 * THREE with the same birthday (that is, three people who were born
 * on the same day of the same month, but not necessarily in the
 * same year). This program simulates the process. (It ignores the
 * possibility of people born on leap day.)
 * 
 * DISCUSSION
 * 
 * The original program and the three programs for this exercise have some
 * similarities, and we will use ideas from the original program. However, each
 * part of this exercise presents its own problem.
 * 
 * The first question asks how many people you have to choose at random before
 * finding three who share the same birthday. This is similar to the original
 * program, but instead of just checking whether or not a given birthday has
 * already been found, we need to keep track of how many people have been found
 * with each birthday. Where the original program used an array of booleans,
 * here we need an array of ints. We still want to count the number of people we
 * check and output that count at the end. An algorithm for the simulation is:
 * 
 * Let count = 0
 * Repeat:
 * Select a birthday at random
 * Add one to count
 * If this is the third time that birthday has occurred:
 * break out of the loop
 * Add one to the number of times that birthday has been found
 * Output the count
 * The original program used a boolean array to keep track of whether or not
 * each day had been seen. For this proble, we need to know how many times each
 * day has been seen. That means that instead of one boolean value for each day,
 * we need one integer value for each day. So, to do the counting, we need an
 * array "int[] numFound", where numFound[i] will be the number of times the
 * i-th day of the year has occurred as a birthday. Since numFound[i] can be
 * used in any way that any int variable can be used, we can add one to the
 * number stored in numFound[i] by saying "numFound[i]++" or "numFound[i] =
 * numFound[i] + 1". When we create the array with the command "numFound = new
 * int[365]", all the elements of the array are automatically initialized to
 * zero. This is the initial value that we want. (This is an important thing to
 * remember! In some programming languages, arrays are not automatically filled
 * with zeros, so it would be necessary to use a for loop to store a zero into
 * each place in the array. Even in Java, if you reuse the same array rather
 * than creating a new one for each use, you would have to remember to set
 * initialize each element of the array before reusing it.)
 * 
 * Given all this, we can translate the algorithm into Java as follows:
 * 
 * int[] numFound; // numFound[i] will be the number of people
 * // who have been found who have a birthday
 * // on the i-th day of the year
 * 
 * int count; // The number of people who have been checked.
 * 
 * numFound = new int[365]; // Initially, all entries are 0.
 * 
 * count = 0;
 * 
 * while (true) {
 * // Select a birthday at random, from 0 to 364.
 * // If the same birthday was already seen twice
 * // before, then quit. Otherwise, add one to
 * // the corresponding entry in the numFound array
 * // to record that a person with that birthday
 * // has been found.
 * int birthday; // The selected birthday.
 * birthday = (int)(Math.random()*365);
 * count++;
 * if ( numFound[birthday] == 2 )
 * break; // It's the third time we've found this birthday.
 * numFound[birthday]++;
 * }
 * 
 * System.out.println("It took " + count +
 * " tries to find three people with the same birthday.");
 * The lines shown in red are the ones that differ significantly from the
 * original program. This becomes the body of the main() subroutine in the first
 * program.
 * 
 */

public class BirthdayProblem2 {

    /**
     * Simulate choosing people at random and checking the
     * day of the year they were born on. If the person is
     * the third who was born on that day of the year, stop,
     * and output the number of people who were checked.
     */
    public static void main(String[] args) {

        int[] numFound; // numFound[i] will be the number of people
                        // who have been found who have a birthday
                        // on the i-th day of the year

        int count; // The number of people who have been checked.

        numFound = new int[365]; // Initially, all entries are 0.

        count = 0;

        while (true) {
            // Select a birthday at random, from 0 to 364.
            // If the same birthday was already seen twice
            // before, then quit. Otherwise, add one to
            // the corresponding entry in the numFound array
            // to record that a person with that birthday
            // has been found.
            int birthday; // The selected birthday.
            birthday = (int) (Math.random() * 365);
            count++;
            if (numFound[birthday] == 2)
                break;
            numFound[birthday]++;
        }

        System.out.println("It took " + count +
                " tries to find three people with the same birthday.");

    }

} // end class BirthdayProblem2