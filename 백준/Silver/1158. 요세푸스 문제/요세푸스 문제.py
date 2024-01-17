N, K = map(int, input().split())
LL = {}
AnsArr = []
for i in range(1,N+1):
    if i == N:
        LL[i] = 1
    else:
        LL[i] = i + 1
cur = 1
i = 0
prev = 1
while len(LL)>0:
    i += 1
    if i == K:
        next = LL.get(cur)
        AnsArr.append(cur)
        LL.pop(cur)
        if prev in LL:
            LL[prev] = next
        cur = next
        i = 0
    else:
        prev = cur
        cur = LL.get(cur)
print("<",end="")
print(*AnsArr, sep=", ", end="")
print(">")