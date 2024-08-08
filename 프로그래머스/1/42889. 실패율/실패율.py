def solution(N, stages):
    sList = [0] * (N + 1)
    for s in stages:
        sList[s - 1] += 1
    sumList = sList.copy()
    for i in range(N - 1, -1, -1):
        sumList[i] += sumList[i + 1]

    ratio = list(map(lambda x, y: x / y if y != 0 else 0, sList[0:N], sumList[0:N]))
    r = dict(zip(list(range(1, N + 1)), ratio))
    answer = sorted(r, key=lambda x: r[x], reverse=True)
    return answer
