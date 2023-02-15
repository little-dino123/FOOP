#David Z GUI
#tkinter window init
import tkinter as tk
def calculate(*args):
  #get value
  value = float(entry_top.get())
  #calc and rounding
  value = round(value*1.8+32,1)
  #set text
  farenheit.set("is equivalent to " + str(value) + " degrees farenheit")
window=tk.Tk()
window.title("C to F")
#start top frame
frame_top = tk.Frame()
#input cel entry
entry_top = tk.Entry(master=frame_top, width=5)
entry_top.pack(side=tk.LEFT)
#end entry
#start label
label_top = tk.Label(master=frame_top, text="degrees Celsius")
label_top.pack()
#end label
#pack top frame
frame_top.pack()
#end top frame
#start middle frame
frame_middle=tk.Frame()
#start label
farenheit=tk.StringVar()
farenheit.set("is ____ degrees Farenheit")
label_middle = tk.Label(master=frame_middle, textvariable=farenheit)
label_middle.pack()
#end label
#pack middle frame
frame_middle.pack()
#end middle frame
#start middle frame
frame_bottom=tk.Frame()
#start button
button_bottom = tk.Button(master=frame_bottom, text="Calculate", command = calculate)
button_bottom.pack()
#end button
#pack bottom frame
frame_bottom.pack()




window.mainloop()