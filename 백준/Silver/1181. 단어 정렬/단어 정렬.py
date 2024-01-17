import sys
N = int(input())
wordSet = set()
words = []
for i in range(N):
    word = sys.stdin.readline()[0:-1]
    wordSet.add(word)
for i in wordSet:
    words.append([i, len(i)])

words.sort(key=lambda x:(x[1],x[0]))
for i in words:
    sys.stdout.writelines(i[0]+"\n")