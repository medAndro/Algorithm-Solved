N, M = map(int, input().split())

minSet = 1000
minOne = 1000

for _ in range(M):
    S, O = map(int, input().split())
    if minSet > S:
        minSet = S
    if minOne > O:
        minOne = O

if minOne * 6 < minSet:
    print(N * minOne)
else:
    answer = (N // 6) * minSet
    N = N % 6
    if N * minOne < minSet:
        answer += N * minOne
    else:
        answer += minSet

    print(answer)
