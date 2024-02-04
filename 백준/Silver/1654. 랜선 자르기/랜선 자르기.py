K, N = map(int, input().split())
lans = []
for _ in range(K):
    lans.append(int(input()))
low = 0
high = 2**31

def check(val):
    if val == 0:
        return False
    lancount = 0
    for l in lans:
        lancount += l // val
    if N <= lancount:
        return False
    else:
        return True

while low + 1 < high:
    mid = (low + high) // 2

    if check(low) == check(mid):
        low = mid
    if check(high) == check(mid):
        high = mid

print(low)