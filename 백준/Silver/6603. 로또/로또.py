import itertools as its
while True:
    arr = list(map(int, input().split()))
    if not arr[0]:
        break
    combi = list(its.combinations(sorted(arr[1:arr[0]+1]), 6))
    for i in combi:
        print(" ".join(map(str,i)))
    print()