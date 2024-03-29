import sys
import bisect

N, M = map(int, sys.stdin.readline().split())
title = []
power = []

inputs = sys.stdin.readlines()
for i in range(N):
    t, val = inputs[i].rstrip().split()
    title.append(t)
    power.append(int(val))

for i in range(M):
    print(title[bisect.bisect_left(power, int(inputs[i+N]))])
