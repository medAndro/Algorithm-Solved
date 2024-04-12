N, M = map(int, input().split())

if N >= M:
    print(0)
else:
    a = 1
    for i in range(1, N+1):
        a *= i
        a %= M
    print(a)