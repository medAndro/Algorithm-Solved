import sys
N = int(sys.stdin.readline())
arr = []
for i in range(N):
    arr.append(list(map(int,sys.stdin.readline().split())))
arr.sort(key=lambda x:(x[1],x[0]))
for i in arr:
    sys.stdout.writelines(str(i[0]) +" " +str(i[1])+"\n")