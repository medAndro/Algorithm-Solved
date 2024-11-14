message = input()
answerList = []
isTag = False
isWord = False
startIdx = -1
for idx, letter in enumerate(message):
    if isTag:
        if letter == '>':
            isTag = False
            answerList.append(message[startIdx:idx + 1])
        continue
    if letter == '<':
        isTag = True
        startIdx = idx
        continue
    if not isWord and (letter.isalpha() or letter.isdigit()):
        isWord = True
        startIdx = idx
    if isWord:
        if idx == (len(message)-1) or message[idx+1] == '<' or message[idx+1] == ' ':
            isWord = False
            answerList.append(message[startIdx:idx + 1][::-1])
    if letter == ' ':
        answerList.append(' ')
print(''.join(answerList))