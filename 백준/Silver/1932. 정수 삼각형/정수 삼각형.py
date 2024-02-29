n = int(input())
tri = [list(map(int,input().split())) for _ in range(n)]
answer = [[0]*(x+1) for x in range(n)]
idx = 0
answer[0][0] = tri[0][0]
while idx < n-1:
    up = answer[idx]
    down = tri[idx+1]
    ans = answer[idx+1]
    for i, u in enumerate(up):
        if u+down[i] > ans[i]:
            ans[i] = u+down[i]
        if u+down[i+1]:
            ans[i+1] = u+down[i+1]
    down = ans
    idx+=1
print(max(answer[-1]))