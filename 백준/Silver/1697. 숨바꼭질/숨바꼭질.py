from collections import deque

X, K = map(int, input().split())
Q = deque()
Q.append('0')
Q.append(X)
visited = [0]*100101
while True:
    cur = Q.pop()
    if type(cur) == str:
        Q.appendleft(str(int(cur) + 1))
        continue
    if cur == K:
        while True:
            ans = Q.pop()
            if type(ans) == str:
                print(ans)
                break
        break
    for i in [cur * 2, cur - 1, cur + 1]:
        if 0 <= i <= 100100:
            if visited[i] == 0:
                visited[i] = 1
                Q.appendleft(i)