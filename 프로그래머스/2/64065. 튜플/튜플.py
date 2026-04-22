def solution(s):
    strs_lists = list(map(lambda x: x.split(','), s[2:-2].split('},{')))
    strs_lists.sort(key=len)
    answer = [int(strs_lists[0][0])]
    if len(strs_lists) == 1:
        return answer

    for i in range(1, len(strs_lists)):
        for c in strs_lists[i]:
            if c not in strs_lists[i - 1]:
                answer.append(int(c))
                break

    return answer