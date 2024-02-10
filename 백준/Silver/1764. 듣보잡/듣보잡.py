import sys
import bisect
N, M = map(int, input().split())
names = [sys.stdin.readline().strip() for _ in range(N)]
names.sort()
answer = []
for _ in range(M):
    name = sys.stdin.readline().strip()
    if bisect.bisect_right(names, name)-bisect.bisect_left(names, name) > 0:
        answer.append(name)

print(len(answer))
answer.sort()
print("\n".join(answer))