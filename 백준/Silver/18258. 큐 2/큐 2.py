import sys
from collections import deque

num = int(sys.stdin.readline())
deq = deque()
for i in range(num):
    cmd = sys.stdin.readline().split()
    if cmd[0] == "push":
        deq.appendleft(cmd[1])
    elif cmd[0] == 'pop':
        if deq:
            print(deq.pop())
        else:
            print(-1)
    elif cmd[0] == 'size':
        print(len(deq))
    elif cmd[0] == 'empty':
        if deq:
            print(0)
        else:
            print(1)
    elif cmd[0] == "front":
        if deq:
            print(deq[-1])
        else:
            print(-1)
    elif cmd[0] == "back":
        if deq:
            print(deq[0])
        else:
            print(-1)