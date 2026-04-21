def solution(arr1, arr2):
    row_len = len(arr1)
    col_len = len(arr2[0])
    answer = [[0] * col_len for _ in range(row_len)]

    for i in range(row_len):
        for j in range(col_len):
            sum_val = 0
            left = arr1[i]
            for m in range(len(left)):
                sum_val += arr2[m][j] * left[m]
            answer[i][j] = sum_val

    return answer
