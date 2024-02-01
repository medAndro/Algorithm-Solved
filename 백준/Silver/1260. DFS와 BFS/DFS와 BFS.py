from collections import deque
N, M, V = map(int, input().split())
graph = [[0]*(N+1) for _ in range(N+1)]

for _ in range(M):
    a, b = map(int, input().split())
    graph[a][b] = graph[b][a] = 1

visited = [0]*(N+1)
def dfs(v):
    visited[v] = 1
    print(v, end=" ")
    for g in range(N+1):
        if visited[g] == 0 and graph[v][g]:
            dfs(g)
dfs(V)
print()
Q = deque([V])
visited = [0]*(N+1)
visited[V] = 1
def bfs():
    while Q:
        current = Q.pop()
        print(current, end=" ")
        for g in range(N+1):
            if visited[g] == 0 and graph[current][g]:
                visited[g] = 1
                Q.appendleft(g)
bfs()