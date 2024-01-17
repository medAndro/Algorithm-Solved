arr = [list(map(int, input().split())) for _ in range(5)]
max_idx=0
max_sum=0
for i in range(5):
    if sum(arr[i]) > max_sum:
        max_sum = sum(arr[i])
        max_idx = i+1
print(f"{max_idx} {max_sum}")