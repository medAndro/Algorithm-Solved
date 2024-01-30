from collections import deque
import itertools as its
import copy
N, M = map(int, input().split())
arr = [list(map(int,input().split())) for _ in range(N)]

zeros = []
ones = []
twos = []

for i in range(N):
    for j in range(M):
        if arr[i][j] == 1:
            ones.append((i,j))
        elif arr[i][j] == 2:
            twos.append((i,j))
        elif arr[i][j] == 0:
            zeros.append((i,j))

combi = list(its.combinations(zeros,3))

dyarr = [-1, 1, 0, 0]
dxarr = [0, 0, -1, 1]
def checkVrius(three):
    visit = copy.deepcopy(arr)
    for i in three:
        visit[i[0]][i[1]] = 1

    q = deque(twos)
    while len(q):
        current = q.pop()
        y = current[0]
        x = current[1]
        for d in range(4):
            dy = y+dyarr[d]
            dx = x+dxarr[d]
            if dy>=0 and dy < N and dx >= 0 and dx < M:
                if visit[dy][dx] == 0:
                    visit[dy][dx] = 2
                    q.appendleft((dy,dx))
    total = 0
    for i in range(N):
        total += visit[i].count(0)
    return total

maxSafe = 0
for c in combi:
    num = checkVrius(c)
    if maxSafe < num:
        maxSafe = num
print(maxSafe)