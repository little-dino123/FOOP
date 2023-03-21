phrase = "Exeggcute evolves into Exeggutor which are two extraordinary Pokemon"
letters = {}
words = phrase.lower().split()
for word in words:
    for c in word:
        if c not in letters:
            letters[c] = 1
        else:
            letters[c] += 1
print(letters["e"])


def remove_middle(tup):
    if len(tup) == 3:
        return (tuple(tup[0], tup[2]))
    else:
        return ("Tuple must be of length 3")


remove_middle((1, 2, 3))
