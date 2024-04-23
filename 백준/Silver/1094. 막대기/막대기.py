X = int(input())

sticks = [64]

while sum(sticks) > X:
    minStick = min(sticks)
    sticks.remove(minStick)

    if (sum(sticks) + minStick // 2) >= X:
        sticks.append(minStick // 2)
    else:
        sticks.append(minStick // 2)
        sticks.append(minStick // 2)

print(len(sticks))
