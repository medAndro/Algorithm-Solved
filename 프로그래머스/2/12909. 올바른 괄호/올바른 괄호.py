def solution(arr):
    answer = []
    for a in arr:
        answer.append(a)
        if len(answer) >= 2:
            if answer[-2] == "(" and answer[-1] == ")":
                answer.pop()
                answer.pop()
    print(answer)
    return True if len(answer) == 0 else False