def solution(s):
    strs_lists = list(map(lambda x: x.split(','), s[2:-2].split('},{')))
    strs_lists.sort(key=len)
    answer = dict()
    for strs in strs_lists:
        for c in strs:
            if c not in answer:
                answer[c] = 1
                break

    return list(map(int, answer))
