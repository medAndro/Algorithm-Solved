from collections import deque

MKNum = input()

answerMax = ''
mCount = 0
for MKDigit  in MKNum:
    if MKDigit == 'K':
        answerMax += str(5 * 10 ** mCount)
        mCount = 0
    else:
        mCount += 1

answerMax += '1'*mCount

answerMin = ''
mCount = 0
for MKDigit  in MKNum:
    if MKDigit == 'K':
        if mCount > 0:
            answerMin += str(10 ** (mCount-1))
        answerMin += '5'
        mCount = 0
    else:
        mCount += 1

if mCount > 0:
    answerMin += str(1* 10**(mCount-1))

print(answerMax)
print(answerMin)