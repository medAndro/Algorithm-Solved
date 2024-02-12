import sys
N, M = map(int, input().split())
P = [sys.stdin.readline().strip() for _ in range(N)]
Q = [sys.stdin.readline().strip() for _ in range(M)]
Pdict = dict(zip(P, range(1, N+2)))
for i in Q:
    try:
        sys.stdout.writelines(P[int(i) - 1] + "\n")
    except:
        sys.stdout.writelines(str(Pdict[i]) + "\n")