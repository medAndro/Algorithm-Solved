from collections import deque

N, K = map(int, input().split())
T = deque(sorted(list(map(int, input().split()))))

answer = 0
prev = 0
for i in range(K):
    if i == 0:
        answer += T.pop()
    else:
        if i % 2 != 0:
            prev = T.popleft()
        else:
            answer += T.pop() - prev

print(answer)
