import bankAccount, cart, inventory, item, register, person

myAccount = bankAccount.BankAccount(10000000, "david", 123456789)
myCart = cart.Cart("my cart")
david = person.Person("david", 200, myAccount)
CVS = inventory.Inventory("CVS")
CVSReg1 = register.Register(500)
oreo = item.Item("oreo classic", "Oreo", 4.99, CVS)
cheetos = item.Item("hot cheetos", "Lays", 3.99, CVS)
CVS.addItemQuantity(oreo, 5)
CVS.addItemQuantity(cheetos, 50)
listOfProduct = [oreo, cheetos]
dictOfProduct = {}
for i in listOfProduct:
    dictOfProduct[i.getName()] = i

def mainLoop():
    input0 = int(input("What feature would you like to use?\n1. Shopping\n2. Bank\n3. Inventory management"))
    match input0:
        case 1:
            shopperLoop(myCart, myAccount, david, CVSReg1)
        case 2:
            bankLoop(myAccount, david)
        case 3:
            storeLoop(CVS, CVSReg1)
    pass


def shopperLoop(cart, bank, person, register):
    input0 = input("What action would you like to do " + person.getName() + "?\n1. Add item to cart\n2. Remove item from cart\n3. View Cart\n4. Check out")
    match int(input0):
        case 1:
            print("What Item would you like to add to your cart?")
            print("Options:\n")
            for j in dictOfProduct:
                print(j + "\n")
            input1 = input()
            input2 = int(input("How amny would you like to add?"))
            cart.addItemQuantity(dictOfProduct[input1], input2)
            print("Done! " + input2 + " " + input1 + "(s) has been added to your cart.")
        case 2:
            print("What item would you like to remove?")
            dict = cart.getItemQuantityDict()
            for j in dict:
                print(j + "(s):" + dict[j] + "/n")
            input1 = input()
            input2 = int(input("How many would you like to remove?"))
            cart.addItemQuantity(dict[input1], -input2)
            cart.itemNamesToObjects = dictOfProduct
            print("Done!")
        case 3:
            print(cart.getItemQuantityDict)
        case 4:
            input1 = input("Would you like to check out using cash or card?")
            if input1 == "cash":
                currentCash = person.getCash()
                subtotal = register.getSubtotal(cart.getItemQuantityDict(), dictOfProduct)
                if currentCash < subtotal:
                    person.cash-subtotal
                    register.checkOutCash(subtotal)
                else:
                    print("You dont have enough money")
            else:
                currentCash = bank.currentBalance()
                subtotal = register.getSubtotal(cart.getItemQuantityDict(), dictOfProduct)
                if currentCash < subtotal:
                    bank.withdraw(subtotal)
                    register.checkOutCard(bank,subtotal)
                else:
                    print("You dont have enough money")
        case _:
            print("Invalid, please enter a number between 1-4")


def storeLoop(inv, reg):
    input0 = input("What action would you like to do ?\n1. Add item\n2. Remove item\n3. View Inventory\n4. Check Earning")
    match int(input0):
        case 1:
            print("What item would you like to add?\nOptions:\n")
            for j in dictOfProduct:
                print(j+"\n")
            input1 = input()
            input2 = int(input("How many?"))
            inv.addItemQuantity(dictOfProduct[input1], input2)
            inv.itemNamesToObjects = dictOfProduct
        case 2:
            print("What item would you like to remove?\nOptions:\n")
            for j in dictOfProduct:
                print(j + "\n")
            input1 = input()
            input2 = int(input("How many?"))
            inv.addItemQuantity(dictOfProduct[input1], -input2)
        case 3:
            print(inv.getItemQuantityDict())
        case 4:
            print(reg.getEarning())


def bankLoop(bank, person):
    input0 = input(
        "What action would you like to do ?\n1. Deposit\n2. Withdraw\n3. Check Balance")
    match int(input0):
        case 1:
            input1 = int(input("How much would you like to withdraw?"))
            if bank.withdraw(input1):
                person.cash+=input1
            else:
                print("You don't have enough money in the bank to withdraw")
        case 2:
            input1 = int(input("How much would you like to deposit?"))
            if input1<person.cash:
                person.cash -= input1
                bank.deposit(input1)
            else:
                print("You don't have enough cash to deposit")
        case 3:
            print(bank.currentBalance)

while True:
    mainLoop()