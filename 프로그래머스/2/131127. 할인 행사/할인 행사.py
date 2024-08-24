from collections import deque


def solution(want, number, discount):
    answer = 0
    l = sum(number)

    dicA = dict(zip(want, number))
    answerStr = ''.join(map(str, dicA.values()))
    dic = dict(zip(want, [0] * l))
    deq = deque()

    for d in discount:
        deq.append(d)
        if len(deq) > l:
            p = deq.popleft()
            try:
                dic[p] -=1
            except:
                pass
        try:
            dic[d] += 1
        except:
            pass
        if answerStr == ''.join(map(str, dic.values())):
            answer+=1

    return answer