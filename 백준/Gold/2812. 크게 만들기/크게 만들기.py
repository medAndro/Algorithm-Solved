N, K = map(int, input().split())
cmd = input()
stack = []

for i in cmd:
    while stack and stack[-1] < i and K > 0:
        stack.pop()
        K -= 1
    stack.append(i)


print("".join(stack[0:(len(stack)-K)]))