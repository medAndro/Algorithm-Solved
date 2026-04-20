from collections import deque

def write_down(board, start_pos, write_count, current_num):
    row = start_pos[0]
    col = start_pos[1]
    for _ in range(write_count):
        board[row][col] = current_num
        current_num += 1
        row += 1
    return [row - 1, col + 1], current_num

def write_right(board, start_pos, write_count, current_num):
    row = start_pos[0]
    col = start_pos[1]
    for _ in range(write_count):
        board[row][col] = current_num
        current_num += 1
        col += 1
    return [row - 1, col - 2], current_num

def write_up(board, start_pos, write_count, current_num):
    row = start_pos[0]
    col = start_pos[1]
    for _ in range(write_count):
        board[row][col] = current_num
        current_num += 1
        col -= 1
        row -= 1
    return [row + 2, col + 1], current_num

def solution(n):
    answer = []
    board = [[-1] * (n + 1) for _ in range((n + 1))]

    write_fnc = deque([write_down, write_right, write_up])
    pos = [1, 1]
    current_num = 1
    for write_count in range(n, 0, -1):
        fnc = write_fnc.popleft()
        pos, current_num = fnc(board, pos, write_count, current_num)
        write_fnc.append(fnc)

    for i in range(1, n + 1):
        answer.extend(board[i][1:i + 1])

    return answer
