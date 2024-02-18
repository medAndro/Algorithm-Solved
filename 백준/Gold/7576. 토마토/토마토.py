from collections import deque
M, N = map(int, input().split())
tomato = [list(map(int, input().split())) for _ in range(N)]
tomatoDP = [[0] * M for _ in range(N)]

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]
Q = deque()
def ripen(y, x):
    tomatoDP[y][x] = 1
    for i in range(4):
        yy = y + dy[i]
        xx = x + dx[i]
        if 0 <= xx < M and 0 <= yy < N:
            if tomato[yy][xx] == 0:
                tomato[yy][xx] = 1
                Q.appendleft((yy,xx))

answer = -1
for n in range(N):
    for m in range(M):
        if tomato[n][m] == 1 and tomatoDP[n][m] == 0:
            Q.appendleft((n, m))
if len(Q) > 0:
    answer += 1
    Q.appendleft(answer)

while len(Q) > 1:
    q = Q.pop()
    if type(q) != int:
        ripen(q[0], q[1])
    else:
        answer = q+1
        Q.appendleft(answer)

allRipen = True
for n in range(N):
    for m in range(M):
        if tomato[n][m] == 0:
            allRipen = False
            break

if allRipen:
    print(answer)
else:
    print(-1)
