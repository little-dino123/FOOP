class CartTest:
    def __init__(self, name, items={}):
        self.name = name
        self.quantityOfItems = items
    def getItemQuantityDict(self):
        return self.quantityOfItems

    def getItemQuantity(self, item):
        return self.quantityOfItems[item]

    def getItemObjectDict(self):
        return self.itemNamesToObjects

    def getItemObjectDict(self, item):
        return self.itemNamesToObjects[item]

    def addItem(self, item, quantity):
        self.quantityOfItems[item] = quantity if item not in self.items else self.items[item] + quantity
        return True
