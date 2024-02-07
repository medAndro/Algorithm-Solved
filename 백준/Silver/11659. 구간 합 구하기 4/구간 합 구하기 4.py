N, M = map(int, input().split())
nums = list(map(int, input().split()))
for i in range(0, N-1):
    nums[i+1] += nums[i]
for _ in range(M):
    i, j = map(int, input().split())
    print(nums[j-1] - (nums[i-2] if (i-2) >= 0 else 0))