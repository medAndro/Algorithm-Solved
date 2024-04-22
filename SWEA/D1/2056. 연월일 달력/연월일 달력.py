T = int(input())

for i in range(T):
    nums = input()
    yyyy = nums[:4]
    mm = nums[4:6]
    dd = nums[6:]
    valid = True
    if int(mm) in [1,3,5,7,8,10,12]:
        if not (1 <= int(dd) <= 31):
            valid = False
    elif int(mm) in [4,6,9,11]:
        if not (1 <= int(dd) <= 30):
            valid = False
    elif int(mm) == 2:
        if not (1 <= int(dd) <= 28):
            valid = False
    else:
        valid = False
    if valid:
        print(f'#{i + 1} {yyyy}/{mm}/{dd}')
    else:
        print(f'#{i + 1} -1')