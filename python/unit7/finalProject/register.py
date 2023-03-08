from bankAccount import BankAccount
from item import Item
import main


class Register:
    TAX = 1.095

    def __init__(self):
        self.cash = 1000
        self.earning = 0
        pass

    def getSubtotal(self, items):
        tax = self.TAX
        subtotal = 0
        for i in items:
            subtotal += i.getPrice()*items[i]*i.getTax()
        return subtotal

    def checkoutCash(self, items):
        total = self.getSubtotal(items, True)
        self.cash += total
        self.earning += total
        return True

    def checkoutCard(self, card, items):
        total = self.getSubtotal(items, True)
        cardbalance = card.currentBalance()
        if total <= cardbalance:
            self.earning += total
            return True
        else:
            return False
