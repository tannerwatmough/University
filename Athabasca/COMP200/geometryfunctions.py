import math
from os import system, name
from time import sleep
# Program 4: Functions. Program title with line break "\n" to make the program output cleaner. This program will allow users to select various math operations such as permiter and area calculations for squares, rectangles, and circles. After the numbers to be calculated are inputted, the answer is given, and the user is once again allowed to select a menu option, including an option to exit the program.
print("Program 4: Functions\n")

def clear():
    # nt designates a windows system which uses the cls command to clear the terminal.
    if name == 'nt':
        _ = system('cls')
    # this is for any other system which is assumed to be unix based like Mac or Linx. The Unix terminal uses the clear command to clear the terminal.
    else:
        _ = system('clear')


menu = "Calculations Menu:\n1) AREA (SQUARE)\n2) AREA (RECTANGLE)\n3) AREA (CIRCLE)\n4) PERIMETER (SQUARE)\n5) PERIMETER (RECTANGLE)\n6) PERIMETER (CIRCLE)\n7) CLEAR OUTPUTS AND REFRESH MENU\n8) EXIT"
print(menu)

while True:
    try:
        userChoice = int(input("INPUT MENU CHOICE (1,2,3,4,5,6,7 OR 8)? "))
    except ValueError:
        print("Invalid option. Please try again.")
        continue
    if userChoice == 1:
        print("YOU HAVE CHOSEN AREA (SQUARE)")
        while True:
            try:
                length = float(input("INPUT LENGTH? "))
                area = length * length
                print("AREA IS", area)
                break
            except ValueError:
                print("Invalid entry. Please enter a real number.")
                continue
            else:
                break
    elif userChoice == 2:
        print("YOU HAVE CHOSEN AREA (RECTANGLE)")
        while True:
            # For simplicity (and minor efficiency) I am not going to use two loops to ensure the width value is not lost if the length has a ValueError. The program usage will frequently overwrite the variables and not use them outside of the individual menu commands as new ones are always inputted over the old.
            try:
                width = float(input("INPUT WIDTH? "))
                length = float(input("INPUT LENGTH? "))
                area = width * length
                print("AREA IS", area)
                break
            except ValueError:
                print("Invalid entry. Please enter a real number.")
                continue
            else:
                break
    elif userChoice == 3:
        print("YOU HAVE CHOSEN AREA (CIRCLE)")
        while True:
            try:
                radius = float(input("INPUT RADIUS? "))
                area = math.pi * (radius**2)
                print("AREA IS", area)
                break
            except ValueError:
                print("Invalid entry. Please enter a real number.")
                continue
            else:
                break
    elif userChoice == 4:
        print("YOU HAVE CHOSEN PERIMETER (SQUARE)")
        while True:
            try:
                length = float(input("INPUT LENGTH? "))
                perimeter = length * 4
                print("PERIMETER IS", perimeter)
                break
            except ValueError:
                print("Invalid entry. Please enter a real number.")
                continue
            else:
                break
    elif userChoice == 5:
        print("YOU HAVE CHOSEN PERIMETER (RECTANGLE)")
        while True:
            try:
                length = float(input("INPUT LENGTH? "))
                width = float(input("INPUT WIDTH? "))
                # The addition operator is marginally more efficient then the multiplicaiton operator in machine code when it's a multiple of 2. This program is too small for it to matter, but that's my justification for this version of the formula.
                perimeter = length + length + width + width
                print("PERIMETER IS", perimeter)
                break
            except ValueError:
                print("Invalid entry. Please enter a real number.")
                continue
            else:
                break
    elif userChoice == 6:
        print("YOU HAVE CHOSEN PERIMETER (CIRCLE)")
        while True:
            try:
                radius = float(input("INPUT RADIUS? "))
                perimeter = 2 * math.pi * radius
                print("PERIMETER IS", perimeter)
                break
            except ValueError:
                print("Invalid entry. Please enter a real number.")
                continue
            else:
                break
    elif userChoice == 7:
        # This will cause the program to sleep for two seconds, delaying the clear function which will get rid of any recent calculations in the terminal.
        sleep(2)
        # OS neutral clear command
        clear()
        print(menu)
    elif userChoice == 8:
        print("Thanks for using the program. Goodbye!")
        break
    else:
        print("Invalid option. Please try again")
        continue
