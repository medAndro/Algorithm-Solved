X = int(input())

sumVal = 0
cnt = 0  # 짝수면 ↙
while True:
    cnt += 1
    sumVal += cnt
    if sumVal >= X:
        sumVal -= cnt
        t = X - sumVal
        if cnt % 2 == 0:
            print(f'{X - sumVal}/{cnt - (X - sumVal) + 1}')
        else:
            print(f'{cnt - (X - sumVal) + 1}/{X - sumVal}')
        break
