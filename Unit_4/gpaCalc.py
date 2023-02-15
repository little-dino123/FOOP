def calc(list):
    total = 0.0
    gradeToNum= {"a":4,
    "b":3,
    "c":2,
    "d":1,
    "f":0}
    for var in list:
        total += gradeToNum[var]
    return total/len(list)
gradeList = []
while True:
    currentGrade = (input("Enter Grade (A, B, C, D, F), Remove Element(r<the index of the element you want to remove, starting at 1>), Or End(n) ").lower())[0]
    if currentGrade == "n":
        print("Your GPA is", calc(gradeList))
        break
    elif currentGrade in "abcdf": gradeList.append(currentGrade)
    elif currentGrade[0]=="r":
        gradeList.pop(int(currentGrade[1])+1)
    else: 
        print("Enter a valid grade (a, b, c, d, f)")
        continue
    print("Your Current GPA is", calc(gradeList))
    print("List of grade is", gradeList)
