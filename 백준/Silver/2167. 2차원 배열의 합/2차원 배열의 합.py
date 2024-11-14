from itertools import accumulate
from operator import add
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
rowPrefixSum = [list(accumulate(list(map(int, input().split())))) for _ in range(N)]
prefixSum = []
for i in range(N):
    if i==0:
        prefixSum.append(rowPrefixSum[i])
        continue
    else:
        prefixSum.append(list(map(add, prefixSum[i-1], rowPrefixSum[i])))

T = int(input())
for _ in range(T):
    i,j,x,y = map(lambda n : n - 1, map(int, input().split()))
    answer = prefixSum[x][y]

    if i>0:
        answer -= prefixSum[i-1][y]
    if j>0:
        answer -= prefixSum[x][j-1]
    if i>0 and j>0:
        answer += prefixSum[i-1][j-1]
    print(answer)