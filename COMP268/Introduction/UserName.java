import textio.TextIO;

public class UserName {

    public static void main(String[] args) {
        String username;

        System.out.println("What is your name?");
        username = TextIO.getln();
        System.out.println("Hello, " + username.toUpperCase() + ", nice to meet you!");

    }
}

// EXERCISE PROMPT
// Write a program that asks the user's name, and then greets the user by name.
// Before outputting the user's name, convert it to upper case letters. For
// example, if the user's name is Fred, then the program should respond "Hello,
// FRED, nice to meet you!".

// DISCUSSION TEXTBOOK
// In order to read the name typed in by the user, this program uses one of the
// input routines from the non-standard TextIO class. So, this program can only
// be run if that class is available to the program, and the program should
// start with the import directive import textio.TextIO. I will use System.out
// for output. (Although it is possible to use TextIO for output as well as for
// input, I will generally avoid that option in my examples.)

// A name is a sequence of characters, so it is a value of type String. The
// program must declare a variable of type String to hold the user's name. I
// declare another variable to hold the user's name with all the letters in the
// name converted to upper case. The conversion might be difficult, except that
// String objects have a function that lets you do the conversion with one line
// of code. If usersName is the variable that refers to the name that the user
// enters, then the function call usersName.toUpperCase() returns the string
// obtained by replacing any lower case letters in the name with upper case
// letters.

// There are several functions in the TextIO class that can be used for reading
// Strings: getWord(), getlnWord(), and getln(). The first two routines only
// read a single word, so if the user entered "David J. Eck", they would only
// read the first name, "David". The getln() routine will read the entire line,
// and so would get the whole name. For this program, I use getln(), but you
// might prefer to use just the first name.

// I also give a version of the program that uses the built-in class Scanner,
// instead of TextIO, for reading input from the user. See Subsection 2.4.6 for
// a discussion of the Scanner class. In the second version of the program, a
// Scanner named stdin is created, and the user's input is read using the
// function stdin.nextLine(), which has essentially the same functionality as
// TextIO.getln().

// (For this program, by the way, TextIO.getWord() and TextIO.getlnWord() would
// be equivalent. They return the same value. The second version of the routine,
// getlnWord(), would then discard the rest of the user's line of input.
// However, since this program is only doing one input operation, it doesn't
// matter whether it's discarded. It would only matter when it came time to read
// a second value from input.)

// TEXTBOOK SOLUTION - TEXTIO
// import textio.TextIO;

// public class Greeting {

// /* This program asks the user's name and then
// greets the user by name. This program depends
// on the non-standard class, TextIO.
// */

// public static void main(String[] args) {

// String usersName; // The user's name, as entered by the user.
// String upperCaseName; // The user's name, converted to upper case letters.

// System.out.print("Please enter your name: ");
// usersName = TextIO.getln();

// upperCaseName = usersName.toUpperCase();

// System.out.println("Hello, " + upperCaseName + ", nice to meet you!");

// } // end main()

// } // end class

// TEXTBOOK SOLUTION - SCANNER
// import java.util.Scanner;

// public class GreetingWithScanner {

// public static void main(String[] args) {

// Scanner stdin = new Scanner( System.in );

// String usersName; // The user's name, as entered by the user.
// String upperCaseName; // The user's name, converted to upper case letters.

// System.out.print("Please enter your name: ");
// usersName = stdin.nextLine();

// upperCaseName = usersName.toUpperCase();

// System.out.println("Hello, " + upperCaseName + ", nice to meet you!");

// } // end main()

// } // end class