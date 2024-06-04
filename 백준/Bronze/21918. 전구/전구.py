N, M = map(int, input().split())

s = list(map(int, input().split()))
for _ in range(M):
    a, b, c = map(int, input().split())
    if a == 1:
        s[b - 1] = c
    if a == 2:
        for i, state in enumerate(s[b - 1:c]):
            s[(b - 1) + i] = 1 if state == 0 else 0
    if a == 3:
        for i, state in enumerate(s[b - 1:c]):
            s[(b - 1) + i] = 0
    if a == 4:
        for i, state in enumerate(s[b - 1:c]):
            s[(b - 1) + i] = 1

print(' '.join(map(str, s)))
