import sys

input = sys.stdin.readline
T = int(input())

for _ in range(T):
    n, k, t, m = map(int, input().split())

    teamInfo = [[0, 0, 0, 0] for _ in range(n)]
    teamAnswers = [[0] * k for _ in range(n)]
    for mm in range(m):
        i, j, s = map(int, input().split())

        if teamAnswers[i - 1][j - 1] < s:
            teamAnswers[i - 1][j - 1] = s

        teamInfo[i - 1][1] += 1
        teamInfo[i - 1][2] = mm
        teamInfo[i - 1][3] = i
    for i in range(n):
        teamInfo[i][0] = -sum(teamAnswers[i])
    teamInfo.sort()
    for i in range(n):
        if teamInfo[i][3] == t:
            print(i+1)
            break