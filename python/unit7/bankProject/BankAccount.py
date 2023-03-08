class BankAccount():
    def __init__(self, balance, name, number):
        self.interest = 0.5
        self.balance = balance
        self.name = name
        self.number = number

    def changeInterestRate(self, newRate):
        self.interest = newRate
        return "success"

    def deposit(self, cash):
        self.balance += cash
        return "success"

    def withdraw(self, cash):
        if cash <= self.balance:
            self.balance -= cash
            return "success"
        return "error"

    def currentBalance(self):
        return self.balance

