N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
tetris = [
    #파란색
    [[1, 1, 1, 1]],
    [[1],
     [1],
     [1],
     [1]],
    #노란색
    [[1, 1],
     [1, 1]],
    #주황색
    [[1, 0],
     [1, 0],
     [1, 1]],
    [[1, 1, 1],
     [1, 0, 0]],
    [[1, 1],
     [0, 1],
     [0, 1]],
    [[0, 0, 1],
     [1, 1, 1]],
    [[0, 1],
     [0, 1],
     [1, 1]],
    [[1, 0, 0],
     [1, 1, 1]],
    [[1, 1],
     [1, 0],
     [1, 0]],
    [[1, 1, 1],
     [0, 0, 1]],
    #초록색
    [[1, 0],
     [1, 1],
     [0, 1]],
    [[0, 1, 1],
     [1, 1, 0]],
    [[0, 1],
     [1, 1],
     [1, 0]],
    [[1, 1, 0],
     [0, 1, 1]],
    #핑크색
    [[1, 1, 1],
     [0, 1, 0]],
    [[0, 1],
     [1, 1],
     [0, 1]],
    [[0, 1, 0],
     [1, 1, 1]],
    [[1, 0],
     [1, 1],
     [1, 0]]
]
maxVal = 0

for i in range(N):#보드 가로줄수
    for j in range(M):#보드 세로줄수
        for t in tetris:
            th = len(t) #테트리스 가로줄수
            tv = len(t[0]) #테트리스 세로줄수
            currentMax = 0
            try:
                for l in range(th):
                    for m in range(tv):
                        currentMax += board[i+l][j+m]*t[l][m]
            except:
                continue
            maxVal = max([maxVal, currentMax])

print(maxVal)