N = int(input())

target = 1
append = 0
cnt = 0

while True:
    cnt += 1
    append += 6
    if target < N:
        target += append
    else:
        break

print(cnt)
