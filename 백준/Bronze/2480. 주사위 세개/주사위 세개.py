dices = list(map(int, input().split()))
dices.sort()

if dices[0] == dices[1] == dices[2]:
    print(10000 + dices[0] * 1000)
elif dices[0] == dices[1] or dices[1] == dices[2]:
    print(1000 + dices[1] * 100)
else:
    print(dices[2] * 100)
