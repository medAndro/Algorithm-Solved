N = int(input())
answer = 0
startIdx = 0
if len(str(N)) > 2:
   startIdx = N - (len(str(N))*9)

for i in range(startIdx, N):
    if (i + sum(map(int, list(str(i))))) == N:
        answer = i
        break
print(answer)