def isVaild(li):
    stack = []
    for i in li:
        stack.append(i)
        if len(stack) >= 2:
            if stack[-1] == ')' and stack[-2] == '(':
                stack.pop();
                stack.pop()
            elif stack[-1] == ']' and stack[-2] == '[':
                stack.pop();
                stack.pop()
            elif stack[-1] == '}' and stack[-2] == '{':
                stack.pop();
                stack.pop()
    if len(stack) == 0:
        return True
    else:
        return False


from collections import deque


def solution(s):
    dequeS = deque(s)
    answer = 0
    for i in range(len(s)):
        if isVaild(dequeS):
            answer += 1
        dequeS.append(dequeS.popleft())
    return answer