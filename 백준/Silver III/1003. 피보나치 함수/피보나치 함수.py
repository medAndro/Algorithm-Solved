import sys
resultDict = dict(zip(list(range(41)), [[0, 0] for _ in range(41)]))
def fibonacci(n, N):
    if n == 0:
        resultDict[N][0] += 1
        return
    elif n == 1:
        resultDict[N][1] += 1
        return
    else:
        fibonacci(n - 1, N)
        fibonacci(n - 2, N)

fibonacci(0, 0)
fibonacci(1, 1)

def fibonacciFast(n):
    resultDict[n][0] += resultDict[n - 1][0]
    resultDict[n][1] += resultDict[n - 1][1]
    resultDict[n][0] += resultDict[n - 2][0]
    resultDict[n][1] += resultDict[n - 2][1]

for i in range(2, 41):
    fibonacciFast(i)

for _ in range(int(sys.stdin.readline())):
    print(' '.join(map(str,resultDict[int(sys.stdin.readline())])))
