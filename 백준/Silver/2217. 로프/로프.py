import sys

N = int(sys.stdin.readline())
rope = [int(sys.stdin.readline()) for _ in range(N)]
rope.sort(reverse=True)

answer = 0
for i, r in enumerate(rope):
    if (i + 1) * r > answer:
        answer = (i + 1) * r

print(answer)
