# opens, reads and saves the content of the text file to the text variable
text = open('/Users/david/Documents/FOOP/Unit_4/uniqueWords/text.txt', 'r').read()
# outputs original text just to check
print("Original Text:\n" + text)
# makes a list of words from the text then makes it all lowercase
textList = text.split()
for i in range(len(textList)):
    textList[i] = textList[i].lower()
# This creates a list with one of each word(no repeats)
endList = []
for i in range(len(textList)):
    currentWord = textList[i]
    if currentWord not in endList[:i]: endList.append(currentWord)
# sorts and print the list
endList = sorted(endList)
print(endList)
# creates a dictionary for counting how many times each word is used
usage = {}
print(endList)
for i in endList:
    usage[i] = 0
for i in textList:
    usage[i] += 1
print(usage)
