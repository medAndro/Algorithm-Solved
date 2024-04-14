import sys
sys.setrecursionlimit(10**6)
N = int(input())
mines = [0] * N
for i in range(N):
    mines[i] = int(sys.stdin.readline())

answer = []
def boom(i):
    temp = mines[i]
    mines[i] = -1
    if (i + 1) < N and temp > mines[i + 1]:
        boom(i + 1)

for i in range(N):
    if mines[i] == -1:
        continue
    if i+1 == N:
        answer.append(i + 1)
    elif mines[i] >= mines[i + 1]:
        answer.append(i + 1)
        boom(i)

print('\n'.join(map(str, answer)))
