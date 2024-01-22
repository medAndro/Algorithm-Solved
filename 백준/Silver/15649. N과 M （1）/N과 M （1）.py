import itertools as its
N, M = map(int, input().split())
for i in list(its.permutations(list(range(1,N+1)), M)):
    print(" ".join(map(str, i)))