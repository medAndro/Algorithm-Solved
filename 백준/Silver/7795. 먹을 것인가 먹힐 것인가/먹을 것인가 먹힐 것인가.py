import bisect

for _ in range(int(input())):
    N, M = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
    B.sort()
    answer = 0
    for a in A:
        answer += bisect.bisect_left(B, a)
    print(answer)
