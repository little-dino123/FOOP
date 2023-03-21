def run(num):
    i = 0
    while num != 1:
        if num % 2 == 0:
            num = num / 2
        elif num % 2 == 1:
            num = 3 * num + 1
        i += 1
    return i


def main(x):
    for var in range(2, x + 1):
        print(var)
        print("# of iterations:", run(var))


def inf():
    var = 2
    while True:
        print(run(var))

        var += 1


main(100)
# inf()
