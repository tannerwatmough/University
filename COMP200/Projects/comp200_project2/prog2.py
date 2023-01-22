# Program author: Tanner Watmough
print("Program author: Tanner Watmough")
# Student ID#: 3554951
print("Student ID#: 3554951")
# Program title with line break "\n" to make the program output cleaner. This program is intended to allow users to input two different strings and two variables; then the program adds the two strings together and multiplys the two inputted numbers together on a new line.
print("Program 2: Using Input\n")

# This will display an input prompt for the user with the description of "Input string 1: " and then save the user's input in the string1 variable. If a number is entered, it will still be considered a valid string and no error will occur.
string1 = input("Input string 1? ")
# This will display an input prompt for the user with the description of "Input string 2: " and then save the user's input in the string2 variable. If a number is entered, it will still be considered a valid string and no error will occur.
string2 = input("Input string 2? ")

# This is where the overengineering begins. A common error that can occur is a user trying to input invalid characters, i.e., not 0-9 numerical digits. If they tried to input a string with the int() function, it would result in a ValueError: invalid literal for int() with base 10: 'string'. This would then exit the program. The while loop used here will ensure that any ValueErrors that occur will instead print an error message and loop back to let the user try again instead of exiting the program. The error message will prompt the user to use an integer number instead and, if successful, exit the loop and continue. Two loops are necessary as otherwise entering a valid integer for Integer A would work, the loop would hit Integer B, and if an invalid character was used, the user would need to reinput the value for Integer A as well as Integer B. With two loops, Integer A will not be lost if there is a ValueError for B. While overengineered for this simple project, it would lead to user frustration in larger input scenarios.

# Loop 1 for Integer A to ensure valid integer is entered and we avoid the ValueError.
while True:
    # The loop will first try getting a valid integer input from the user and save it into integerA.
    try:
        # This will display an input prompt for the user with the description of "Input integer 1: " and then save the user's input in the integerA variable. The input needs to be wrapped in int() and transformed into an integer as the user input is taken as a string, not an integer, otherwise. This ensures it can be later multiplied. If not there would be a TypeError: can't multiply sequence by non-int of type 'str' or cannot multiply sequence by a non-integer value of the string type.
        integerA = int(input("Input integer A? "))
    # If an invalid character (non-integer) is used, a ValueError will occur and trigger this part of the loop.
    except ValueError:
        # This uses the print() function to provide a prompt to the user that they need to add a numerical integer instead.
        print("Sorry, you tried to enter an invalid character or value. Please enter an integer, a whole and non-fractional number, instead.")
        # This will restart the loop so they can once again try to enter a value for integerA.
        continue
    # If the value inputted by the user is a valid integer, the loop will break and the sequential steps of the algorithm will take over again.
    else:
        break

# Loop 2 for Integer B to ensure valid integer is entered and we avoid the ValueError. The second loop ensures that IntegerA's value is not destroyed.
while True:
    # The loop will first try getting a valid integer input from the user and save it into integerB.
    try:
        # This will display an input prompt for the user with the description of "Input integer 2: " and then save the user's input in the integerB variable. The input needs to be wrapped in int() and transformed into an integer as the user input is taken as a string, not an integer, otherwise. This ensures it can be later multiplied. If not there would be a TypeError: can't multiply sequence by non-int of type 'str' or cannot multiply sequence by a non-integer value of the string type.
        integerB = int(input("Input integer B? "))
    # If an invalid character (non-integer) is used, a ValueError will occur and trigger this part of the loop.
    except ValueError:
        # This uses the print() function to provide a prompt to the user that they need to add a numerical integer instead.
        print("Sorry, you tried to enter an invalid character or value. Please enter an integer, a whole and non-fractional number, instead.")
        # This will restart the loop so they can once again try to enter a value for integerB.
        continue
    # If the value inputted by the user is a valid integer, the loop will break and the sequential steps of the algorithm will take over again.
    else:
        break

# This combines the two strings together. If two numbers were input for the two strings, it will not perform an addition operation but combine them into one string. In the case of of 23 and 2, it will become 232.
print(string1 + string2)

# This multiplies the intgers together, integerA by IntegerB.
print(integerA * integerB)
