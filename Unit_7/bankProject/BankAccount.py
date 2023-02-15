class BankAccount():
    def __init__(self, balance, name, number):
        self.interest = 0.5
        self.balance = balance
        self.name = name
        self.number = number

    def changeInterestRate(self, newRate):
        self.interest = newRate
        return self.name + ", your new interest rate is %" + str(self.interest)

    def deposit(self, cash):
        self.balance += cash
        return self.name + ", You have deposited $" + str(cash) + ", and your new balance is $" + str(self.balance)

    def withdraw(self, cash):
        if cash <= self.balance:
            self.balance -= cash
            return self.name + ", you have witdrawn $" + str(cash) + ", and your new balance is $" + str(self.balance)
        return self.name + ", your account balance is too low($" + str(
            self.balance) + "), you cannot make this withdrawal($" + str(cash) + ")"

    def currentBalance(self):
        return self.balance

    # def addInterestRate(self,interest):
    #   interest=interest/100
    #   self.balance=self.balance*(1+interest)
    #   return "you have earned $"+str(self.balance*interest)+" from interest, and your new balance is $" + str(self.balance)

