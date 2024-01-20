import sys
arr = [list(map(int,sys.stdin.readline().split())) for _ in range(9)]
maxNum = idx = ansIdx= 0
for i in arr:
    if max(i) > maxNum:
        maxNum = max(i)
        ansIdx = idx
    idx += 1
print(f"{maxNum}\n{ansIdx+1} {arr[ansIdx].index(maxNum) + 1}")