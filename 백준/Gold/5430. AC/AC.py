from collections import deque
T = int(input())
for _ in range(T):
    p = input()
    n = int(input())
    inputArr = input()
    if inputArr == '[]':
        nums = deque([])
    else:
        nums = deque(map(int, inputArr.replace('[','').replace(']','').split(',')))
    emptyNums = False
    reverseArr = False
    for i in p:
        if i == 'R' and not reverseArr:
            reverseArr = True
        elif i == 'R' and reverseArr:
            reverseArr = False
        elif i == 'D' and nums:
            if reverseArr:
                nums.pop()
            else:
                nums.popleft()
        elif i == 'D' and not nums:
            emptyNums = True
            break
    if emptyNums:
        print("error")
    else:
        answerList = list(nums)
        if reverseArr:
            answerList.reverse()
        print('['+','.join(map(str,answerList))+']')