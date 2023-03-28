import bankAccount, cart, inventory, item, register, cartTest
myAccount = bankAccount.BankAccount(10000000, "david", 123456789)
myCart = cart.Cart("my cart")
myCart2 = cartTest.CartTest("my cart 2")
CVS = inventory.Inventory("CVS")
CVSReg1 = register.Register(500)
oreo = item.Item("oreo classic", "Oreo", 4.99, CVS)
cheetos = item.Item("hot cheetos", "Lays", 3.99, CVS)
CVS.addItemQuantity("oreo classic", 5)
CVS.addItemQuantity("hot cheetos", 50)


