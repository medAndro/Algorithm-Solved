N = int(input())
A = list(map(int,input().split()))
G = list(map(int,input().split()))
maxVal = -1000000001
minVal = 1000000001
Garr = [0]*G[0] + [1]*G[1] + [2]*G[2] + [3]*G[3]

import itertools as its
for I in list(its.permutations(Garr, len(A)-1)):
    calResult = A[0]
    for j in range(len(A)-1):
        if I[j] == 0:
            calResult += A[j + 1]
        elif I[j] == 1:
            calResult -= A[j + 1]
        elif I[j] == 2:
            calResult *= A[j + 1]
        elif I[j] == 3:
            calResult = int(calResult / A[j + 1])
    if calResult > maxVal:
        maxVal = calResult
    if calResult < minVal:
        minVal = calResult
print(maxVal)
print(minVal)