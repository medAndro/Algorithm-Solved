T = int(input())

for i in range(T):
    nums = list(map(int, input().split()))
    answer = max(nums)
    print(f'#{i+1} {answer}')