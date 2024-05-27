import math

K = int(input())

for k in range(K):
    n = int(input())
    s = []
    girls = []
    cnt = 0
    answer = 0

    while n > cnt:
        inp = list(input().split())
        cnt += len(inp)
        for i in inp:
            if i == '0':
                continue
            else:
                if i in s:
                    girls[s.index(i)] += 1
                else:
                    s.append(i)
                    girls.append(1)

    for i in girls:
        if i >= 2:
            answer += math.comb(i, 2)

    print(f'Data Set {k + 1}:\n{answer}\n')

