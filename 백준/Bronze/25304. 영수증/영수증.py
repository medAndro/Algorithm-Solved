import math
receipt = int(input())
total = 0
for _ in range(int(input())):
    total += math.prod(map(int, input().split()))

if total == receipt:
    print("Yes")
else:
    print("No")