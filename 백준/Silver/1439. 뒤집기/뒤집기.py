arr = input()
zero = 0
one = 0

if arr[0] == '0':
    start = '0'
    zero+=1
else:
    start = '1'
    one+=1

for i in range(1, len(arr)):
    if arr[i] == start:
        continue
    else:
        start = arr[i]
        if arr[i] == '0':
            zero += 1
        else:
            one += 1

if zero > one:
    print(one)
else:
    print(zero)