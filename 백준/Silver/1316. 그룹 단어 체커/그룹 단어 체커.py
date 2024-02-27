N = int(input())
groupWord = 0
for _ in range(N):
    word = input()
    seenAlphas = []
    lastAlpha = ''
    isGroup = True
    for w in word:
        if w == lastAlpha:
            continue
        elif w not in seenAlphas:
            seenAlphas.append(w)
            lastAlpha = w
        elif w in seenAlphas:
            isGroup = False
            break
    if isGroup:
        groupWord+=1

print(groupWord)