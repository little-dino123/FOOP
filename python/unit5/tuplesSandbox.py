listOfWords = open("/Users/david/Documents/FOOP/Unit_4/hangman/thing.txt", "r").read().split()
tup = tuple(listOfWords[:20])
print(tup)
temp = ()
for i in range(len(tup)):
    # print(tup[i],tup[i+1:])
    if i < len(tup):
        if i % 2 == 0:
            temp = tuple(tup[i].upper()) + tup[i + 1:]
            tup = temp
            pass
print(tup)
