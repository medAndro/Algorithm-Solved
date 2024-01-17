import sys
num = int(sys.stdin.readline())
numCount = [0]*10001
for i in range(num):
    numCount[int(sys.stdin.readline())] += 1
for i in range(len(numCount)):
    if numCount[i]:
        for _ in range(numCount[i]):
            sys.stdout.writelines(str(i)+'\n')