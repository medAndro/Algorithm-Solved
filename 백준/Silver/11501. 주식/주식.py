T = int(input())

for _ in range(T):
    remainStock = [0] * 10001
    N = int(input())
    li = list(map(int, input().split()))
    for i in li:
        remainStock[i] += 1
    sell = -1
    earn = 0
    for i in li:
        if sell == i:
            sell = -1
        elif sell == -1:
            for r in range(10000, i, -1):
                if remainStock[r] > 0:
                    sell = r
                    earn += sell - i
                    break
        else:
            earn += sell - i
        remainStock[i] -= 1
    print(earn)
