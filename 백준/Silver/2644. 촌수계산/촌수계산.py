n = int(input())
f1, f2 = map(int, input().split())
m = int(input())

peopleMap = [[0] * 101 for _ in range(101)]

for _ in range(m):
    x, y = map(int, input().split())
    peopleMap[x][y] = 1
    peopleMap[y][x] = 1

visit = [0] * 101

def dfs(num, fnum, depth):
    visit[num] = 1
    nxt = peopleMap[num]
    if num == fnum:
        return depth
    minDepth = -1
    for i, n in enumerate(nxt):
        if n == 1 and visit[i] == 0:
            tempDepth = dfs(i, fnum, depth + 1)
            if tempDepth != -1:
                if minDepth == -1 or tempDepth < minDepth:
                    minDepth = tempDepth
    return minDepth

print(dfs(f1, f2, 0))
