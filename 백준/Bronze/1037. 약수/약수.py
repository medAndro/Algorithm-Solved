n = int(input())
arr = list(map(int, input().split()))

dict = {}
for i in arr:
    for j in arr:
        try:
            dict[i*j] += 1
        except:
            dict[i*j] = 1

for key, value in dict.items():
    if value == n:
        print(key)
        break