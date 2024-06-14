import sys
from collections import deque

M, N, H = map(int, input().split())

box = [[list(map(int, sys.stdin.readline().split())) for _ in range(N)] for _ in range(H)]

dm = [-1, 1, 0, 0, 0, 0]
dn = [0, 0, -1, 1, 0, 0]
dh = [0, 0, 0, 0, -1, 1]

rQue = deque()

answer = 0
for h in range(len(box)):
    for n in range(len(box[h])):
        for m in range(len(box[h][n])):
            if box[h][n][m] == 1:
                rQue.append((h, n, m, 1))

while len(rQue) > 0:
    p = rQue.popleft()
    for i in range(6):
        mm = dm[i] + p[2]
        nn = dn[i] + p[1]
        hh = dh[i] + p[0]
        if 0 <= mm < M and 0 <= nn < N and 0 <= hh < H:
            if box[hh][nn][mm] == 0:
                if answer < p[3]:
                    answer = p[3]
                box[hh][nn][mm] = p[3] + 1
                rQue.append((hh, nn, mm, p[3] + 1))

bp = False
for h in box:
    for n in h:
        for m in n:
            if m == 0:
                answer = -1
                bp = True
                break
        if bp:
            break
    if bp:
        break

print(answer)
