from collections import defaultdict

N, C = map(int, input().split())
msg = list(map(int, input().split()))
msgDict = defaultdict(int)

for i in msg:
    msgDict[i] += 1

msgList = list(zip(list(msgDict.values()), list(msgDict.keys())))
msgList.sort(reverse=True, key=lambda x: x[0])

answer = [0] * N
idx = 0
for i in msgList:
    for _ in range(i[0]):
        answer[idx] = i[1]
        idx += 1
print(" ".join(map(str, answer)))
