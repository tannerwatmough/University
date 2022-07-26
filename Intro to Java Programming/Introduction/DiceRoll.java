public class DiceRoll {
    public static void main(String[] args) {
        int rollOne;
        int rollTwo;
        int totalRoll;

        rollOne = (int) (Math.random() * 6) + 1;
        rollTwo = (int) (Math.random() * 6) + 1;
        totalRoll = rollOne + rollTwo;

        System.out.println("The first die comes up " + rollOne);
        System.out.println("The second die comes up " + rollTwo);
        System.out.println("Your total roll is " + totalRoll);
    }
}

// DICE ROLLER PROMPT

// Write a program that simulates rolling a pair of dice. You can simulate
// rolling one die by choosing one of the integers 1, 2, 3, 4, 5, or 6 at
// random. The number you pick represents the number on the die after it is
// rolled. As pointed out in Section 2.5, the expression

// (int)(Math.random()*6) + 1
// does the computation to select a random integer between 1 and 6. You can
// assign this value to a variable to represent one of the dice that are being
// rolled. Do this twice and add the results together to get the total roll.
// Your program should report the number showing on each die as well as the
// total roll. For example:

// The first die comes up 3
// The second die comes up 5
// Your total roll is 8

// DICE ROLLER - TEXTBOOK DISCUSSION

// When designing a program, one of the first things you should ask yourself is,
// "What values do I need to represent?" The answer helps you decide what
// variables to declare in the program. This program will need some variables to
// represent the numbers showing on each die and the total of the two dice.
// Since these numbers are all integers, we can use three variables of type int.
// I'll call the variables die1, die2, and roll. The program begins by declaring
// the variables:

// int die1;
// int die2;
// int roll;
// In the actual program, of course, I've added a comment to explain the purpose
// of each variable. The values of die1 and die2 can be computed using the
// expression given in the exercise:

// die1 = (int)(Math.random()*6) + 1;
// die2 = (int)(Math.random()*6) + 1;
// Note that even though the expressions on the right-hand sides of these
// assignment statements are the same, the values can be different because the
// function Math.random() can return different values when it is called twice.

// We can then compute roll = die1 + die2 and use three System.out.println
// statements to display the three lines of output:

// System.out.println("The first die comes up " + die1);
// System.out.println("The second die comes up " + die2);
// System.out.println("Your total roll is " + roll);
// Note that I've chosen to use the concatenation operator, +, to append the
// value of die1 onto the string "The first die comes up". Alternatively, I
// could use two output statements:

// System.out.print("The first die comes up ");
// System.out.println(die1);
// Yet another possibility is to use System.out.printf:

// System.out.printf("The first die comes up %d%n", die1);
// I'll also note that I could get away without the variable roll, since I could
// output the value of the expression die1 + die2 directly:

// System.out.println("Your total roll is " + (die1 + die2));
// However, it's generally better style to have a meaningful name for a
// quantity. By the way, the parentheses around (die1 + die2) are essential
// because of the precedence rules for the + operator. You might try to
// experiment with leaving them out and see what happens.

// TEXTBOOK PROGRAM SOLUTION
// public class RollTheDice {

// /* This program simulates rolling a pair of dice.
// The number that comes up on each die is output,
// followed by the total of the two dice.
// */

// public static void main(String[] args) {

// int die1; // The number on the first die.
// int die2; // The number on the second die.
// int roll; // The total roll (sum of the two dice).

// die1 = (int)(Math.random()*6) + 1;
// die2 = (int)(Math.random()*6) + 1;
// roll = die1 + die2;

// System.out.println("The first die comes up " + die1);
// System.out.println("The second die comes up " + die2);
// System.out.println("Your total roll is " + roll);

// } // end main()

// } // end class
