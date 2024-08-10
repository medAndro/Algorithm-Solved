def solution(s):
    answer = -1
    stack = []
    for i in s:
        if len(stack) >= 1 and stack[-1] == i:
            stack.pop()
            continue
        else:
            stack.append(i)
    else:
        if len(stack) == 0:
            answer = 1
        else:
            answer = 0

    return answer
