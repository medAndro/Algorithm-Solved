from collections import defaultdict

T = int(input())
for _ in range(T):
    N = int(input())
    teamNo = list(map(int, input().split()))
    exceptTeam = set()
    for i in set(teamNo):
        if teamNo.count(i) < 6:
            exceptTeam.add(i)

    rankDict = defaultdict(list)
    exceptedCount = 0
    for rank, team in enumerate(teamNo):
        if team in exceptTeam:
            exceptedCount += 1
            continue
        rankDict[team].append(rank+1-exceptedCount)

    resultSum = []
    for team in rankDict.keys():
        if len(rankDict[team]) < 6:
            continue
        resultSum.append([sum(rankDict[team][0:4]), rankDict[team][4], team])
    resultSum.sort()

    print(resultSum[0][2])