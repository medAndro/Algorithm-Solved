M, N = map(int, input().split())
eratosthenes = [1] * 1000001
eratosthenes[1] = 0
for i in range(2, 1001):
    isprime = True
    if i >= 3:
        for j in range(2, i):
            if i % j == 0:
                isprime = False
                break
    if isprime:
        ii = 2
        while i * ii <= 1000000:
            eratosthenes[i * ii] = 0
            ii += 1

for i in range(M, N+1):
    if eratosthenes[i]:
        print(i)
