S = input()
setS = set()

for i in range(1, 1 + len(S)):
    for j in range(len(S) - i + 1):
        setS.add(S[j:j + i])
print(len(setS))
