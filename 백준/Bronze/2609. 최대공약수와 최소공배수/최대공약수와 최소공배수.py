import math
a, b = map(int, input().split())
print(math.gcd(a, b))
def lcm(a, b): #최소공배수
    return int(a*b / math.gcd(a, b))
print(lcm(a, b))