import sys
from collections import deque

N = int(sys.stdin.readline())
board = [[0]*N for _ in range(N)]
K = int(sys.stdin.readline())
for i in range(K):
    x, y = map(int, sys.stdin.readline().split())
    x -= 1
    y -= 1
    board[x][y] = 1
L = int(sys.stdin.readline())
time = 0
path = 0
snake = deque()
snake.append([0,0])
board[0][0] = 2
##for k in board:
##    print(k)

rotate = {}
for i in range(L):
    x, y = sys.stdin.readline().split()
    x = int(x)
    rotate[x]=y

exitFlag = False
while True:
    time += 1
    head = snake[-1]
    if path == 0: ## 오른쪽으로 이동
        if head[0]+1 < N and board[head[1]][head[0]+1] != 2: ##머리가 벽이나 몸에 닿지 않았을때
            if board[head[1]][head[0]+1] == 1: ##사과가 머리에 닿았을때
                snake.append([head[0]+1, head[1]])
                board[head[1]][head[0]+1] = 2
            else: ##사과가 머리에 닿지않을때
                snake.append([head[0]+1, head[1]])
                board[head[1]][head[0]+1] = 2
                tail = snake.popleft()
                board[tail[1]][tail[0]] = 0
        else:
            exitFlag = True
            break
    elif path == 1: ## 아래쪽으로 이동
        if head[1]+1 < N and board[head[1]+1][head[0]] != 2: ##머리가 벽이나 몸에 닿지 않았을때
            if board[head[1]+1][head[0]] == 1: ##사과가 머리에 닿았을때
                snake.append([head[0], head[1]+1])
                board[head[1]+1][head[0]] = 2
            else: ##사과가 머리에 닿지않을때
                snake.append([head[0], head[1]+1])
                board[head[1]+1][head[0]] = 2
                tail = snake.popleft()
                board[tail[1]][tail[0]] = 0
        else:
            exitFlag = True
            break
    elif path == 2: ## 왼쪽으로 이동
        if head[0]-1 >= 0 and board[head[1]][head[0]-1] != 2: ##머리가 벽이나 몸에 닿지 않았을때
            if board[head[1]][head[0]-1] == 1: ##사과가 머리에 닿았을때
                snake.append([head[0]-1, head[1]])
                board[head[1]][head[0]-1] = 2
            else: ##사과가 머리에 닿지않을때
                snake.append([head[0]-1, head[1]])
                board[head[1]][head[0]-1] = 2
                tail = snake.popleft()
                board[tail[1]][tail[0]] = 0
        else:
            exitFlag = True
            break
    elif path == 3: ## 위쪽으로 이동
        if head[1]-1 >= 0 and board[head[1]-1][head[0]] != 2: ##머리가 벽이나 몸에 닿지 않았을때
            if board[head[1]-1][head[0]] == 1: ##사과가 머리에 닿았을때
                snake.append([head[0], head[1]-1])
                board[head[1]-1][head[0]] = 2
            else: ##사과가 머리에 닿지않을때
                snake.append([head[0], head[1]-1])
                board[head[1]-1][head[0]] = 2
                tail = snake.popleft()
                board[tail[1]][tail[0]] = 0
        else:
            exitFlag = True
            break

  ##for k in board:
  ##    print(k)
  ##print(time)
    if time in rotate:
        if rotate.get(time)=='L':
            path-=1
        elif rotate.get(time)=='D':
            path+=1
        path %=4
    if exitFlag:
        break
        
print(time)