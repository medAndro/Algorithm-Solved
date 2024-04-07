import sys
sys.setrecursionlimit(10**7)

N = int(input())
region = [list(map(int, input().split())) for _ in range(N)]
answer = 1
dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]


def fillIsland(y, x):
    region[y][x] *= -1

    for d in range(4):
        yy = y + dy[d]
        xx = x + dx[d]
        if 0 <= yy < N and 0 <= xx < N:
            if region[yy][xx] > i:
                fillIsland(yy, xx)


for i in range(101):
    a = 0
    for y in range(N):
        for x in range(N):
            if region[y][x] > i:
                a += 1
                fillIsland(y, x)
    for y in range(N):
        for x in range(N):
            region[y][x] *= -1

    if a > answer:
        answer = a

print(answer)
