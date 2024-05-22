cityLen = list(map(int, input().split()))

for i in range(5):
    lens = []
    for j in range(5):
        if i < j:
            lens.append(sum(cityLen[i:j]))
        elif i == j:
            lens.append(0)
        else:
            lens.append(sum(cityLen[j:i]))
    print(' '.join(map(str, lens)))
