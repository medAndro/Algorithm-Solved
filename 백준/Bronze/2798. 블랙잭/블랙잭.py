import itertools as iter
N, M = map(int, input().split())
cards = list(map(int, input().split()))

threeSum = list(set(map(sum, iter.permutations(cards, r=3))))
threeSum.sort()
for i in range(len(threeSum)-1, -1,-1):
    if threeSum[i] <= M:
        print(threeSum[i])
        break
