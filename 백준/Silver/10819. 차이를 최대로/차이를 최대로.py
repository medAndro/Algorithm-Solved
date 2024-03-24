import itertools

N = int(input())
arr = list(map(int, input().split()))
permuteArr = list(itertools.permutations(arr, r=N))
answer = 0
def cal(li:list):
    s = 0
    for i in range(0, N-1):
        s += abs(li[i] - li[i+1])
    return s

for p in permuteArr:
    c = cal(p)
    if c > answer:
        answer = c

print(answer)