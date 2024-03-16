import itertools as iter

N, M = map(int, input().split())
chickens = [list(map(int, input().split())) for _ in range(N)]
answer = 0
for pick in list(iter.permutations(list(range(M)), r=3)):
    pickVal = 0
    for n in range(N):
        pMax = 0
        for p in pick:
            if pMax < chickens[n][p]:
                pMax = chickens[n][p]
        pickVal += pMax
    if answer < pickVal:
        answer = pickVal
print(answer)
