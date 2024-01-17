import sys
n = int(sys.stdin.readline())
dress = {}
answer = 1
for i in range(n):
    m = int(sys.stdin.readline())
    totalMulti = 1
    for j in range(m):
        _, dName = sys.stdin.readline().split()
        if dName in dress:
            dress[dName] += 1
        else:
            dress[dName] = 1
    for i in dress.values():
        answer *= (i+1)

    dress.clear()
    print(answer-1)
    answer=1