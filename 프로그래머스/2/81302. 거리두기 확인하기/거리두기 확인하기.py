room_size = 5


def recursive_pos_check(board, visited, pos, depth):
    if depth == 2:
        return True
    visited.append(pos)
    dr = [-1, 1, 0, 0]
    dc = [0, 0, -1, 1]

    result = True
    for index in range(4):
        pos_r = pos[0] + dr[index]
        pos_c = pos[1] + dc[index]
        if pos_r < 0 or pos_c < 0 or pos_r == room_size or pos_c == room_size or board[pos_r][pos_c] == 'X':
            continue
        if [pos_r, pos_c] in visited:
            continue
        elif board[pos_r][pos_c] == 'P':
            return False
        elif board[pos_r][pos_c] == 'O':
            if not recursive_pos_check(board, visited.copy(), [pos_r, pos_c], depth + 1):
                return False
    return result


def room_checker(room):
    for r in range(room_size):
        for c in range(room_size):
            if room[r][c] == 'P':
                if not recursive_pos_check(room, [], [r, c], 0):
                    return 0
                else:
                    continue
    return 1


def solution(places):
    answer = []
    for room in places:
        answer.append(room_checker(room))

    return answer