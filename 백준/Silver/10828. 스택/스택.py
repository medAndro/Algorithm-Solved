import sys
num = int(sys.stdin.readline())
stack = []
for i in range(num):
    inputVal = sys.stdin.readline().split()
    if inputVal[0] == "push":
        stack.append(inputVal[1])
    elif inputVal[0] == "pop":
        if stack:
            print(stack.pop())
        else:
            print(-1)
    elif inputVal[0] == "size":
        print(len(stack))
    elif inputVal[0] == "empty":
        if stack:
            print(0)
        else:
            print(1)
    elif inputVal[0] == "top":
        if stack:
            print(stack[-1])
        else:
            print(-1)