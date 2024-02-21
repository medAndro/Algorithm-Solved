from collections import deque

n, m = map(int, input().split())  # n행, m열
questionMap = [list(map(int, input().split())) for _ in range(n)]
answerMap = [[0] * m for _ in range(n)]

startX = 0
startY = 0
for y in range(n):
    isBreak = False
    for x in range(m):
        if questionMap[y][x] == 2:
            isBreak = True
            startY = y
            startX = x
            break
    if isBreak:
        break

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]

Q = deque([(startX, startY, 0)])
while len(Q) > 0:
    cur = Q.pop()
    x = cur[0]
    y = cur[1]
    cnt = cur[2]
    for i in range(4):
        xx = dx[i] + x
        yy = dy[i] + y
        if 0 <= xx < m and 0 <= yy < n:
            if questionMap[yy][xx] == 1:
                answerMap[yy][xx] = cnt + 1
                questionMap[yy][xx] = 0
                Q.appendleft((xx, yy, cnt + 1))

for y in range(n):
    for x in range(m):
        if questionMap[y][x] == 1 and answerMap[y][x] == 0:
            answerMap[y][x] = -1

for i in answerMap:
    print(' '.join(map(str, i)))
