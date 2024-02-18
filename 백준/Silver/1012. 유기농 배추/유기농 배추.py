import sys
from collections import deque
T = int(input())
dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]
Q = deque()
field = [[0]*50 for _ in range(50)]
M = N = 0
def fillZero():
    global field
    while len(Q)>0:
        q = Q.pop()
        x = q[0]
        y = q[1]

        for i in range(4):
            xx = x+dx[i]
            yy = y+dy[i]
            if 0 <= xx < M and 0 <= yy < N:
                if field[yy][xx] == 1:
                    field[yy][xx] = 0
                    Q.appendleft((xx, yy))

for _ in range(T):
    M, N, K = map(int, input().split())
    for m in range(50):
        for n in range(50):
            field[n][m] = 0
    for _ in range(K):
        X, Y = map(int, sys.stdin.readline().strip().split())
        field[Y][X] = 1
    answer = 0
    for m in range(M):
        for n in range(N):
            if field[n][m] == 1:
                Q.append((m, n))
                field[n][m] = 0
                fillZero()
                answer+=1
    print(answer)