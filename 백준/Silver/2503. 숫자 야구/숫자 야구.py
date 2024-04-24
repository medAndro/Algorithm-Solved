N = int(input())
possibleNums = []
for i in range(1, 1000):
    s = str(i).zfill(3)
    if '0' not in s:
        if s[0] != s[1] and s[1] != s[2] and s[0] != s[2]:
            possibleNums.append(s)
questions = []

for _ in range(N):
    num, s, b = input().split()
    s = int(s)
    b = int(b)
    questions.append([num, s, b])

answerCnt = 0
for p in possibleNums:
    isAnswer = True
    for q in questions:
        n, s, b = q
        ss = 0
        bb = 0
        for i in range(3):
            if p[i] == n[i]:
                ss += 1
            elif n[i] in p:
                bb += 1
        if ss != s or bb != b:
            isAnswer = False
            break

    if isAnswer:
        answerCnt += 1

print(answerCnt)
