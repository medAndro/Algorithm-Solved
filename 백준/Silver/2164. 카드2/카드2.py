import sys
from collections import deque

num = int(sys.stdin.readline())
deq = deque()
for i in range(1,num+1):
    deq.appendleft(i)

isOdd = True
while len(deq) != 1:
    if isOdd:
        deq.pop()
        isOdd = False
    else:
        deq.appendleft(deq.pop())
        isOdd = True

print(deq[0])