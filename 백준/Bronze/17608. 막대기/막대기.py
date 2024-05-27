import sys

sticks = [int(sys.stdin.readline()) for _ in range(int(input()))]
sticks.reverse()

answerList = [sticks[0]]

for s in sticks:
    if s > answerList[-1]:
        answerList.append(s)
print(len(answerList))
