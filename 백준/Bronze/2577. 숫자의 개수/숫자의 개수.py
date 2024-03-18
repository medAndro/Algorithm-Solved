import sys

num = list(map(int, sys.stdin.readlines()))
target = str(num[0] * num[1] * num[2])

for i in range(10):
    print(target.count(str(i)))