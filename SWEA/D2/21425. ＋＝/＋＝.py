T = input()

testCases = [list(map(int, input().split())) for _ in range(int(T))]

for testCase in testCases:
    answer = 0
    while testCase[2] >= max(testCase[:2]):
        if testCase[0] <= testCase[1]:
            testCase[0] += testCase[1]
        else:
            testCase[1] += testCase[0]
        answer += 1
    print(answer)