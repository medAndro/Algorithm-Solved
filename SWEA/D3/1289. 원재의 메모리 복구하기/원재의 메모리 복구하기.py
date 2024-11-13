T = int(input())

for i in range(T):
    originMemory = list(map(int, input()))
    answer = 0

    fillBit = 0
    for index, bit in enumerate(originMemory):
        if fillBit == bit:
            continue
        else:
            fillBit = 1 if fillBit==0 else 0
            answer += 1

    print(f"#{i+1} {answer}")