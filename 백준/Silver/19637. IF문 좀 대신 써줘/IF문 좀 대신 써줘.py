import sys
import bisect

N, M = map(int, sys.stdin.readline().split())
title = ['']*N
power = [0]*N

for i in range(N):
    t, val = sys.stdin.readline().split()
    title[i] = t
    power[i] = int(val)
for i in range(M):
    p = int(sys.stdin.readline())
    print(title[bisect.bisect_left(power, p)])
