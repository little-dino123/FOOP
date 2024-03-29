class Item:
    def __init__(self, name, brand, price, store, tax=1.095):
        self.name = name
        self.brand = brand
        self.price = price
        self.store = store
        self.tax = tax

    def changeName(self,new):
        self.name = new
    def changePrice(self, new):
        self.price = new
    def getPrice(self):
        return self.price

    def getPriceWithTax(self):
        return self.price * self.tax

    def getName(self):
        return self.name
