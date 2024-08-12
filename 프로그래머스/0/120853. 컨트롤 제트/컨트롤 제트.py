def solution(s):
    arr = s.split()
    answer = []
    for a in arr:
        if a == 'Z':
            answer.pop()
        else:
            answer.append(int(a))

    print(answer)
    return sum(answer)