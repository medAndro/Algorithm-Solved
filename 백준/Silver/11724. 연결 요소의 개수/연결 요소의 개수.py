from collections import defaultdict
N, M = map(int, input().split())
graph = defaultdict(list)

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(1, N+1):
    graph[i].append(i)

def chkConnect(i):
    element = graph[i]
    del graph[i]
    for j in element:
        chkConnect(j)

answer = 0
while len(graph)>0:
    chkConnect(list(graph.keys())[0])
    answer += 1

print(answer)