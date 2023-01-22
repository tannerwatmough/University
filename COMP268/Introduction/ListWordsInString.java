import textio.TextIO;

/**
 * This program will read one line of input typed by the user.
 * It will print the words from the input, one word to a line.
 * A word is defined to be a sequence of letters. All non-letters
 * in the input are discarded.
 * 
 * DISCUSSION
 * 
 * There are many ways to approach this problem, and probably all of them are
 * sort of tricky to get right. Here's a simple idea that almost works: Go
 * through all the characters in the string. If the character is a letter, write
 * it out. If it's not a letter, write a carriage return instead. If line is a
 * String variable representing the line of text, this algorithm can be coded as
 * 
 * for ( i = 0; i < line.length(); i++ ) {
 * ch = line.charAt(i);
 * if ( Character.isLetter(ch) )
 * System.out.print(ch);
 * else
 * System.out.println();
 * }
 * This prints all the letters in a word on the same line of output. Since words
 * in the string are separated by non-letter characters, and the computer prints
 * a carriage return when it finds a non-letter, words in the output are
 * separated by carriage returns. But there are is a problem with this: If two
 * words in the string are separated by several non-letters, then there will be
 * one or more blank lines between the words in the output. We don't want to
 * output two carriage returns in a row. To avoid this, we can keep track of
 * whether the previous output was a letter or a carriage return. When we find a
 * non-letter, we will output a carriage return only if the previous output was
 * not a carriage return. To keep track of the necessary information, I'll use a
 * boolean variable named didCR. The value of this variable will be true if the
 * previous output was a carriage return. I have to remember to set the value of
 * didCR each time I output something. With this modification, the code becomes:
 * 
 * for ( i = 0; i < line.length(); i++ ) {
 * ch = line.charAt(i);
 * if ( Character.isLetter(ch) ) {
 * System.out.print(ch);
 * didCR = false; // previous output was not a CR
 * }
 * else {
 * if ( didCR == false ) { // output CR, if previous output was NOT a CR
 * System.out.println();
 * didCR = true; // previous output was a CR
 * }
 * }
 * }
 * The program requires an initial value for didCR. In the program below, I
 * output a carriage return before the for loop and set didCR to true. You
 * should be able to follow the rest of the program.
 * 
 * An entirely different approach to this problem is given by the algorithm,
 * "while there are more words in the string, get the next word and print it."
 * This turns out to be even harder to implement than the above.
 * 
 */

public class ListWordsInString {

    public static void main(String[] args) {

        String line; // A line of text, typed in by the user.
        int i; // Position in line, from 0 to line.length() - 1.
        char ch; // One of the characters in line.
        boolean didCR; // Set to true if the previous output was a carriage return.

        System.out.println("Enter a line of text.");
        System.out.print("? ");
        line = TextIO.getln();

        System.out.println();
        didCR = true;

        for (i = 0; i < line.length(); i++) {
            ch = line.charAt(i);
            if (Character.isLetter(ch)) {
                System.out.print(ch);
                didCR = false;
            } else {
                if (didCR == false) {
                    System.out.println();
                    didCR = true;
                }
            }
        }

        System.out.println(); // Make sure there's at least one carriage return at the end.

    } // end main()

} // end class ListWordsInString
