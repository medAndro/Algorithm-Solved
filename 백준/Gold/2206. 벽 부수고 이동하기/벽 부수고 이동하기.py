from collections import deque

N, M = map(int, input().split())
arr = [list(map(int,list(input()))) for _ in range(N)]

deq = deque()
deq.append((0, 0, 0))

dyArr = [-1, 1, 0, 0]  # 상 하 좌 우
dxArr = [0, 0, -1, 1]

visit = [[0] * M for _ in range(N)]
visit[0][0] = 1
visitB = [[0] * M for _ in range(N)]
while True:
    if len(deq) == 0: #더이상 이동이 불가한경우
        print(-1)
        break
    current = deque.pop(deq)
    y = current[0]
    x = current[1]
    isbrk = current[2] # 1이면 이전에 부순적이 있음 0이면 부순적이 없음
    if y + 1 == N and x + 1 == M:  #목적지에 도착한 경우
        if isbrk:
            print(visitB[y][x])
        else:
            print(visit[y][x])
        break
    for d in range(4):
        dy = y + dyArr[d]
        dx = x + dxArr[d]
        if dy >= 0 and dx >=0 and dy < N and dx < M:
            if arr[dy][dx] == 1: #다음칸이 벽
                if isbrk: #다음칸이 벽이면서 이전에 한번 깨본적이 있다.
                    None
                else: #다음칸이 벽이면서 이전에 한번도 깨본적이 없다.
                    if visitB[dy][dx] == 0: #"부쉈을때의 방문기록 배열"이 0일경우 부수며 이동
                        visitB[dy][dx] = visit[y][x]+1
                        deque.appendleft(deq, (dy, dx, 1))
            elif arr[dy][dx] == 0: #다음칸이 벽이 아님
                if isbrk: #다음칸이 벽이 아닌데 깨본적이 있다
                    if visitB[dy][dx] == 0:
                        visitB[dy][dx] = visitB[y][x]+1
                        deque.appendleft(deq, (dy, dx, 1))
                else: #다음칸이 벽이 아니면서 깨본적이 없다
                    if visit[dy][dx] == 0:
                        visit[dy][dx] = visit[y][x]+1
                        deque.appendleft(deq, (dy, dx, 0))