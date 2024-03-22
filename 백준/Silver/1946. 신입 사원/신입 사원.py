import sys
for _ in range(int(input())):
    N = int(input())
    applicants = [tuple(map(int, sys.stdin.readline().split())) for _ in range(N)]
    applicants.sort()
    answer = N
    minInterview = 100001
    for i, a in enumerate(applicants):
        if a[1] < minInterview:
            minInterview = a[1]
        if a[1] > minInterview:
            answer -= 1
    print(answer)