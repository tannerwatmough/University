# Program author: Tanner Watmough
print("Program author: Tanner Watmough")
# Student ID#: 3554951
print("Student ID#: 3554951")
# Program 1: Math Functions. A line break, \n, is used to give separation between the author/program output. This program will be used to show the use of all six math functions.
print("Program 1: Math Functions\n")

# Initial Hello World program. This calls the print() function that is prebuilt into Python's language library. It will print a variable, print(variable) or a string that is contained between two quotes ("Hello World"). \n is used to make the output easier to read and designates a new line or line break.
print("Hello, world!\n")

# x is a variable which can be changed to any integer value. It is the first value used in the operations below. It is currently 10 but you could put any integer value in for testing (although too large of a number will not be computed such as 100**1000. I think this has to do with the bit representation for 32-bit and 64-bit systems?)
x = 10
# y is a variable which can also be changed to any integer value. It is the second value used in the operations below. It is currently 3 but can be changed to any integer value (including signed!). However, putting y = 0 and dividing will result in a ZeroDivisionError error! You could also use strings, but the outcomes might not be what you expect.
y = 3

# this creates a variable called addition that contains the expression x + y, defined as 10 + 3 in this case. The value is stored in the variable 'addition'.
addition = x + y
# this calls the print() function which will output the value contained in the vairaible "addition". In the case of 10 + 3 it will give the output of 13. I've also printed out the operation name, values of x and y, the operator, the equal sign, and output to match the Program 1 example in the instructions.
print("ADDITION: ", x, "+", y, "=", addition)

# this creates a variable called subtraction that contains the expression x - y, defined as 10 - 3 in this case. The value is stored in the variable 'subtraction'.
subtraction = x - y
# this calls the print() function which will output the value contained in the vairaible "subtraction". In this case of 10 - 3 it will give the output of 7. I've also printed out the operation name, values of x and y, the operator, the equal sign, and output to match the Program 1 example in the instructions.
print("SUBTRACTION: ", x, "-", y, "=", subtraction)

# this creates a variable called multiplication that contains the expression x * y, defined as 10 * 3 in this case. The value is stored in the variable 'multiplication'.
multiplication = x * y
# this calls the print() function which will output the value contained in the vairaible "multiplication". In this case of 10 * 3 it will give the output of 30. I've also printed out the operation name, values of x and y, the operator, the equal sign, and output to match the Program 1 example in the instructions.
print("MULTIPLICATION: ", x, "*", y, "=", multiplication)

# this creates a variable called division that contains the expression x / y, defined as 10 / 3 in this case. The value is stored in the variable 'division'.
division = x / y
# this calls the print() function which will output the value contained in the vairaible "division". In this case of 10/3 it will give the output of 3.3333 repeating. I've also printed out the operation name, values of x and y, the operator, the equal sign, and output to match the Program 1 example in the instructions.
print("DIVISION: ", x, "/", y, "=", division)

# this creates a variable called exponent that contains the expression x ** y, defined as 10^3 in this case. The value is stored in the variable 'exponent'.
exponent = x**y
# this calls the print() function which will output the value contained in the vairaible "exponent". In this case of 10^3 it will give the output of 1000. I've also printed out the operation name, values of x and y, the operator, the equal sign, and output to match the Program 1 example in the instructions.
print("EXPONENT: ", x, "^", y, "=", exponent)

# this creates a variable called remainder that contains the expression x % y, defined as the remainder of 10/3 in this case. The value is stored in the variable 'remainder'.
remainder = x % y
# this calls the print() function which will output the value contained in the vairaible "remainder". In this case it will give the output of 1. I've also printed out the operation name, values of x and y, the operator, the equal sign, and output to match the Program 1 example in the instructions. The line break is once again used here to clean up the output and give space between any new commands in the terminal or other output.
print("REMAINDER: ", x, "%", y, "=", remainder, "\n")
