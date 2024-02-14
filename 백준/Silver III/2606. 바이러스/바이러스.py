import sys
from collections import deque
input = lambda: sys.stdin.readline().rstrip()
computerNum = int(input())
networkNum = int(input())
networks = {}
for _ in range(networkNum):
    a, b = map(int, input().split())
    try:
        networks[a] += [b]
    except:
        networks[a] = [b]
    try:
        networks[b] += [a]
    except:
        networks[b] = [a]

visited = [0]*(computerNum+1)
Q = deque([1])
visited[1] = 1
while len(Q) > 0 and computerNum > 1:
    cur = Q.pop()
    for n in networks[cur]:
        if visited[n] == 0:
            Q.appendleft(n)
            visited[n] = 1
print(sum(visited)-1)