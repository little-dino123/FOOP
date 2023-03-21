import turtle as t
import secrets as s
import time

t.hideturtle
options = ["It is certain.",
           "It is decidedly so.",
           "Without a doubt.",
           "Yes definitely.",
           "You may rely on it.",
           "As I see it, yes.",
           "Most likely.",
           "Outlook good.",
           "Yes.",
           "Signs point to yes.",
           "Reply hazy, try again.",
           "Ask again later.",
           "Better not tell you now.",
           "Cannot predict now.",
           "Concentrate and ask again.",
           "Don't count on it.",
           "My reply is no.",
           "My sources say no.",
           "Outlook not so good.",
           "Very doubtful."]


def chooseOption():
    return options[s.randbelow(20)]


def setUpScreen():
    screen.clearscreen()
    screen.setup(569, 565)
    screen.bgpic("/Users/david/Documents/FOOP/Unit_4/magic8Ball/akinator.png")
    pass


screen = t.Screen()
while True:
    setUpScreen()
    input = t.textinput("Input", "Ask Akinator a question or type 'quit'")
    if input != "quit":
        temp = "The answer to your question: " + '"' + input + '"' + "is:"
        t.penup()
        t.goto(-150, 200)
        t.pd()
        t.write(temp, align='center', font=('Georgia', 15, "italic"))
        t.penup()
        t.goto(-150, 150)
        t.pd()
        t.write(chooseOption(), align='center', font=('Georgia', 15, "bold"))
        time.sleep(5)
    else:
        screen.bye()
        break
