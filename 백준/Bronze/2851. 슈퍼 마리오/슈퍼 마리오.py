scores = []
scores.append(int(input()))
for _ in range(9):
    scores.append(scores[-1] + int(input()))
scores.reverse()
answer = -1
ansAbs = -1
for i in scores:
    if answer == -1 or ansAbs > abs(100 - i):
        ansAbs = abs(100 - i)
        answer = i

print(answer)