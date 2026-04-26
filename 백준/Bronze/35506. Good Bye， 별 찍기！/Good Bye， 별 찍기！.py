def slash(n, idx):
    strs = [' '] * n
    strs[n - idx - 1] = '*'
    return "".join(strs)


def backslash(n, idx):
    return slash(n, idx)[::-1]


def solution(n):
    for idx in range(n):
        print(" " * n + slash(n, idx) + " " + slash(n, idx) + " " + backslash(n, idx))
    for idx in range(n):
        print(slash(n, idx) + " " * n + " " + backslash(n, idx) + " " + slash(n, idx))

n = int(input())
solution(n)
