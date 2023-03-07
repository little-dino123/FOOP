class BankAccount:
    def __init__(self, balance, name, number):
        self.interest = 0.5
        self.balance = balance
        self.name = name
        self.number = number

    def changeInterestRate(self, newRate):
        self.interest = newRate
        return False

    def deposit(self, cash):
        self.balance += cash
        return True

    def withdraw(self, cash):
        if cash <= self.balance:
            self.balance -= cash
            return True
        return False

    def currentBalance(self):
        return self.balance

    def pay(self, charge):
        if charge < self.balance:
            self.balance -= charge
            return True
        return False
