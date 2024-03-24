from math import gcd

def lcm(a, b):
    return int(a * b / gcd(a, b))

a1, b1 = map(int, input().split())
a2, b2 = map(int, input().split())


b3 = lcm(b1, b2)
a3 = a1 * (b3 // b1) + a2 * (b3 // b2)

while gcd(a3, b3) != 1:
    g = gcd(a3, b3)
    a3 //= g
    b3 //= g

print(a3, b3)
