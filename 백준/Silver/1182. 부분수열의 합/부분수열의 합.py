N, S = map(int, input().split())
arr = list(map(int, input().split()))
answer = 0
def dfs(idx, s):
    global answer
    if idx >= N:
        return
    s+= arr[idx]
    if s == S:
        answer+=1
    dfs(idx+1, s-arr[idx])
    dfs(idx+1, s)

dfs(0,0)
print(answer)