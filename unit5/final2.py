# IMPORTANT:
# The Turtle panel is behind the control panel, drag the control panel off to reveal
import turtle
import tkinter as tk
#inits turtle
t = turtle.Turtle()
t.speed(0)
t.hideturtle()
t.pu()
#inits tkinter
root = tk.Tk()
root.title("Controls")
root.geometry("500x200")
#functions for the different types
def polygon(side, size):
    t.clear()
    print("polygon", side, size)
    print(180-(180*(side-2))/side)
    i=0
    t.goto(0,-size/10)
    t.pd()
    while (i<side):
        t.fd(size/side)
        t.lt(180-(180*(side-2))/side)
        i=i+1
        print(t.pos(), t.heading())
    t.pu()
def asterisk(side, size):
    t.clear()
    print("asterisk", side, size)
    print(360/side)
    i=0
    t.goto(0,0)
    t.pd()
    while (i<side):
        t.fd(size)
        t.lt(360/side)
        t.goto(0,0)
        i=i+1
        print(t.pos(), t.heading())
    t.pu()
#pinwheel is wierd at higher side counts
def pinwheel(side, size, modifier):
    t.clear()
    modif = modifier  
    modif = (1/modif)+1
    print("pinwheel", side, size, modif)
    print(180-(180*(side-2))/side)
    i=0
    t.goto(size/(modif**6),size/(modif**6))
    t.pd()
    while (i<side):
        t.fd(size/side)
        t.bk(size/modif)
        t.lt(180-(180*(side-2))/side)
        i=i+1
        print(t.pos(), t.heading())
    t.pu()
#buttons to select which type of shape
polyBut = tk.Button(root, text = "Polygon", command = lambda: polygon(int(side.get()), 5*int(size.get())), width = 7)
astrBut = tk.Button(root, text = "Asterix", command = lambda: asterisk(int(side.get()), int(size.get())), width = 7)
pinBut = tk.Button(root, text = "Pinwheel", command = lambda: pinwheel(int(side.get()), 2*int(size.get()), 1), width = 7)
polyBut.grid(row = 1, column = 1, columnspan = 2)
astrBut.grid(row = 1, column = 3, columnspan = 2)
pinBut.grid(row = 1, column = 5, columnspan = 2)
#slider controls number of sides and size of drawing
side = tk.Scale(root, from_=3, to=100, orient = tk.HORIZONTAL, length = 400)
size = tk.Scale(root, from_=50, to=250, orient = tk.HORIZONTAL, length = 400)
side.grid(row = 2, column = 1, columnspan=6)
size.grid(row = 3, column = 1, columnspan=6)
turtle.done()
