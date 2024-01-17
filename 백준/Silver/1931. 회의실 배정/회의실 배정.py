import sys

N = int(sys.stdin.readline())
meeting = []
for _ in range(N):
    meeting.append(list(map(int, sys.stdin.readline().split())))
meeting.sort(key=lambda x: (x[1],x[0]))
answer = []
for m in meeting:
    if not answer: #정답이 비었으면
        answer.append(m)
    else:
        start = answer[-1][1]
        if m[0] >= start:
            answer.append(m)

print(len(answer))