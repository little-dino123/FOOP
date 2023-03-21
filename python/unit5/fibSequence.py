x = 1
y = 1
print(x)
print(y)
for i in range(1, 100):
    (x, y) = (y, x + y)
    print(y)
