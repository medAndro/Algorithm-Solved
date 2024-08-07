def solution(arr1, arr2):
    xLen = len(arr2[0])
    yLen = len(arr1)
    answer = [[0] * xLen for _ in range(yLen)]

    for i in range(yLen):
        for j in range(xLen):
            for k in range(len(arr2)):
                answer[i][j] += arr1[i][k] * arr2[k][j]

    return answer