class Cart:
    def __init__(self, quantityOfItems={}, itemNamesToObjects={}):
        self.quantityOfItems = quantityOfItems
        self.itemNamesToObjects = itemNamesToObjects

    def getItemQuantityDict(self):
        return self.quantityOfItems

    def getItemQuantity(self, item):
        return self.quantityOfItems[item]

    def getItemObjectDict(self):
        return self.itemNamesToObjects

    def getItemObjectDict(self, item):
        return self.itemNamesToObjects[item]

    def addItemQuantity(self, item, quantity):
        self.quantityOfItems[item] = quantity if item not in self.items else self.items[item] + quantity