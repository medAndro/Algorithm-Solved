def rotate(board, point):
    row1, col1 = point[0] - 1, point[1] - 1
    row2, col2 = point[2] - 1, point[3] - 1
    horizontal_len = abs(col2 - col1 + 1)
    vertical_len = abs(row2 - row1 + 1)
    perimeter = horizontal_len * 2 + vertical_len * 2 - 4

    r = row1
    c = col1 - 1
    arr = []
    for _ in range(horizontal_len):
        c += 1
        arr.append(board[r][c])
    for _ in range(vertical_len - 1):
        r += 1
        arr.append(board[r][c])
    for _ in range(horizontal_len - 1):
        c -= 1
        arr.append(board[r][c])
    for _ in range(vertical_len - 2):
        r -= 1
        arr.append(board[r][c])
    arr = [arr[-1]] + arr[0:-1]

    r = row1
    c = col1 - 1
    index = 0
    for _ in range(horizontal_len):
        c += 1
        board[r][c] = arr[index]
        index += 1
    for _ in range(vertical_len - 1):
        r += 1
        board[r][c] = arr[index]
        index += 1
    for _ in range(horizontal_len - 1):
        c -= 1
        board[r][c] = arr[index]
        index += 1
    for _ in range(vertical_len - 2):
        r -= 1
        board[r][c] = arr[index]
        index += 1
    return min(arr)


def solution(rows, columns, queries):
    answer = []
    board = [[0] * columns for _ in range(rows)]
    counter = 1
    for i in range(rows):
        for j in range(columns):
            board[i][j] = counter
            counter += 1
    for query in queries:
        answer.append(rotate(board, query))

    return answer
