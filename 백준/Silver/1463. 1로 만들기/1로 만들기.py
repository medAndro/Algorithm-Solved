from collections import deque
N = int(input())
deq = deque([])

if N == 1 : print(0)
else:
    deq.append((N-1, 1))
    if N % 2 == 0: deq.append((N // 2, 1))
    if N % 3 == 0: deq.append((N // 3, 1))
    while True:
        cur = deq.pop()
        curVal = cur[0]
        curCnt = cur[1]
        if curVal == 1:
            print(curCnt)
            break
        if curVal % 3 == 0 and curVal >1:
            deque.appendleft(deq, (curVal // 3, curCnt+1))
        if curVal % 2 == 0 and curVal >1:
            deque.appendleft(deq, (curVal // 2, curCnt+1))
        deque.appendleft(deq, (curVal-1, curCnt+1))