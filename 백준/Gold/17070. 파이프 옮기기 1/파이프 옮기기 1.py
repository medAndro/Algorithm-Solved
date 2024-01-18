N = int(input())
house = [list(map(int, input().split())) for _ in range(N)]
answer = 0
def checkNext(house, x1, y1, x2, y2, N):
    global answer
    if x1 == x2 and y1 != y2:
        # 가로일때 이동
        if y2+1 <=N and house[x2][y2+1] == 0: # 가로 이동 case1
            if x2 == y2+1 == N:
                answer += 1
            else:
                checkNext(house, x2, y2, x2, y2+1, N)
        if y2+1 <=N and x2+1 <= N and house[x2][y2+1] == 0 and house[x2+1][y2+1]==0 and house[x2+1][y2]==0: # 가로 이동 case2
            if x2+1 == y2+1 == N:
                answer += 1
            else:
                checkNext(house, x2, y2, x2+1, y2+1, N)
    elif x1 != x2 and y1 == y2:
        # 세로일때 이동
        if x2+1<=N and house[x2+1][y2] == 0: # 세로 이동 case1
            if x2+1 == y2 == N:
                answer += 1
            else:
                checkNext(house, x2, y2, x2+1, y2, N)
        if y2+1 <=N and x2+1 <= N and house[x2][y2+1] == 0 and house[x2+1][y2+1]==0 and house[x2+1][y2]==0: # 세로 이동 case2
            if x2+1 == y2+1 == N:
                answer += 1
            else:
                checkNext(house, x2, y2, x2+1, y2+1, N)
    elif x1 != x2 and y1 != y2:
        # 대각선일때 이동
        if y2 + 1 <= N and house[x2][y2 + 1] == 0:  # 대각선 이동 case1
            if x2 == y2 + 1 == N:
                answer += 1
            else:
                checkNext(house, x2, y2, x2, y2 + 1, N)
        if x2+1<=N and house[x2+1][y2] == 0: # 대각선 이동 case2
            if x2+1 == y2 == N:
                answer += 1
            else:
                checkNext(house, x2, y2, x2+1, y2, N)
        if y2+1 <=N and x2+1 <= N and house[x2][y2+1] == 0 and house[x2+1][y2+1]==0 and house[x2+1][y2]==0: # 대각선 이동 case3
            if x2+1 == y2+1 == N:
                answer += 1
            else:
                checkNext(house, x2, y2, x2+1, y2+1, N)


if house[N-1][N-1]:
    print(0)
else:
    checkNext(house, 0, 0, 0, 1, N - 1)
    print(answer)