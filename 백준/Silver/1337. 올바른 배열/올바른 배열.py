import sys
N = int(input())
arr = list(map(int,sys.stdin.readlines()))
arr.sort()
ans = 4
for i, a in enumerate(arr):
    cnt = 4
    for j in range(i+1, i+5):
        if j <= N-1:
            if a < arr[j] < a+5:
                cnt-=1
    if ans > cnt:
        ans = cnt
print(ans)