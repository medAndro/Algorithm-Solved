# 올해도 JOI 마을의 치즈 공장이 치즈 생산을 시작하면서 쥐구멍에서 쥐가 끓기 시작했다.
# JOI 마을은 동서남북으로 구획되어 있고, 각 구획은 쥐구멍, 치즈 공장, 장애물, 공터 중 하나이다.
# 쥐는 쥐구멍에서 출발하여 모든 치즈 공장을 방문하여 치즈를 하나씩 먹는다.

# 이 마을에는 N개의 치즈 공장이 있으며, 각 공장은 서로 다른 경도의 치즈만 생산하고 있다.
# 경도 1부터 N까지의 치즈를 생산하는 치즈 공장이 각각 1개씩 있다.

# 쥐의 초기 체력은 1이며, 치즈를 1개 먹을 때마다 체력이 1씩 증가한다.
# 단, 쥐는 자신의 체력보다 딱딱한 치즈를 먹을 수 없다.

# 쥐는 동서남북으로 인접한 구획으로 1분 안에 이동할 수 있지만, 장애물이 있는 구획에는 들어갈 수 없다.
# 치즈 공장을 치즈를 먹지 않고 지나갈 수도 있다.
# 모든 치즈를 다 먹기까지 걸리는 최단 시간을 구하는 프로그램을 작성하시오. (단, 쥐가 치즈를 먹는 데 걸리는 시간은 무시할 수 있다.)

# 입력은 H+1행이 있다.
# 첫 번째 줄에는 3개의 정수 H，W，N (1 ≦ HW ≦ 1000，1 ≦ N ≦ 9) 가 이 순서대로 공백으로 구분되어 쓰여져 있다.
# 2행부터 H+1행까지의 각 행마다 'S', '1~9', 'X', '.'로 이루어진 W개의 문자열이 쓰여져 있다

# S: 쥐구멍
# N: 치즈공장과 경도값 (1~9숫자)
# X: 장애물
# .: 공터

# 입력에는 쥐구멍과 경도 1~N의 치즈를 생산하는 공장이 각각 1개씩 있다.
# 다른 칸은 장애물이나 빈 공간으로 보장되어 있다. 쥐는 모든 치즈를 먹을 수 있도록 보장되어 있다.

# 모든 치즈를 다 먹기까지 걸리는 최단 시간(분)을 나타내는 정수를 한 줄에 출력하시오.

from collections import deque
H, W, N = map(int, input().split()) #행의 수, 열의 수, 치즈공장의 수
town = [list(input()) for _ in range(H)]
mY = 0 # 초기 쥐구멍 y
mX = 0 # 초기 쥐구멍 x
for y in range(H): # 초기 쥐구멍 위치 찾기
    breakFlag = False
    for x in range(W):
        if town[y][x] == 'S':
            mY = y
            mX = x
            break
    if breakFlag: break

minPaths = [] # 각 치즈공장까지의 최소 이동수를 저장
currentCheese = 1 # 현재 목표인 치즈공장

while currentCheese <= N:
    ctown = [['.']*W for _ in range(H)]
    Q = deque([(mY, mX)])
    ctown[mY][mX] = 0
    while True:
        pos = Q.pop()
        y = pos[0]
        x = pos[1]
        if town[y][x] == str(currentCheese):
            minPaths.append(ctown[y][x])
            mY = y
            mX = x
            currentCheese += 1
            break
        # 위로 이동
        if y-1 >= 0 and town[y-1][x] != 'X' and type(ctown[y-1][x]) != type(1):
            ctown[y-1][x] = ctown[y][x]+1
            deque.appendleft(Q, (y-1,x))
        # 아래로 이동
        if y+1 < H and town[y+1][x] != 'X' and type(ctown[y+1][x]) != type(1):
            ctown[y+1][x] = ctown[y][x]+1
            deque.appendleft(Q, (y+1,x))
        # 좌로 이동
        if x-1 >= 0 and town[y][x-1] != 'X' and type(ctown[y][x-1]) != type(1):
            ctown[y][x-1] = ctown[y][x]+1
            deque.appendleft(Q, (y,x-1))
        # 우로 이동
        if x+1 < W and town[y][x+1] != 'X' and type(ctown[y][x+1]) != type(1):
            ctown[y][x+1] = ctown[y][x]+1
            deque.appendleft(Q, (y,x+1))

print(sum(minPaths))