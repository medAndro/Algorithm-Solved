N, M = map(int, input().split())

li = list(range(1, N + 1))

for _ in range(M):
    i, j = map(int, input().split())
    li = li[0:i - 1] + list(reversed(li[i - 1:j])) + li[j:]

print(' '.join(map(str, li)))
