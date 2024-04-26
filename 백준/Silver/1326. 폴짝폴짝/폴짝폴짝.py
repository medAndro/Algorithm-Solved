N = int(input())

bridge = list(map(int, input().split()))
dp = [-1 for _ in range(N)]
a, b = map(int, input().split())

dp[a - 1] = 0

cnt = -1
while True:
    cnt += 1
    if dp.count(cnt) == 0 or dp[b - 1] != -1:
        break
    for j in range(N):
        if dp[j] == cnt and bridge[j] > 0:
            m = bridge[j]
            for i in range(1, 10001):
                if j + (m * i) >= N:
                    break
                elif dp[j + (m * i)] == -1:
                    dp[j + (m * i)] = cnt + 1
            for i in range(1, 10001):
                if j - (m * i) < 0:
                    break
                elif dp[j - (m * i)] == -1:
                    dp[j - (m * i)] = cnt + 1

print(dp[b - 1])
