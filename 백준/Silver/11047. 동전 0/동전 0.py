N, K = map(int, input().split())
coins = []
for _ in range(N):
    coin = int(input())
    if coin > K:
        break
    else:
        coins.append(coin)
N = len(coins)
coins.sort(reverse=True)
answer = []

for c in range(N):
    quotient = K // coins[c]
    remainder = K % coins[c]

    if remainder == 0:
        answer.append(quotient)
        break
    else:
        for q in range(quotient, -1, -1):
            curReminder = K - (q*coins[c])
            isDivisionAble = False
            if c+1 < N:
                for cc in coins[c+1:]:
                    if curReminder % cc == 0:
                        isDivisionAble = True
                        answer.append(q)
                        K -= q*coins[c]
                        break
            if isDivisionAble:
                break
print(sum(answer))