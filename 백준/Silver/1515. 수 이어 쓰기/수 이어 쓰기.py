removed_nums = input()
search_index = 0
num = 0

while search_index < len(removed_nums):
    num += 1
    current_num = str(num)

    i = 0  # current_num의 인덱스
    while i < len(current_num) and search_index < len(removed_nums):
        if current_num[i] == removed_nums[search_index]:
            search_index += 1
        i += 1

print(num)