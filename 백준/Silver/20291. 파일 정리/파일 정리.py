from collections import defaultdict
import sys

input = sys.stdin.readline

n = int(input())
ext_map = defaultdict(int)
for _ in range(n):
    _, extension = input().strip().split('.')
    ext_map[extension] += 1

for ext in sorted(ext_map):
    print(f"{ext} {ext_map[ext]}")