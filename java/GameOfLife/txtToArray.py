f = open("board.txt")
output = "{"
for i in f:
    output+="{"
    for j in i:
        if j=="-":
            output+="D, "
        elif j=="*":
            output+="A, "
    output = output[:-2]
    output+="},\n"
output = output[:-2]
print(output+"};")