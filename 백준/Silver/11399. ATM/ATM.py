N = int(input())
P = list(map(int, input().split()))
P.sort()
waitTime = 0
answer = 0
for i in range(N):
    answer += (P[i] + waitTime)
    waitTime += P[i]
print(answer)
