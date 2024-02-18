n = int(input())
dp = [0] * 12
dp[1] = 1  # 1
dp[2] = 2  # 1+1, 2
dp[3] = 4  # 1+1+1, 1+2, 2+1, 3
for i in range(4, 12):
    dp[i] = sum(dp[i - 3:i])
for _ in range(n):
    print(dp[int(input())])
