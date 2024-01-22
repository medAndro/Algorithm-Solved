import itertools as its
N, M = map(int, input().split())

for i in list(its.product(list(range(1,N+1)), repeat=M)):
    print(" ".join(map(str, i)))