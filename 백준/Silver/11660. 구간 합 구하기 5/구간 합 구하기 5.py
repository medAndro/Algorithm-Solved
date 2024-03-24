import sys
input = sys.stdin.readline
N, M = map(int, input().split())
arr = [[0] * (N + 1)] + [[0] + list(map(int, input().split())) for _ in range(N)]
sumArr = [[0] * (N + 1) for _ in range(N + 1)]

sx = 0
sy = 0
for i in range(1, N + 1):
    sx += arr[1][i]
    sy += arr[i][1]
    sumArr[1][i] = sx
    sumArr[i][1] = sy

for y in range(1, N + 1):
    for x in range(1, N + 1):
        if sumArr[y][x] == 0:
            sumArr[y][x] = sumArr[y - 1][x] + sumArr[y][x - 1] - sumArr[y - 1][x - 1] + arr[y][x]

for _ in range(M):
    x1, y1, x2, y2 = map(int, input().split())
    print(sumArr[x2][y2] - sumArr[x1 - 1][y2] - sumArr[x2][y1 - 1] + sumArr[x1 - 1][y1 - 1])
