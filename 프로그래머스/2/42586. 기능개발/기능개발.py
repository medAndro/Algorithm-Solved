import math
def solution(progresses, speeds):
    answer = []

    for i in range(len(progresses)):
        progresses[i] = math.ceil((100 - progresses[i]) / speeds[i])
    day = 0
    cnt = 0
    for p in progresses:
        if day < p:
            if day != 0:
                answer.append(cnt)
                cnt = 0
            day = p
            cnt += 1
        else:
            cnt += 1
    else:
        if cnt > 0:
            answer.append(cnt)

    return answer