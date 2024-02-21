import sys
from collections import defaultdict
from decimal import *
getcontext().rounding = ROUND_HALF_UP

opinion = defaultdict(int)
n = int(sys.stdin.readline())
for _ in range(n):
    opinion[int(sys.stdin.readline())] += 1
opinionKeys = list(sorted(opinion.keys()))

def opinionFilter(outlier):
    for i in opinionKeys:
        if opinion[i] < outlier:
            outlier -= opinion[i]
            opinion[i] = 0
        else:
            opinion[i] -= outlier
            break


opinionFilter(round(Decimal(n * 0.15), 0))
opinionKeys.reverse()
opinionFilter(round(Decimal(n * 0.15), 0))

cnt = 0
sumOpinion = 0

for i in opinionKeys:
    sumOpinion += i*opinion[i]
    cnt += opinion[i]

if cnt == 0:
    print(0)
else:
    print(round(Decimal(sumOpinion/cnt), 0))
