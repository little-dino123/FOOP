import random


class StockMarket:
    def __init__(self, name, symbol, price):
        self.name = name
        self.symbol = symbol
        self.price = price
        self.splits = 0

    def split(self):
        self.quantity *= 2
        self.price /= 2
        self.splits += 1

    def tick(self):
        self.price *= 1 + (random.random() - 0.5)
