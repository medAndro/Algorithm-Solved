import sys
sys.setrecursionlimit(100000)

dy = [-1, 1, 0, 0, -1, -1, 1, 1]
dx = [0, 0, -1, 1, -1, 1, -1, 1]

def fill(y, x):
    mapList[y][x] = 0
    for a in range(8):
        yy = y + dy[a]
        xx = x + dx[a]
        if 0 <= yy < h and 0 <= xx < w:
            if mapList[yy][xx] == 1:
                fill(yy, xx)

while True:
    w, h = map(int, input().split())
    if w + h == 0:
        break
    mapList = [list(map(int, input().split())) for _ in range(h)]
    answer = 0
    for i in range(h):
        for j in range(w):
            if mapList[i][j] == 1:
                fill(i, j)
                answer += 1
    print(answer)
