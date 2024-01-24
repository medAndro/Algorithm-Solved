N = int(input())
arr = list(map(int, input().split()))
prime = 0
for i in arr:
    if i == 1:
        continue
    elif i == 2:
        prime +=1
    else:
        primeflag = True
        for j in range(2, i):
            if i%j == 0:
                primeflag = False
                break
        if primeflag: prime +=1

print(prime)