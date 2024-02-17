n = int(input())
wines = [int(input()) for _ in range(n)]
dp = [0] * n
# case1 : n까지 마신 포도주 = n-1까지 마신 포도주
# case2 : n까지 마신 포도주 = n-2까지 마신 포도주 + 포도주n
# case3 : n까지 마신 포도주 = n-3까지 마신 포도주 + 포도주n-1 + 포도주n
# dp[n] = max(case1~3)
if n == 1 or n == 2:
    print(sum(wines))
else:
    dp[0] = wines[0]
    dp[1] = wines[0] + wines[1]
    for i in range(2, n):
        case1 = dp[i - 1]
        case2 = dp[i - 2] + wines[i]
        if i - 3 >= 0:
            case3 = dp[i - 3] + wines[i - 1] + wines[i]
        else:
            case3 = 0 + wines[i - 1] + wines[i]
        dp[i] = max(case1, case2, case3)
    print(max(dp))
