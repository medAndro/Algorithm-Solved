import sys
from collections import defaultdict
input = sys.stdin.readline

N, M = map(int, input().split())
words = defaultdict(int)

for i in range(N):
    word = input().strip()
    if len(word) < M:
        continue
    words[word] += 1

sorted_keys = sorted(words, key=lambda x: (-words[x], -len(x), x))
print('\n'.join(sorted_keys))
