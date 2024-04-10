N = int(input())
mapArr = [list(map(int, list(input()))) for _ in range(N)]
cnt = -1
danzi = []
dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]


def fillMap(y, x, cnt):
    mapArr[y][x] = 0
    danzi[cnt] += 1

    for i in range(4):
        yy = y + dy[i]
        xx = x + dx[i]
        if 0 <= yy < N and 0 <= xx < N:
            if mapArr[yy][xx] == 1:
                fillMap(yy, xx, cnt)


for y in range(N):
    for x in range(N):
        if mapArr[y][x] == 1:
            danzi.append(0)
            cnt += 1
            fillMap(y, x, cnt)

danzi.sort()
print(len(danzi))
print("\n".join(map(str, danzi)))
