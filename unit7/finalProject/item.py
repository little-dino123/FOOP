class Item:
    def __init__(self, number, name, brand, price, tax=1.095):
        self.number = number
        self.name = name
        self.brand = brand
        self.price = price
        self.tax = tax

    def changePrice(self, new):
        self.price = new
        return True

    def getPrice(self):
        return self.price

    def getTax(self):
        return self.tax
