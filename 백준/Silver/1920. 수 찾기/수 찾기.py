import bisect
N = int(input())
A = list(map(int, input().split()))
A.sort()
input()
for m in list(map(int, input().split())):
    if bisect.bisect_left(A, m) != bisect.bisect_right(A, m):
        print(1)
    else:
        print(0)