import sys
n = int(sys.stdin.readline())
nums = [0]*n
for i in range(n):
    nums[i] = int(sys.stdin.readline())
nums.sort()
print("\n".join(map(str, nums)))