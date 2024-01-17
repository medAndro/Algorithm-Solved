import sys

n = int(input())
l = list(map(int, sys.stdin))
l.sort()
for i in l:
    print(i)