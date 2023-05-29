import inventory, item

CVS = inventory.Inventory("CVS")
oreo = item.Item("oreo classic", "Oreo", 4.99, CVS)
cheetos = item.Item("hot cheetos", "Lays", 3.99, CVS)
CVS.addItemQuantity(oreo, 5)
CVS.addItemQuantity(cheetos, 50)
listOfProduct = [oreo, cheetos]
dictOfProduct = {}
for i in listOfProduct:
    dictOfProduct[i.getName()] = i

def mainLoop():
    storeLoop(CVS)

def storeLoop(inv):
    input0 = input("What action would you like to do ?\n1. Add item\n2. Remove item\n3. View Inventory\n")
    match input0:
        case "1":
            print("What item would you like to add?\nOptions:")
            for j in dictOfProduct:
                print(j)
            input1 = input()
            input2 = int(input("How many?\n"))
            inv.addItemQuantity(dictOfProduct[input1], input2)
            inv.itemNamesToObjects = dictOfProduct
        case "2":
            print("What item would you like to remove?\nOptions:")
            for j in dictOfProduct:
                print(j)
            input1 = input()
            input2 = int(input("How many?\n"))
            inv.addItemQuantity(dictOfProduct[input1], -input2)
        case "3":
            itemdict = inv.getItemQuantityDict()
            for itemObj in itemdict:
                name = itemObj.getName()
                print(name +":" + str(itemdict[itemObj]))

while True:
    mainLoop()