import sys
input = lambda: sys.stdin.readline().rstrip()
N, M = map(int, input().split())
passwords = dict()

for _ in range(N):
    url, pWord = input().split()
    passwords[url] = pWord

for _ in range(M):
    print(passwords.get(input()))