class Cart:
    def __init__(self):
        self.items = {}

    def getItems(self):
        return self.items

    def getQuantity(self, item):
        return self.items[item]

    def addItem(self, item, quantity, add=True):
        self.items[item] = quantity if item not in self.items else (
            self.items[item] + quantity if add else self.items[item] - quantity)
        return True
