import sys

N, H = map(int, input().split())
down = [0]* (N//2) #종류석
up = [0]* (N//2) #석순

u = 0
d = 0
for i in range(N):
    if i%2==0:
        up[u] = int(sys.stdin.readline())
        u += 1
    else:
        down[d] = int(sys.stdin.readline())
        d += 1

down.sort()
up.sort()


breakN = [0]*(H+1)
breakN[0] = 1000000

def checkUp(n, i):
    if n == len(up):
        return False
    if n == -1:
        return True
    if up[n] >= i:
        return False
    else:
        return True

def findBreakNumUp(i):
    low = -1
    high = len(up)
    while low + 1 < high:
        mid = (low+high)//2

        if checkUp(low, i) == checkUp(mid, i):
            low = mid
        if checkUp(high, i) == checkUp(mid, i):
            high = mid
    return high


def checkDown(n, i):
    if n == len(up):
        return True #막히면 True
    if n == -1:
        return False
    if H-down[n] >= i:
        return False
    else:
        return True

def findBreakNumDown(i):
    low = -1
    high = len(up)
    while low + 1 < high:
        mid = (low+high)//2
        if checkDown(low, i) == checkDown(mid, i):
            low = mid
        if checkDown(high, i) == checkDown(mid, i):
            high = mid
    return high

answer = -1
answerCnt = 1
for i in range(1, H+1):
    currentBreak = ((N//2)-findBreakNumUp(i))+((N//2)-findBreakNumDown(i))
    if i == 1 or answer > currentBreak:
        answer = currentBreak
        answerCnt = 1
    elif answer == currentBreak:
        answerCnt += 1

print(answer, answerCnt)