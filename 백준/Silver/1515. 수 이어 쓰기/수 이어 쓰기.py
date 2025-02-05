removed_nums = input()
search_index = 0
num = 0
while search_index < len(removed_nums):
    num+=1
    compare_nums = list(str(num))

    if removed_nums[search_index] in compare_nums:
        start_index = compare_nums.index(removed_nums[search_index])
        compare_nums = compare_nums[start_index:]
        for c in compare_nums:
            if search_index < len(removed_nums) and c == removed_nums[search_index]:
                search_index += 1
print(num)