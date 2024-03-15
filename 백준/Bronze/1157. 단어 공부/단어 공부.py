words = list(input().upper())
cnt = 0

for i in set(words):
    if cnt < words.count(i):
        cnt = words.count(i)
        result = i
    elif cnt == words.count(i):
        result = '?'

print(result)