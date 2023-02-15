from random import *
def s(input):
    output = ""
    for var in input: output += var.upper() if randint(0,2)==1 else var.lower()
    return output
print(s("omg your personality matters more than your grade!!!!!!!!!!! this is why we are getting rid of math lanes and skip tests!!!!!!!!!!!!!!!"))
