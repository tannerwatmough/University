import textio.TextIO;

public class StudentScore {

    public static void main(String[] args) {
        String name;
        int test1;
        int test2;
        int test3;
        int average;

        TextIO.readFile("testdata.txt");
        name = TextIO.getWord();
        test1 = TextIO.getInt();
        test2 = TextIO.getInt();
        test3 = TextIO.getInt();

        System.out.println("Name: " + name);
        System.out.println("Test 1: " + test1);
        System.out.println("Test 2: " + test2);
        System.out.println("Test 3: " + test3);

        average = (test1 + test2 + test3) / 3;

        System.out.println("Average: " + average);
    }
}

// PROMPT
// Suppose that a file named "testdata.txt" contains the following information:
// The first line of the file is the name of a student. Each of the next three
// lines contains an integer. The integers are the student's scores on three
// exams. Write a program that will read the information in the file and display
// (on standard output) a message that contains the name of the student and the
// student's average grade on the three exams. The average is obtained by adding
// up the individual exam grades and then dividing by the number of exams.

// DISCUSSION
// TextIO can be used to read data from a file; this is discussed in Subsection
// 2.4.4. To read data from a file named "testdata.txt", all you need to do is
// say TextIO.readFile("testdata.txt"). From then on, the input functions in
// TextIO will read from the file instead of reading data typed in by the user.
// (Note that this assumes that the file is in the same directory with the
// program.) In this case, we can use TextIO.getln() to read the student's name
// from the first line of the file, and then we can read the exam grades by
// calling TextIO.getln() three times.

// The average should be computed as a value of type double. Don't forget that
// if you divide an integer by an integer in Java, the result is an integer and
// the remainder of the division is discarded. To get the correct average in
// this case, the program divides the sum of the three grades by 3.0 rather than
// by 3.

// One final technicality is that simply outputting a double value might print
// out something like 83.333333333333333. By default, all significant digits in
// the number are output. In this case, one digit after the decimal point is
// probably sufficient. The program uses formatted output to achieve this:

// System.out.printf("The average grade for %s was %1.1f", name, average);
// The format string "The average grade for %s was %1.1f" is used to format the
// name and the average. The name is substituted for the format specifier %s,
// which means that the name is printed as a string, with no extra spaces. The
// average is substituted for %1.1f, which means that the average is printed as
// a floating point number with no extra spaces and with 1 digit after the
// decimal point.

// You might want to run this program with no data file, or with a data file
// that is not in the correct format, to see what happens. (The program will
// crash and print an error message.)

// SOLUTION
// import textio.TextIO;

// public class FindAverage {

// public static void main(String[] args) {

// String name; // The student's name, from the first line of the file.
// int exam1, exam2, exam3; // The student's grades on the three exams.
// double average; // The average of the three exam grades.

// TextIO.readFile("testdata.txt"); // Read from the file.

// name = TextIO.getln(); // Reads the entire first line of the file.
// exam1 = TextIO.getlnInt();
// exam2 = TextIO.getlnInt();
// exam3 = TextIO.getlnInt();

// average = ( exam1 + exam2 + exam3 ) / 3.0;

// System.out.printf("The average grade for %s was %1.1f", name, average);
// // So I figured out the formatting. %s correspons to the first variable after
// // the ", and the %1.1f to the second variable also separated by a comma
// // instead
// // of the +.
// System.out.println();

// }

// }