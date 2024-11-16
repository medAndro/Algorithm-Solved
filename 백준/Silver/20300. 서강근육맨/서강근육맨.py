from collections import deque

N = int(input())
M = list(map(int, input().split()))
M.sort()
M = deque(M)

maxM = 0
if len(M) % 2 != 0:
    maxM = M.pop()

while len(M) > 0:
    m = M.popleft() + M.pop()
    if m > maxM:
        maxM = m

print(maxM)