ESM = list(map(int, input().split()))

earthYear = 1
junKyuYear = [0, 0, 0]
while True:
    junKyuYear[0] = 1 if junKyuYear[0] + 1 > 15 else junKyuYear[0] + 1
    junKyuYear[1] = 1 if junKyuYear[1] + 1 > 28 else junKyuYear[1] + 1
    junKyuYear[2] = 1 if junKyuYear[2] + 1 > 19 else junKyuYear[2] + 1

    if ESM == junKyuYear:
        break
    else:
        earthYear += 1

print(earthYear)
