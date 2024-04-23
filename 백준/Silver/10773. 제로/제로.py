import sys
stack = []

N = int(input())

for _ in range(N):
    i = int(sys.stdin.readline())
    if i == 0:
        stack.pop()
    else:
        stack.append(i)

print(sum(stack))