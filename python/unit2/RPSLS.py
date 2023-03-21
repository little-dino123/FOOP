# library imports
# import RNG
import secrets
# import GUI
import tkinter as tk

# tkinter window init
# create GUI window
window = tk.Tk()
# set window title
window.title("Rock Paper Scissors Lizard Spock")
# set window size
window.geometry("500x100")


# function for making buttons in a single line later
def make_button(master, but_name, but_command, but_text):
    # makes the button using arguments
    but_name = tk.Button(master, text=but_text, command=but_command)
    # pack button
    but_name.pack(side=tk.LEFT)


# all  calculations and logic for the game
def play(entry):
    # generates a random number from 1-5 inclusive
    comp = (secrets.randbelow(4) + 1)

    # assigns a string to a variable for each computer choice for display later on
    if (comp == 1):
        comp_play = "Rock"
    elif (comp == 2):
        comp_play = "Paper"
    elif (comp == 3):
        comp_play = "Scissor"
    elif (comp == 4):
        comp_play = "Lizard"
    elif (comp == 5):
        comp_play = "Spock"
    else:
        comp_play = "Error"

    # assigns a string to a variable for each player choice for display later on
    if (entry == 1):
        player_play = "Rock"
    elif (entry == 2):
        player_play = "Paper"
    elif (entry == 3):
        player_play = "Scissor"
    elif (entry == 4):
        player_play = "Lizard"
    elif (entry == 5):
        player_play = "Spock"
    else:
        player_play = "Error"
    # prints some stuff for debugging if needed
    print("Input:", entry)
    print("Computer RNG:", comp)
    # decides if player wins or looses using equation given
    # also sets text for display
    w_l_var = (comp - entry + 5) % 5
    print("Win or Lose:", w_l_var)
    if (w_l_var == 1 or w_l_var == 2):
        w_l_text = "You Win!"
        print("Win")
    elif (w_l_var == 0):
        w_l_text = "It's a Tie!"
        print("Tie")
    elif (w_l_var == 3 or w_l_var == 4):
        w_l_text = "You Lose!"
        print("Lose")
    else:
        print("Error")
    # temporary varibale beccause .set doesn't allow multiple arguments
    # use + because there's weird parenthese with commas
    w_l_temp = 'You Played ' + player_play + '. The Computer Plays ' + comp_play + ". " + w_l_text
    # prints string for debugging purposes
    print(w_l_temp)
    # sets the stringvar display text
    w_l.set(w_l_temp)


# displays text at the top
# creates frame
frame_w_l = tk.Frame()
# creates text variable
w_l = tk.StringVar(master=frame_w_l)
# sets above textvar
w_l.set("Choose a Play!")
# creates label that shows the text
label_w_l = tk.Label(master=frame_w_l, textvariable=w_l)
# pack label
label_w_l.pack()
# pack frame
frame_w_l.pack()

# buttons
# frame for buttons
frame_button = tk.Frame()
# button creation using function
# rock button
make_button(frame_button, "button_rock", lambda: play(1), "Rock")
# paper button
make_button(frame_button, "button_paper", lambda: play(2), "Paper")
# scissor button
make_button(frame_button, "button_scissor", lambda: play(3), "Scissor")
# lizard button
make_button(frame_button, "button_lizard", lambda: play(4), "Lizard")
# spock button
make_button(frame_button, "button_spock", lambda: play(5), "Spock")
# pack button frame
frame_button.pack()

# Renders GUI
tk.mainloop()
