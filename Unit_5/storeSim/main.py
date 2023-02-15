def printMenu():
    print(price)
    print(quantity)
    print("Press 1 to make a sale")
    print("Press 2 to take a delivery")
    print("Press 3 to change a price")
    print("Press 4 to quit")
def menu():
    printMenu()
    choice=input()
    if choice=="1":
        item=input("What item did you sell?\n")
        num=input("How many "+item+"(s) did you sell?\n")
        sale(item,int(num))
    elif choice=="2":
        item=input("What item did you take delivery of?\n")
        num=input("How many "+item+"(s) did tkae delivery of?\n")
        delivery(item,int(num))
    elif choice=="3":
        item=input("What item would you like to change the price of?\n")
        new=input("What would you like to change "+item+"'s price to?\n")
        change(item,int(new))
    elif choice=="4":
        return False
def sale(item, num):
    quantity[item]-=num
    print("The stock for "+item+" is now",quantity[item])
def delivery(item, num):
    quantity[item]+=num
    print("The stock for "+item+" is now",quantity[item])
def change(item, new):
    price[item]=new
    print("The price for "+item+" is now",price[item])
global price
global quantity
price={"ps5":599,"rtx 4090":1599,"i9 13900k":589,"ryzen 7950x":699,"macbook pro":1999,"macbook air":999}
quantity={}
for x in price:
    quantity[x]=10
while True:
    if menu()==False:
        printMenu()
        break