# Program 3: LOOPS AND IF CONDITIONS. Program title with line break "\n" to make the program output cleaner. This program will request a password after the program information is displaye and ask for an input name that will have conditional responses.
print("Program 3: Loops and if conditions\n")

password = "hello"
authorName = "tanner"
# Madonna and Cher both will trigger the same response so can be stored together in a list to simplify the second loop.
popstarNames = ["madonna", "cher"]

while True:
    userPassword = input("Password? ")
    if userPassword == password:
        break
    else:
        print("Invalid password")
        continue

while True:
    userName = input(
        "Welcome to the second half of the program! \nWhat is your name? ")
    # The .lower() function will take any case input and transform it into all lowercase. This prevents a user from entering MadonnA or cHer by accident and not getting the correct response as Madonna != madonna and vice versa.
    userName = userName.lower()
    if userName == authorName:
        print("What a great name!")
        break
    # checks if username is in the popstarNames list.
    elif userName in popstarNames:
        print("May I have your autograph, please?")
        break
    # all cases that aren't in popStarNames or equal to the authorName will go here.
    else:
        # userName.capitalize() is used to undo our lowering from before to capitalize the first letter of the name. The strings are concateanted because otherwise there will be an awkward space between the "," and the userName variable in the output.
        print(userName.capitalize() + ", that's a nice name")
        break
