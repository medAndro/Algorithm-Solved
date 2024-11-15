msg = input()
bomb = list(input())

answerList = []
for letter in msg:
    answerList.append(letter)
    if len(answerList) >= len(bomb):
        if answerList[-len(bomb):] == bomb:
            for _ in range(len(bomb)):
                answerList.pop()

if answerList:
    print(''.join(answerList))
else:
    print('FRULA')