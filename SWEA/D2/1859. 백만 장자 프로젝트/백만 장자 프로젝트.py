T = int(input())

for i in range(T):
    n = int(input())
    nums = list(map(int, input().split()))
    maxNums = max(nums)
    answer = 0
    for j in range(n):
        if nums[j] < maxNums:
            answer += maxNums - nums[j]
        elif len(nums[j+1:]) > 0:
            maxNums = max(nums[j+1:])
    print(f'#{i+1} {answer}')