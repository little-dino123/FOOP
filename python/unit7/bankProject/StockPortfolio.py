import BankAccount
import StockMarket


class StockPortfolio:
    def __init__(self, name, accountName, bankNum):
        self.name = name
        self.accountName = accountName
        self.bankNum = bankNum
        self.portfolio = type(dict)
        return "success"

    def buyStock(self, ticker, quantity):
        cost = StockMarket.ticker.price * quantity
        if cost <= self.accountName.currentBalance():
            BankAccount.self.accountName.balance -= cost
            self.portfolio[ticker] = quantity if ticker not in self.portfolio else self.portfolio[ticker] + quantity
            return "success"
        else:
            return "error"

    def sellStock(self, ticker, quantity):
        if self.portfolio[ticker] >= quantity:
            self.portfolio[ticker] -= quantity
            BankAccount.self.accountName.balance += StockMarket.ticker.price * quantity
            return "success"
        else:
            return "error"

    def checkTotalValue(self):
        total = 0
        for stock in self.portfolio:
            total += self.portfolio[stock] * StockMarket.stock.price
        return total
