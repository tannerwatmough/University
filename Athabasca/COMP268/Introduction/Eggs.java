import textio.TextIO;

public class Eggs {

    public static void main(String[] args) {
        int totalEggs;
        int remainingEggs;
        int eggs;
        int gross;
        int dozen;

        System.out.print("How many eggs do you have?: ");
        totalEggs = TextIO.getInt();

        gross = totalEggs / 144;
        remainingEggs = totalEggs % 144;
        dozen = remainingEggs / 12;
        eggs = remainingEggs % 12;

        System.out.print(gross + " gross, ");
        System.out.print(dozen + " dozen, and ");
        System.out.print(eggs + " egg(s).");
    }
}

// PROMPT
// If you have N eggs, then you have N/12 dozen eggs, with N%12 eggs left over.
// (This is essentially the definition of the / and % operators for integers.)
// Write a program that asks the user how many eggs she has and then tells the
// user how many dozen eggs she has and how many extra eggs are left over.

// A gross of eggs is equal to 144 eggs. Extend your program so that it will
// tell the user how many gross, how many dozen, and how many left over eggs she
// has. For example, if the user says that she has 1342 eggs, then your program
// would respond with

// Your number of eggs is 9 gross, 3 dozen, and 10
// since 1342 is equal to 9*144 + 3*12 + 10.

// DISCUSSION
// All the variables for the program will be of type int. The quantities that we
// have to represent are: the number of eggs, the number of dozens in that many
// eggs, and the number of left over eggs. I will declare variables named eggs,
// dozens, and extras to represent these quantities.

// The number of eggs can be read from the user's input using eggs =
// TextIO.getlnInt().

// The description of the problem already tells us that dozens can be computed
// as eggs/12 and extras can be computed as eggs%12. So, the first version of
// the program is easy to write. Note that the entire output from this program
// could have been done with one System.out.printf:

// System.out.print("Your number of eggs is %d dozen and %d extras%n",
// dozens, extras);
// The improved version requires a little thought. Given a pile of eggs that you
// want to divide into gross, dozens, and extras, you could first remove as many
// gross as possible, leaving a pile of between 0 and 143 eggs. This is just
// like dividing the pile into dozens, except that the unit of measure is 144
// eggs instead of 12. So, eggs/144 will give the number of gross, and eggs%144
// is the number of eggs left over. Next, the eggs in the left-over pile still
// have to be divided into dozens, plus some extra number of eggs between 0 and
// 11. Of course, we already know how to do this: If there are N eggs in the
// pile, the number of dozens is N/12 and the number of extra eggs is N%12. This
// leads to the computation in the improved version of the program, shown below.
// (Note that this program uses the variable named aboveGross to represent a
// quantity that is not mentioned explicitly in the problem description. This is
// far from being unusual.)

// SOLUTION - JUST DOZEN
// import textio.TextIO;

// public class Dozens {

// /* This program will convert a given number of eggs into
// the number of dozens plus the number of left over eggs.
// For example, 57 eggs is 4 dozen eggs plus 9 eggs left over.
// The number of eggs is input by the user, and the computed
// results are displayed.
// */

// public static void main(String[] args) {

// int eggs; // Number of eggs, input by user.
// int dozens; // How many dozens in that number of eggs?
// int extras; // How many eggs are left over, above an integral
// // number of dozens? This value is in the
// // range 0 to 11, and it is computed as
// // the remainder when eggs is divided by 12.

// System.out.print("How many eggs do you have? ");
// eggs = TextIO.getlnInt();

// dozens = eggs / 12;
// extras = eggs % 12;

// System.out.print("Your number of eggs is ");
// System.out.print(dozens);
// System.out.print(" dozen and ");
// System.out.print(extras);
// System.out.println();

// } // end main()

// } // end class

// SOLUTION - GROSS
// import textio.TextIO;

// public class GrossAndDozens {

// /* This program will convert a given number of eggs into
// the number of gross plus the number of dozens plus the
// number of left over eggs.
// For example, 1342 eggs is 9 gross plus 3 dozen plus 10.
// The number of eggs is input by the user, and the computed
// results are displayed.
// */

// public static void main(String[] args) {

// int eggs; // Number of eggs, input by user.
// int gross; // How many gross in that number of eggs?
// int aboveGross; // How many eggs are left over, above an
// // integral number of gross? This number
// // can be computed as eggs % 144, and is
// // in the range 0 to 143. This number will
// // be divided into dozens and extras.
// int dozens; // How many dozens in aboveGross?
// int extras; // How many eggs are left over, above integral
// // numbers of gross and dozens?

// System.out.print("How many eggs do you have? ");
// eggs = TextIO.getlnInt();

// gross = eggs / 144;
// aboveGross = eggs % 144;

// dozens = aboveGross / 12;
// extras = aboveGross % 12;

// System.out.print("Your number of eggs is ");
// System.out.print(gross);
// System.out.print(" gross, ");
// System.out.print(dozens);
// System.out.print(" dozen, and ");
// System.out.print(extras);
// System.out.println();

// } // end main()

// } // end class
