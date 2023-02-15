class StockPortfolio:
    def __init__(self, name, accountName, bankNum):
        self.name = name
        self.accountName = accountName
        self.bankNum = bankNum
        self.stocks= type(dict)
        pass

    def buyStock(self, name, ticker, quantity):
        if ticker.price*quantity <= self.accountName.currentBalance():
            pass
        else:
            return "Error, not enough money"
