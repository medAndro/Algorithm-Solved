n = int(input())
nums = list(map(int, input().split()))
dp = [0 for _ in range(n)]
dp[n-1] = 1
if n > 1:
    for i in range(n-2,-1,-1):
        maxDp = 0
        for j in range(i+1, n):
            if nums[i] < nums[j]:
                if maxDp < dp[j]:
                    maxDp = dp[j]
        dp[i] = maxDp+1
print(max(dp))