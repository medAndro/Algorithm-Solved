def solution(prices):
    answer = [-1] * len(prices)
    stack = []
    for i, p in enumerate(prices):
        if len(stack) == 0:
            stack.append(i)
        elif p >= prices[stack[-1]]:
            stack.append(i)
        else:
            while len(stack) > 0 and p < prices[stack[-1]]:
                j = stack.pop()
                answer[j] = i-j
            stack.append(i)
    cnt = 0
    for i in range(len(prices) - 1, -1, -1):
        if answer[i] == -1:
            answer[i] = cnt
        cnt += 1

    return answer