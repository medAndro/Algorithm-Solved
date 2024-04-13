N, K = map(int, input().split())
nums = list(map(int, input().split()))
current = sum(nums[:K])
answer = current

for i in range(K, N):
    current -= nums[i - K]
    current += nums[i]
    if answer < current:
        answer = current

print(answer)
