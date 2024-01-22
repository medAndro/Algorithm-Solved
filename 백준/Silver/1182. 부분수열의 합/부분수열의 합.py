import itertools as its
N, S = map(int, input().split())
arr = list(map(int, input().split()))
answer = 0
for j in range(1, N+1):
    for i in list(its.combinations(arr, j)):
        if sum(i) == S:
            answer += 1
print(answer)