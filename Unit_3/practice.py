def stringPractice(input):
    list = input.split(" ")
    firstname = list[0].capitalize()
    firstname = firstname[:-1]+firstname[-1].upper()
    firstname = firstname[:round(len(firstname)/2)]+firstname[round(len(firstname)/2)].upper()+firstname[round(len(firstname)/2)+1:]
    lastname = list[1].capitalize()
    lastname = lastname[:-1]+lastname[-1].upper()
    lastname = lastname[:round(len(lastname)/2)]+lastname[round(len(lastname)/2)].upper()+lastname[round(len(lastname)/2)+1:]
def bestChars(a,b,string):
    i=0
    for var in string: i+=1 if var==a or var==b else 0
    return i
# print(bestChars("d", "z", "The FitnessGram™ Pacer Test is a multistage aerobic capacity test that progressively gets more difficult as it continues. The 20 meter pacer test will begin in 30 seconds. Line up at the start. The running speed starts slowly, but gets faster each minute after you hear this signal. [beep] A single lap should be completed each time you hear this sound. [ding] Remember to run in a straight line, and run as long as possible. The second time you fail to complete a lap before the sound, your test is over. The test will begin on the word start. On your mark, get ready, start."))
def findNumber(str1, str2):
    print(float(str1[str1.find(".")-1:]), float(str2[str2.find(".")-1:]))
# findNumber("X-DSPAM-Confidence: 0.8475", "Z-DIN-Percent: 0.543")
def fml(string):
    output = string[0]+string[int(round(len(string)/2, 0))]+string[-1]
    return output
# print(fml("david"))
def badWord(input, word):
    inputList = input.split()
    output = ""
    for var in inputList:
        if var in word:
            output+=var[0]+("*"*(len(var)-1))+" "
        else:
            output+=var+" "
    return output
badWordList = ["coke", "pepsi"]
print(badWord("pepsi is not better than coke , coke is the best, pepsi sucks.", badWordList))