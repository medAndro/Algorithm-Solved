from collections import defaultdict

N = int(input())
buildings = list(map(int, input().split()))
seeCount = defaultdict(set)

for idx in range(N):
    targetIdx = idx+1
    while targetIdx < N:
        isCanSeeTarget = True
        betweenIdx = idx + 1
        while betweenIdx < targetIdx:
            slope = (buildings[targetIdx] - buildings[idx]) / (targetIdx - idx)
            yIntercept = buildings[idx] - slope * idx
            maxSeeHeight = slope * betweenIdx + yIntercept
            if buildings[betweenIdx] >= maxSeeHeight:
                isCanSeeTarget = False
                break
            betweenIdx = betweenIdx+1
        if isCanSeeTarget:
            seeCount[idx].add(targetIdx)
            seeCount[targetIdx].add(idx)
        targetIdx = targetIdx+1

answer = 0
for seeSet in seeCount.values():
    if answer < len(seeSet):
        answer = len(seeSet)

print(answer)