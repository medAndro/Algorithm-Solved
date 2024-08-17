from collections import defaultdict
def solution(participant, completion):
    answer = ''
    dic = defaultdict(int)
    for p in participant:
        dic[p] += 1
    for c in completion:
        dic[c] -= 1
        if dic[c] == 0:
            del dic[c]
    return list(dic.keys())[0]