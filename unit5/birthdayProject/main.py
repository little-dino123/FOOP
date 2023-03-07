# Imports the file with the data in read mode.
f=open("Unit_5/birthdayProject/birthday.txt","r")
# Creates a dictionary with is used to store the name and birthday while the program is running.
birthdayDict={}
# Boolean to tell the main loop if it should exit.
onOrOff=True
# The function to extract the data from the file, and store it in the dictionary that was created.
def createBirthdayDict():
    # Creates local boolean i (idk why i named it that).
    i=True
    # Iterate through the lines in the file.
    for line in f:
        # Takes a slice excluding the last character because that is a newline character.
        var = line[:-1]
        # If i is True, it means that it is a odd line which means it is the name of the person.
        if i==True:
            # Stores the person's name as local variable key
            key = var
        # If i is False, it means that it is a even line which means it is the birthday of the person.
        elif i==False:
            # Creates a new entry in the dictionary with name a birthday.
            birthdayDict[key]=var
        # Flips the boolean so that the odd even thing works.
        i=not i
    # After the for loop is finished, it resets the pointer position to 0 just in case I need to use it later.
    else: 
        f.seek(0)
# When this function is called, it prints out all the variables in a nice way
def printAllBirthday():
    # Iterates through the keys in birthdayDict and then prints them out in a nice way with the matching birthday
    for name in birthdayDict:
        print(name.capitalize()+"'s birthday is on "+birthdayDict[name])
# This function allows the user to search for a person, and prints out the birthday, if the person is not on the list, it will ask the user if they want to add them, and calls the addBirthday function if the user says yes.
def printNameBirthday():
    # Ask the user for whose birthday they would like to know
    name=input("Whose birthday do you want to know? ")
    # If the person is in the dictionary, the program prints out the birthday.
    if name.lower() in birthdayDict:
        print(name.capitalize()+"'s birthday is on "+birthdayDict[name])
        return
    # If the person is not in the list, the program asks if they would like to add that person, and if they say yes, it will invoke the addBirthday function, if not, it will exit and return to main loop
    else:
        yesno=input("This person is not in the list, would you like to add them? ")
        if yesno=="yes" or yesno=="y":
            addBirthday(name)
        else: 
            return
# This is the function to add a birthday to the file.
def addBirthday(name):
    # This figures out if it is being called from the menu or the search function.
    # If it is from the search funtion the name that needs to be added is already known.
    # Otherwise it asks for the name.
    if name=="menu":name=input("What is the person's name? ")
    # Asks for the birthday of the person
    date=input("What is "+name+"'s birthday in mm/dd/yyyy format? ")
    # Adds the birthday to the list if they are not already on the list.
    if name not in birthdayDict:
        birthdayDict[name]=date
        print(name+"'s birthday added!")
        return
    # If they are already on the list, the program asks if the user wants to change that person's birthday
    else: 
        yesno=input("This person is already on the list! Would you like to change their birthday?")
        # If yes, it calls that function and provides name.
        if yesno=="yes" or yesno=="y":
            changeBirthday(name)
        # Otherwise it goes back into the main loop.
        else:
            return
# This is the function that removes a birthday from the list.
def removeBirthday():
    # It doesn't check like the other functions because this can only be called from the main menu.
    name=input("Whose birthday do you want to remove from the list? ")
    # If the name is in the list, it pops and removes it, and prints a confirmation message.
    if name in birthdayDict:
        birthdayDict.pop(name)
        print(name+" is removed from the list!")
    # if the name is not in the list, it asks if the user wants to add them to the list.
    else:
        yesOrNo=input(name+" is not in the list, would you like to add them? ")
        # If yes, it calls the add function and provides the name.
        if yesOrNo=="yes" or yesOrNo=="y":
            addBirthday(name)
        # Otherwise returns to the main loop.
        else:
            return
# This function edits the birthday of a person.
def changeBirthday(name):
    # This figures out if it is being called from the menu or the add function.
    # If it is from the add funtion the name that needs to be added is already known.
    # Otherwise it asks for the name.
    if name=="menu":name=input("What is the person's name? ")
    # Asks for the new birthday.
    date=input("What do ytou want to change "+name+"'s birthday to in mm/dd/yyyy format? ")
    # Changes the birthday if the person is already on the list.
    if name in birthdayDict:
        birthdayDict[name]=date
        print(name+"'s birthday changed!")
        return
    # If they are not already on the list, the program asks if the user wants to add that person's birthday.
    else: 
        yesno=input("This person is not on the list! Would you like to add their birthday?")
        # If yes, it calls that function and provides name.
        if yesno=="yes" or yesno=="y":
            addBirthday(name)
        # Otherwise it goes back into the main loop.
        else:
            return
# This function saves the dictionary to the .txt file for storage, then exits the loop and ends the program.
def saveAndExit():
    # Opens the file in write mode and goes to the beginning just in case.
    f=open("Unit_5/birthdayProject/birthday.txt","w")
    f.seek(0)
    # And for each name saves it to the file with a newline, then prints a confirmation.
    for name in birthdayDict:
        f.write(name+"\n")
        f.write(birthdayDict[name]+"\n")
        print(name+"'s birthday saved!")
    # Executed when the for loop is done.
    else:
        # Turns the switch False, which stops the main loop.
        global onOrOff
        onOrOff=False
        # Saves and closes the file.
        f.close()
        # Prints a confirmation.
        print("Done! Closing...")
# The main menu function, called by the main loop.
def menu():
    # Prints all the options.
    print('\nType "all" to view all Birthdays'+'\nType "search" to search for a birthday'+'\nType "add" to add a birthday'+'\nType "remove" to remove a birthday'+'\nType "change" to change a birthday'+'\nType "exit" to save and exit')
    # This is for debugging.
    # print(birthdayDict)
    # Asks user for choice.
    option=input()
    # Calls the appropriate function according to the choice.
    if option.lower()=="all":
        printAllBirthday()
    elif option.lower()=="search":
        printNameBirthday()
    elif option.lower()=="add":
        addBirthday("menu")
    elif option.lower()=="remove":
        removeBirthday()
    elif option.lower()=="change":
        changeBirthday("menu")
    elif option.lower()=="exit":
        saveAndExit()
    # If it is not one of the valid options, it prints a message and ends the function
    else:
        print("Your choice was invalid, please try again.")
        return
        print("Your choice was invalid, please try again.")
        return
# Calls the function that fills in the dictionary
createBirthdayDict()
# This is the main loop.
# While the onOrOff boolean is on, it calls the menu function, which handles everything.
# It only ends when the save and exit function turns the boolean False.
while onOrOff==True:
    menu()