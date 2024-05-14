import bisect
tc = int(input())
for _ in range(tc):
    input()
    yj = list(set(map(int, input().split())))
    yj.sort()
    input()
    for i in list(map(int, input().split())):
        if bisect.bisect_left(yj, i) != bisect.bisect_right(yj, i):
            print(1)
        else:
            print(0)