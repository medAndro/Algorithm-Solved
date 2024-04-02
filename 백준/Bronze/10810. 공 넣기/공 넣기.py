N, M = map(int, input().split())
basket = [0]*(N+1)
for _ in range(M):
    i, j, k = map(int, input().split())
    for b in range(i, j+1):
        basket[b] = k

print(' '.join(map(str, basket[1:])))