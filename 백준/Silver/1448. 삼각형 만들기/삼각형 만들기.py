import sys
from collections import deque
N = int(input())
straws = [int(sys.stdin.readline().strip()) for _ in range(N)]
straws.sort(reverse=True)
straws = deque(straws)
while len(straws) >= 3:
    if straws[0] < straws[1] + straws[2]:
        print(straws[0] + straws[1] + straws[2])
        break
    else:
        straws.popleft()
if len(straws) < 3:
    print(-1)