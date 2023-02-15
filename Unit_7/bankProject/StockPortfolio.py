import BankAccount
import StockMarket


class StockPortfolio:
    def __init__(self, name, accountName, bankNum):
        self.name = name
        self.accountName = accountName
        self.bankNum = bankNum
        self.stocks = type(dict)
        pass

    def buyStock(self, ticker, quantity):
        cost = StockMarket.ticker.price * quantity
        if cost <= self.accountName.currentBalance():
            BankAccount.self.accountName.balance -= cost
            self.stocks[ticker] = quantity if ticker not in self.stocks else self.stocks[ticker] + quantity
            return "success"
        else:
            return "error"

    def sellStock(self, ticker, quantity):
        if self.stocks[ticker] >= quantity:
            self.stocks[ticker] -= quantity
            BankAccount.self.accountName.balance += StockMarket.ticker.price * quantity
            return "success"
        else:
            return "error"
