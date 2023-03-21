def spanishDictThingy():
    spanish = {
        'one': 'uno',
        'tow': 'dos',
        'three': 'tres',
        'four': 'cuatro',
        'five': 'cinco'
    }
    spanish['six'] = 'siece'
    spanish['seven'] = 'siete'
    spanish['eight'] = 'ocho'
    spanish['nine'] = 'nueve'
    spanish['ten'] = 'diez'
    for var in spanish:
        print(var + " in spanish is " + spanish[var] + ".")


def fruitInventoryThing():
    fruits = {
        'apples': 1,
        'bananas': 4,
        'pears': 17,
        'oranges': 14
    }
    for var in fruits:
        if fruits[var] <= 7:
            print(var + " are almost out of stock! There are " + str(fruits[var]) + " left.")


def countLetters(str1):
    dict = {}
    for x in str1:
        if x in dict:
            dict[x] += 1
            continue
        dict[x] = 1
    return dict


print(countLetters("hello there"))
