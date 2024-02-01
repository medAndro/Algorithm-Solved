from collections import deque
N, M, V = map(int, input().split())
graph = {}
for _ in range(M):
    a, b = map(int, input().split())
    if a in graph:
        if b not in graph[a]:
            graph[a] += [b]
    else:
        graph[a] = [b]
    if b in graph:
        if a not in graph[b]:
            graph[b] += [a]
    else:
        graph[b] = [a]
#print(graph)
N = len(graph)

bfsNodes = [V]
bfsQ = deque([(V, graph.get(V))])
def bfs():
    global bfsNodes
    while len(bfsNodes) < N:
        #print(bfsQ)
        #print(bfsNodes)
        try:
            current = bfsQ.pop()
        except:
            break

        if current[1]:
            nNode = list(sorted(current[1]))
            for i in nNode:
                if i not in bfsNodes:
                    bfsNodes.append(i)
                    deque.appendleft(bfsQ, (i, graph.get(i)))

bfs()

dfsNodes = []
def dfs(node):
    global dfsNodes
    dfsNodes.append(node)
    try:
        nNode = list(sorted(graph.get(node)))
        if len(nNode):
            for i in nNode:
                if i not in dfsNodes:
                    #print(i)
                    dfs(i)
    except:
        None
dfs(V)

print(" ".join(map(str,dfsNodes)))
print(" ".join(map(str,bfsNodes)))

