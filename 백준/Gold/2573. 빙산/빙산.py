import sys
limit_number = 15000
sys.setrecursionlimit(limit_number)


N, M = map(int, input().split())
iceArr = list(list(map(int, input().split())) for _ in range(N))
iceIdxArr = list([-1]*M for _ in range(N))
reduceAmountArr = list([0]*M for _ in range(N))


dy = [-1,1,0,0]
dx = [0,0,-1,1]


def fillCountArr(i, j, iceIdx):
    iceIdxArr[i][j] = iceIdx
    reduceAmount = 0
    for d in range(4):
        newI = i + dy[d]
        newJ = j + dx[d]
        if 0 <= newI < N and 0 <= newJ < M:
            if iceArr[newI][newJ] == 0:
                reduceAmount += 1
            if iceArr[newI][newJ] > 0 and iceIdxArr[newI][newJ] == -1:
                fillCountArr(newI, newJ, iceIdx)
    reduceAmountArr[i][j] = reduceAmount

iceIdx = 0
for i in range(N):
    for j in range(M):
        if iceArr[i][j] > 0 and iceIdxArr[i][j] == -1:
            iceIdx = iceIdx + 1
            fillCountArr(i, j, iceIdx)
        elif iceArr[i][j] == 0:
            iceIdxArr[i][j] = 0



def fillIdxArr(i, j, arr):
    arr[i][j] = 0
    for d in range(4):
        newI = i + dy[d]
        newJ = j + dx[d]
        if 0 <= newI < N and 0 <= newJ < M:
            if arr[newI][newJ] == 1:
                fillIdxArr(newI, newJ, arr)

def isOverTwoIce():
    import copy
    idxCheckArr = copy.deepcopy(iceIdxArr)

    fillCounter = 0
    for i in range(N):
        for j in range(M):
            if idxCheckArr[i][j] == 1:
                fillCounter += 1
                fillIdxArr(i, j, idxCheckArr)

    return fillCounter



if iceIdx > 1:
    print(0)
else:
    answer = 0
    while True:
        answer += 1
        clearIces = []
        for i in range(N):
            for j in range(M):
                if reduceAmountArr[i][j] > 0:
                    if iceArr[i][j] > 0:
                        iceArr[i][j] -= reduceAmountArr[i][j]
                        if iceArr[i][j] <= 0:
                            iceArr[i][j] = 0
                            iceIdxArr[i][j] = 0
                            clearIces.append([i, j])
        for clearIce in clearIces:
            reduceAmountArr[clearIce[0]][clearIce[1]] = 0
            for d in range(4):
                newI = clearIce[0] + dy[d]
                newJ = clearIce[1] + dx[d]
                if 0 <= newI < N and 0 <= newJ < M:
                    if iceArr[newI][newJ] > 0:
                        reduceAmountArr[newI][newJ] += 1
        iceCount = isOverTwoIce()
        if iceCount == 0:
            print(0)
            break
        elif iceCount >= 2:
            print(answer)
            break

