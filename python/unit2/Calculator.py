import tkinter as tk
import math
import random

# init window
main = tk.Tk()
main.title("Four Function Calculator")
main.geometry("300x300")


# calculate function
def calc():
    # get the inputs from boxes
    num1 = int(input1.get())
    num2 = int(input2.get())
    # get the operation to use
    print(dropdown_var.get())
    operation = dropdown_var.get()
    # addition
    if (operation == options[0]):
        output.set(random.randint(0, 12) if num1 == 1 and num2 == 1 else num1 + num2)
    # subtraction
    elif (operation == options[1]):
        output.set(num1 - num2)
    # multiplication
    elif (operation == options[2]):
        output.set(num1 * num2)
    # division
    elif (operation == options[3]):
        output.set(num1 / num2)
    # exponents
    elif (operation == options[4]):
        output.set(num1 ** num2)
    # square root
    elif (operation == options[5]):
        output.set(math.sqrt(num1))
    # sine
    elif (operation == options[6]):
        output.set(math.sin(num1))
    # cosine
    elif (operation == options[7]):
        output.set(math.cos(num1))
    # tangent
    elif (operation == options[8]):
        output.set(math.tan(num1))
    # factorial
    elif (operation == options[9]):
        output.set(math.factorial(num1))
    # set as error if its a error
    else:
        output.set("error")


# disables the 2nd input box when any of the functions are selected as they only need 1 input
def enOrDisable():
    if (dropdown_var.get() in options_functions):
        input2.config(state="disabled")
    else:
        input2.config(state="normal")


# the list of operations that could be selected
options = [
    "+",
    "−",
    "×",
    "÷",
    "xʸ",
    "√",
    "Sin",
    "Cos",
    "Tan",
    "!"
]
# list of funtions for the disabling
options_functions = [
    "√",
    "Sin",
    "Cos",
    "Tan",
    "!"
]
# creates frame because without it the widgets are vertically centered
frame = tk.Frame()
frame.pack()
# creates the variable that stores what is selected in the dropdown
dropdown_var = tk.StringVar(main)
dropdown_var.set(options[0])
# creates entry box 1 and 2, then set default value as 0 to not cause errors
input1 = tk.Entry(frame, width=10)
input2 = tk.Entry(frame, width=10)
input1.insert(0, 0)
input2.insert(0, 0)
# creates dropdown menu with list of operations, calls
dropdown = tk.OptionMenu(frame, dropdown_var, *options, command=enOrDisable())
# basically the calculate button because im too lazy to do the trace thing that automatically calls func calc
equals = tk.Button(frame, text="=", command=calc)
# variable to store the output
output = tk.StringVar(main)
output.set(0)
# label to show the output
result = tk.Label(frame, textvar=output)
# packs all widgets
input1.pack(side=tk.LEFT)
dropdown.pack(side=tk.LEFT)
input2.pack(side=tk.LEFT)
equals.pack(side=tk.LEFT)
result.pack(side=tk.LEFT)
# render
tk.mainloop()
