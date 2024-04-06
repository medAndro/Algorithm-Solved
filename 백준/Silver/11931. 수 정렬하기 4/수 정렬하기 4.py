import sys
N = int(input())
answer = [0 for _ in range(N)]
for i in range(N):
    answer[i] = int(sys.stdin.readline())
answer.sort(reverse=True)
print('\n'.join(map(str,answer)))