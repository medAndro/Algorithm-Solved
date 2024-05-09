import bisect

N = int(input())
M = int(input())

li = list(map(int, input().split()))
li.sort()

answer = 0
for i in li:
    target = M - i
    if target <= i:
        break
    if bisect.bisect_left(li, target) != bisect.bisect_right(li, target):
        answer += 1

print(answer)
