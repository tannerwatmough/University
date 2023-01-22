import textio.TextIO;

/**
 * This program evaluates simple expressions such as 2 + 2
 * and 34.2 * 7.81, consisting of a number, an operator,
 * and another number. The operators +, -, *, / are allowed.
 * The program will read and evaluate expressions until
 * the user inputs a line that starts with the number 0.
 * 
 * DISCUSSION
 * 
 * We need a loop to read and evaluate expressions. It's easiest to use a break
 * statement to end the loop at the appropriate time:
 * 
 * Repeat indefinitely:
 * Get the user's input.
 * if the first number is 0:
 * Break out of the loop
 * Find the value of the expression
 * Display the value.
 * Getting the user's input involves reading three data values. We need three
 * variables to store these values. It's best to test whether the first number
 * is 0 right after we read it, so the user will just have to type a 0 to end
 * the program, not a complete expression such as 0 + 0. "Repeat indefinitely"
 * can be written as "while (true)":
 * 
 * while (true):
 * Let firstNum = TextIO.getDouble()
 * if firstNum is 0:
 * Break out of the loop
 * Let operator = TextIO.getChar()
 * Let secondNum = TextIO.getlnDouble()
 * Find the value of the expression
 * Display the value.
 * To evaluate the user's expression, we have to test the operator to find out
 * which operation to compute. We can do this with either a multi-way if
 * statement or with a switch statement. In the program below, I use a switch.
 * The if statement would be:
 * 
 * if ( operator == '+' )
 * value = firstNum + secondNum;
 * else if ( operator == '-' )
 * value = firstNum - secondNum;
 * else if ( operator == '*' )
 * value = firstNum * secondNum;
 * else if ( operator == '/' )
 * value = firstNum / secondNum;
 * else {
 * System.out.println("Unknown operator: " + operator);
 * continue; // back to start of loop
 * }
 * The computer won't let you get away without the else part of the if statement
 * or the default case in the switch, since that would leave a possibility that
 * the variable, value, is not assigned a value before it is printed out, which
 * violates the definite assignment rule. Note that char values are tested for
 * equality using the == operator. Chars are not Strings! Strings would have to
 * be compared using the equals() method from the String class; chars however
 * are primitive type values, and they don't even include any methods.
 * 
 * This program could be improved by having it print out an error message if the
 * user tries to divide by zero.
 * 
 * (This program could use a Scanner instead of TextIO for input, replacing
 * TextIO.getDouble() with stdin.nextDouble() and TextIO.getChar() with
 * stdin.next(), where stdin is the Scanner. (See Subsection 2.4.6) One
 * difference between the behavior of the two versions of the program would be
 * that the TextIO version would accept expressions that have no spaces, such as
 * 17+42, whereas the Scanner version would give an error for such an
 * expression. Another is that scanner.next() returns a String rather than a
 * char, and the character that you want would be the first, and only, character
 * in that string.)
 * 
 */

public class SimpleCalculator {

    public static void main(String[] args) {

        double firstNum; // First number in the expression.
        double secondNum; // Second number in the expression.
        char operator; // The operator in the expression.
        double value; // The value of the expression.

        System.out.println("Enter expressions such as  2 + 2  or  34.2 * 7.81");
        System.out.println("using any of the operators +, -, *, /.");
        System.out.println("To end, enter a 0.");
        System.out.println();

        while (true) {

            /* Get user's input, ending program if first number is 0. */

            System.out.print("? ");
            firstNum = TextIO.getDouble();
            if (firstNum == 0)
                break;
            operator = TextIO.getChar();
            secondNum = TextIO.getlnDouble();

            /* Compute the value of the expression. */

            switch (operator) {
                case '+':
                    value = firstNum + secondNum;
                    break;
                case '-':
                    value = firstNum - secondNum;
                    break;
                case '*':
                    value = firstNum * secondNum;
                    break;
                case '/':
                    value = firstNum / secondNum;
                    break;
                default:
                    System.out.println("Unknown operator: " + operator);
                    continue; // Back to start of loop!
            } // end switch

            /* Display the value. */

            System.out.println("Value is " + value);
            System.out.println();

        } // end while

        System.out.println("Good bye");

    } // end main()

} // end class SimpleCalculator
