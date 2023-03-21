f = open("Unit_5/emailDayProblem/data.txt", "r")


# f=open("Unit_5/emailDayProblem/test.txt","r")
def getdate(line):
    lineList = line.split()
    return lineList[2]


days = {
    "Mon": 0,
    "Tue": 0,
    "Wed": 0,
    "Thu": 0,
    "Fri": 0,
    "Sat": 0,
    "Sun": 0
}
for line in f:
    if line[:5] == "From ":
        days[getdate(line)] += 1
print(days)
f.close()
