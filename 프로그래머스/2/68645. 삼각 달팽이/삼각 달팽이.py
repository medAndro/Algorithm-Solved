from itertools import chain

def write(board, start_pos, write_count, current_num, direction):
    row = start_pos[0]
    col = start_pos[1]
    for i in range(write_count):
        row += direction[0]
        col += direction[1]

        board[row][col] = current_num
        current_num += 1
    return [row, col], current_num


def solution(n):
    board = [[0] * i for i in range(1, n + 1)]

    pos = [-1, 0]
    current_num = 1

    dr = [1, 0, -1]
    dc = [0, 1, -1]
    direction_counter = 0
    for write_count in range(n, 0, -1):
        current_dr = dr[direction_counter % 3]
        current_dc = dc[direction_counter % 3]
        pos, current_num = write(board, pos, write_count, current_num, (current_dr, current_dc))
        direction_counter += 1

    return list(chain.from_iterable(board))