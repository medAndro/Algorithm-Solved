import sys
def power(a,b,m):
    result = 1
    while b > 0:
        if b % 2 != 0:
            result = (result * a) % m
        b //= 2
        a = (a * a) % m
    if result == 0:
        return 10
    else:
        return result

n = int(sys.stdin.readline())
for _ in range(n):
    a,b = map(int, sys.stdin.readline().split())
    sys.stdout.writelines(str(power(a, b, 10))+ '\n')