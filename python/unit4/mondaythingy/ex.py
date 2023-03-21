f = open("Unit_4/mondaythingy/src.txt", "r")


def upperFile():
    f.seek(0)
    for line in f:
        return line.upper()


def averageSpam():
    f.seek(0)
    total = 0
    count = 0
    for line in f:
        if "X-DSPAM-Confidence:" in line[:21]:
            total += float(line.split()[1])
            count += 1
    else:
        return total / count


print(upperFile())
print(averageSpam())
