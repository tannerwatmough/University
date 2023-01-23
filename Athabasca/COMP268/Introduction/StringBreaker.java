import textio.TextIO;

public class StringBreaker {

    public static void main(String[] args) {

        String usersName;

        System.out.print("What is your first and last name?   ");
        usersName = TextIO.getln();
    }
}

// PROMPT
// This exercise asks you to write a program that tests some of the built-in
// subroutines for working with Strings. The program should ask the user to
// enter their first name and their last name, separated by a space. Read the
// user's response using TextIO.getln(). Break the input string up into two
// strings, one containing the first name and one containing the last name. You
// can do that by using the indexOf() subroutine to find the position of the
// space, and then using substring() to extract each of the two names. Also
// output the number of characters in each name, and output the user's initials.
// (The initials are the first letter of the first name together with the first
// letter of the last name.) A sample run of the program should look something
// like this:

// Please enter your first name and last name, separated by a space.
// ? Mary Smith
// Your first name is Mary, which has 4 characters
// Your last name is Smith, which has 5 characters
// Your initials are MS

// DISCUSSION
// Once you have the first name and the last name in separate String variables,
// it's easy to produce the desired output. The length of a string, str, can be
// obtained by calling the function str.length(). To get the first character of
// str, you can call str.charAt(0). (Remember that characters are numbered
// starting from zero.) If the first and last names are in the variables
// firstName and lastName, then the output of the program can be produced using

// System.out.println("Your first name is " + firstName + ", which has "
// + firstName.length() + " characters.");
// System.out.println("Your last name is " + lastName + ", which has "
// + lastName.length() + " characters.");
// System.out.println("Your initials are " + firstName.charAt(0) +
// lastName.charAt(0));
// Or, using formatted output to make it easier to read:

// System.out.printf( "Your first name is %s, which has %d characters.%n",
// firstName, firstName.length() );
// System.out.printf( "Your last name is %s, which has %d characters.%n",
// lastName, lastName.length() );
// System.out.print( "Your initials are %s%s%n",
// firstName.charAt(0), lastName.charAt(0) );
// Note that it is not necessary to put values like firstName.length() and
// firstName.charAt(0) into their own variables, if all that you want to do with
// them is print them out. (But some people might consider it better style to
// use variables.)

// The harder part of the problem is breaking up the input string to get the
// first and last name. If the user's input is in a String named input, then
// input.indexOf(' ') is an int that gives the position of the space in the
// string. (Note that the space character is written as a literal that consists
// of a space between two left single quotation marks.)

// Once you have the position of the space, you have to figure out how to use it
// to get the first and last name. Let's look at exactly how the characters in a
// string are numbered:

// M a r y S m i t h
// 0 1 2 3 4 5 6 7 8 9
// In this example, the space is at index 4. We have to extract the substring in
// positions 0 through 3 and the substring in positions 5 through 9. The value
// of input.substring(start,end) will be a string that starts in position start
// and ends in position end-1. Note that the value of the second parameter is
// the position after the end of the substring. So, the fist name in this case
// is input.substring(0,4) and the last name is input.substring(5,10). (Even
// though there is no character in position 10, that's the correct value for the
// position after the end of the substring that we want.) In fact, there's an
// easier way to get the last name, using another version of substring: The
// value of input.substring(start) is the substring starting at position start
// and extending to the end of the string, so the last name in this example is
// input.substring(4).

// The important thing to note here is that the "4" in input.substring(0,4) is
// the index of the space character, and the "5" in input.substring(5) is that
// index plus 1. So we can get the first and last names using:

// space = input.indexOf(' ');
// firstName = input.substring(0,space); // Everything before the space
// lastName = input.substring(space+1); // Everything after the space
// By the way, this program will only work correctly if the user follows the
// instructions. If the user's input does not contain a space, then the value of
// input.indexOf(' ') will be -1, and the -1 will cause the program to crash
// when used in the substring function. And if the input doens't have exactly
// one space, then the program output won't be correct. For now, you don't have
// any way to test the user's input to see whether it is correct. To do that,
// you need to know about if statements, which you will learn about very soon.

// One more remark: Instead of using TextIO.getln() to read a line of text and
// then breaking that line into two words, you could simply use TextIO.getWord()
// twice to read the two words from the same line of input—except that the
// exercise says to use getln().

// SOLUTION
// import textio.TextIO;

// /**
// * This program reads the user's first name and last name,
// * separated by a space. It then prints the user's first and
// * last names separately, along with the number of characters
// * in each name. It also prints the user's initials. Note that
// * this program will crash if the user's input does not contain
// * a space.
// */
// public class FirstNameLastName {

// public static void main(String[] args) {

// String input; // The input line entered by the user.
// int space; // The location of the space in the input.
// String firstName; // The first name, extracted from the input.
// String lastName; // The last name, extracted from the input.

// System.out.println();
// System.out.println("Please enter your first name and last name, separated by
// a space.");
// System.out.print("? ");
// input = TextIO.getln();

// space = input.indexOf(' ');
// firstName = input.substring(0, space);
// lastName = input.substring(space+1);

// System.out.println("Your first name is " + firstName + ", which has "
// + firstName.length() + " characters.");
// System.out.println("Your last name is " + lastName + ", which has "
// + lastName.length() + " characters.");
// System.out.println("Your initials are " + firstName.charAt(0) +
// lastName.charAt(0));

// }

// }
