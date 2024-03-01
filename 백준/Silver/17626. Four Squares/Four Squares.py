N = int(input())
answer = 5
dp = [4]*50001
ones = []
twos = []
idx = 0
while True:
    idx+=1
    if 50000 >= idx**2:
        dp[idx**2] = 1
        ones.append(idx**2)
    else:
        break
idx = 0
for o1 in ones:
    for o2 in ones:
        if 50000 >= o1+o2 and dp[o1+o2] == 4:
            dp[o1 + o2] = 2
            twos.append(o1 + o2)
idx = 0
for o in ones:
    for t in twos:
        if 50000 >= o+t and dp[o+t] == 4:
            dp[o+t] = 3
print(dp[N])