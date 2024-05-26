N, M = map(int, input().split())
answer = [[0 for _ in range(M)] for _ in range(N)]

for _ in range(2):
    for n in range(N):
        t = list(map(int, input().split()))
        for m in range(M):
            answer[n][m] += t[m]

for n in answer:
    print(' '.join(map(str, n)))