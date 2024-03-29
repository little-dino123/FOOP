
class Inventory:
    def __init__(self, name, quantityOfItems={}, itemNamesToObjects={}):
        self.name = name
        self.quantityOfItems = quantityOfItems
        self.itemNamesToObjects = itemNamesToObjects

    def getItemQuantityDict(self):
        return self.quantityOfItems

    def getItemQuantity(self, item):
        return self.quantityOfItems[item]

    def getItemObjectDict(self):
        return self.itemNamesToObjects

    def getItemObject(self, item):
        return self.itemNamesToObjects[item]

    def addItemQuantity(self, item, quantity):
        self.quantityOfItems[item] = quantity if item not in self.quantityOfItems else self.quantityOfItems[item] + quantity
