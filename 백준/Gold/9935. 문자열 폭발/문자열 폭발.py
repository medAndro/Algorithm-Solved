msg = input()
bomb = list(input())

answerStack = []
for letter in msg:
    answerStack.append(letter)
    if len(answerStack) >= len(bomb):
        if answerStack[-len(bomb):] == bomb:
            for _ in range(len(bomb)):
                answerStack.pop()

if answerStack:
    print(''.join(answerStack))
else:
    print('FRULA')