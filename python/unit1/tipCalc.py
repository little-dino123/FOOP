# start window initlization
import tkinter as tk

window = tk.Tk()
window.title("Tip Calculator")


# window.geometry("300x300")
# end window init


# start calculate function
def calculate(*args):
    # get inputs
    input_total = float(entry_1_total.get())
    input_perc = float(entry_2_perc.get())
    input_ppl = int(entry_3_ppl.get())
    # actual math calcs
    no_tip_per_person = round(input_total / input_ppl, 2)
    tip_per_person = round(no_tip_per_person * ((input_perc / 100)), 2)
    total_per_person = no_tip_per_person + tip_per_person
    # changes output to display new text
    output.set("Your total with tip is $" + str(total_per_person) + ", and just tip is $" + str(tip_per_person) + ".")


# end calculate function


# start frame 1(top)
# this frame is the input line for total bill
frame_1 = tk.Frame()
# text in front of input
label_1_total = tk.Label(master=frame_1, text="Total Bill:")
label_1_total.pack(side=tk.LEFT)
# total bill input
entry_1_total = tk.Entry(master=frame_1, width=10)
entry_1_total.pack(side=tk.RIGHT)
# pack frame 1
frame_1.pack()
# end frame 1


# start frame 2
# this frame is the input line for percentage tipped
frame_2 = tk.Frame()
# text in front of input
label_2_perc = tk.Label(master=frame_2, text="Tipping Percentage:")
label_2_perc.pack(side=tk.LEFT)
# percentage tipped input
entry_2_perc = tk.Entry(master=frame_2, width=10)
entry_2_perc.pack(side=tk.RIGHT)
# pack frame 2
frame_2.pack()
# end frame 2


# start frame 3
# this frame is the input line for the number of people
frame_3 = tk.Frame()
# text in front of input
label_3_ppl = tk.Label(master=frame_3, text="Number of People:")
label_3_ppl.pack(side=tk.LEFT)
# number of people input
entry_3_ppl = tk.Entry(master=frame_3, width=10)
entry_3_ppl.pack(side=tk.RIGHT)
# pack frame 3
frame_3.pack()
# end frame 3


# start frame 4
# this frame is for the calculate button
frame_4 = tk.Frame()
# calculate button
button_4_calc = tk.Button(master=frame_4, command=calculate, text="Calculate")
button_4_calc.pack()
# pack frame 4
frame_4.pack()
# end frame 4


# start frame 5
# this frame is the output
frame_5 = tk.Frame()
# initilizes the variable
output = tk.StringVar()
# initial text, before clicking the calculate button
output.set("Your total with tip is $____, and just tip is $____.")
label_5_output = tk.Label(master=frame_5, textvar=output)
label_5_output.pack(side=tk.LEFT)
# pack frame 5
frame_5.pack()
# end frame 5


# runs code
tk.mainloop()
