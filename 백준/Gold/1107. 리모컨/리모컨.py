N = int(input())
M = int(input())
btn = []
if M:
    btn = list(input().split())

answerAbs = 1000001
answerNum = -1
for n in range(0, 1000001):
    continueFlag = False
    for b in btn:
        if b in str(n):
            continueFlag = True
    if continueFlag:
        continue
    if answerAbs > abs(N-n):
        answerAbs = abs(N-n)
        answerNum = n
ans = answerAbs+len(str(answerNum))
if ans > abs(100-N):
    ans = abs(100-N)
print(ans)