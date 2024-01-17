n = int(input())
arr = list(map(int, input().split()))
min = arr[0]
max = arr[0]
for i in arr:
    if min>i:
        min=i
    elif max<i:
        max=i
print(f"{min} {max}")