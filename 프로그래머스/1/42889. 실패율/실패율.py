def solution(N, stages):
    sList = [0] * (N+1)
    for s in stages:
        sList[s - 1] += 1
    sumList = sList.copy()
    for i in range(N - 1, -1, -1):
        sumList[i] += sumList[i + 1]
    ratio = list(map(lambda x, y: x / y if y != 0 else 0, sList[0:N], sumList[0:N]))
    r = list(zip(ratio, list(range(1, N + 1))))
    r.sort(key=lambda x: (-x[0], x[1]))
    answer = [0] * N
    for i in range(N):
        answer[i] = r[i][1]
    return answer