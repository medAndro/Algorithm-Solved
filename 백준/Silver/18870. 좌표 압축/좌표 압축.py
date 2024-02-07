import bisect
N = int(input())
X = list(map(int, input().split()))
XSet = sorted(list(set(X)))
for i in range(N):
    X[i] = bisect.bisect_left(XSet, X[i])
print(" ".join(map(str, X)))