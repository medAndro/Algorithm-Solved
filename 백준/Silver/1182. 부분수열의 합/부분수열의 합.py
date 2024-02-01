N, S = map(int, input().split())
nums = list(map(int, input().split()))

answer = 0
def dfs(idx, s):
    global  answer
    s += nums[idx]
    if s == S:
        answer+=1
    if idx+2 > N:
        return
    dfs(idx+1, s-nums[idx])
    dfs(idx+1, s)
    None

dfs(0, 0)
print(answer)