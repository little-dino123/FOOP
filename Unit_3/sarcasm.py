from random import *
def s(input):
    output = ""
    for var in input: output += var.capitalize() if randint(0,2)==1 else var.lower()
    return output
print(s("Hello there"))