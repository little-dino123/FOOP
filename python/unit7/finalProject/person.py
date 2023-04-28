class Person:
    def __init__(self,name,cash,bank):
        self.name = name
        self.cash = cash
        self.bank = bank
    def getName(self):
        return self.name
    def getCash(self):
        return self.cash
    def getBank(self):
        return self.bank

    def setCash(self,cash):
        self.cash = cash