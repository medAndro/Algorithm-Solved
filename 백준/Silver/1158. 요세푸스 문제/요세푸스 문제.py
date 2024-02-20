N, K = map(int, input().split())
answer = []
arr = list(range(1,N+1))

idx = 0
cnt = 1
while len(answer) < N:
    if idx == N:
        idx = 0
    if arr[idx] != 0:
        if cnt > K:
            cnt = 1
        if cnt == K:
            answer.append(arr[idx])
            arr[idx] = 0
        cnt += 1
    idx+=1

print("<"+", ".join(map(str, answer))+">")
