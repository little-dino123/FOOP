class Register:
    TAX = 1.095

    def __init__(self):
        self.cash = 1000
        self.earning = 0
        pass


@staticmethod
def getSubtotal(itemsQuantity, itemsToObjects):
    subtotal = 0
    for i in itemsQuantity:
        obj = itemsToObjects[i]
        subtotal += obj.getPriceWithTax() * itemsQuantity[i]
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
