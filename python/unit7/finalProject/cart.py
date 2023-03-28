class Cart:
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

    def getItemObjectDict(self, item):
        return self.itemNamesToObjects[item]

    def addItemQuantity(self, item, quantity):
        self.quantityOfItems[item] = quantity if item not in self.items else self.items[item] + quantity
        return True

    def addItemToObject(self, object):
        self.itemNamesToObjects[object.getName()] = object
        return True
