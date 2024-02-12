import itertools as iter
import math
nums = list(map(int, input().split()))
groups = list(iter.permutations(nums, 3))
def lcm(a, b): #최소공배수
    return int(a*b / math.gcd(a, b))

minVal = -1
for g in groups:
    lcmThree = lcm(lcm(g[0], g[1]), g[2])
    if minVal == -1 or minVal > lcmThree:
        minVal = lcmThree
print(minVal)