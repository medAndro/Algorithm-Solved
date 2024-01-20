chessA = []
chessB = []
for _ in range(4):
    chessA += [list('BWBWBWBW'), list('WBWBWBWB')]
    chessB += [list('WBWBWBWB'), list('BWBWBWBW')]
n, m = map(int, input().split())
qArr = [list(input()) for _ in range(n)]
minPaint = 50*50
for i in range(0, n-7):
    for j in range(0, m-7):
        minA = minB = 0
        for ii in range(8):
            for jj in range(8):
                if chessA[ii][jj] != qArr[i+ii][j+jj]:
                    minA += 1
                if chessB[ii][jj] != qArr[i+ii][j+jj]:
                    minB += 1
        minPaint = min([minPaint, minA, minB])
print(minPaint)
