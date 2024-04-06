n = int(input())
ppap = input()
answer = 0
skip = 0
for i in range(0, n - 3):
    if skip > 0:
        skip -= 1
        continue
    if str(ppap[i:i + 4]) == "pPAp":
        answer += 1
        skip = 3

print(answer)
