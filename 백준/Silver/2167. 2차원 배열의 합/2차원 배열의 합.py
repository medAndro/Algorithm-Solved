import sys
input = sys.stdin.readline

N, M = map(int, input().split())
numArray = [list(map(int, input().split())) for _ in range(N)]

K = int(input())
for _ in range(K):
    answer = 0
    i,j,x,y = map(lambda n: n-1, map(int, input().split()))

    for row in range(i, x+1):
        answer += sum(numArray[row][j:y+1])

    print(answer)