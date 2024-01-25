import sys
M, N = map(int, input().split())
primes = [1]*1000001
primes[0] = 0
primes[1] = 0
for i in range(2, 1000):
    if primes[i] == 1:
        isprime = True
        if i >= 3:
            for j in range(2,i-1):
                if i%j == 0:
                    isprime = False
        c = 1
        if isprime:
            while True:
                try:
                    c += 1
                    primes[i*c] = 0
                except:
                    break
        else:
            primes[i] = 0

for i in range(M, N+1):
    if primes[i]==1:
        sys.stdout.writelines(str(i)+"\n")