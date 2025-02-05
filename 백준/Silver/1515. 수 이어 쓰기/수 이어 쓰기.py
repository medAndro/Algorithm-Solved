from collections import deque
removed_nums = deque(input())

num = 0
while removed_nums:
    num+=1
    compare_nums = list(str(num))

    if removed_nums[0] in compare_nums:
        compare_nums = compare_nums[compare_nums.index(removed_nums[0]):]
        for c in compare_nums:
            if removed_nums and c == removed_nums[0]:
                removed_nums.popleft()
print(num)
