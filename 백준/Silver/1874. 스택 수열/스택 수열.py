import sys
N = int(input())
stack = []
answer = []
idx = 1
flag = True
for i in range(N):
    j = int(sys.stdin.readline())
    while idx <= j:
        stack.append(idx)
        answer.append("+")
        idx += 1

    if stack[-1] == j:
        stack.pop()
        answer.append("-")
    else:
        flag = False
        break
if flag:
    print("\n".join(answer))
else:
    print("NO")