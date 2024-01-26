from collections import deque
N, M = map(int, input().split())
maze = [[0],]
for _ in range(N):
    maze.append(list(map(int, list("0"+input()))))
Q = deque([(1, 1)])

while True:
    cur = Q.pop()
    y = cur[0]
    x = cur[1]
    curVal = maze[y][x]
    if y==1 and x==1:
        maze[1][1] = -1
    if y == N and x == M:
        print(curVal)
        break
    #상
    if y-1 > 0 and maze[y-1][x] == 1:
        deque.appendleft(Q,(y-1,x))
        maze[y - 1][x] = curVal+1
    #하
    if y+1 <= N and maze[y+1][x] == 1:
        deque.appendleft(Q,(y+1,x))
        maze[y + 1][x] = curVal + 1
    #좌
    if x-1 > 0 and maze[y][x-1] == 1:
        deque.appendleft(Q, (y, x-1))
        maze[y][x - 1] = curVal + 1
    #우
    if x+1 <= M and maze[y][x+1] == 1:
        deque.appendleft(Q, (y, x+1))
        maze[y][x + 1] = curVal + 1