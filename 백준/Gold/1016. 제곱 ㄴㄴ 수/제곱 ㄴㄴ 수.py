min, max = map(int, input().split())
powYY = set()
for i in range(2, 1000000):
    start = min // (i**2)
    while True:
        curnum = (i**2) * start
        if curnum >= min and curnum <= max:
            powYY.add(curnum)

        elif curnum > max:
            break
        start+=1
print((max-min) - len(powYY) +1)