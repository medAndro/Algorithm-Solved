def room_checker(room):
    for r in range(len(room)):
        for c in range(len(room)):
            if room[r][c] == 'P':
                isCanMoveDownOne = r != 4
                isCanMoveDownTwo = r < 3
                isCanMoveRightOne = c != 4
                isCanMoveRightTwo = c < 3
                isCanMoveLeftOne = c > 0

                # 밑에 사람이 있는 경우
                if isCanMoveDownOne:
                    if room[r + 1][c] == 'P':
                        return 0

                # 오른쪽에 사람이 있는 경우
                if isCanMoveRightOne:
                    if room[r][c + 1] == 'P':
                        return 0

                # 오른쪽 또는 밑이 파티션이 아닌데 오른쪽 아래에 사람이 있는 경우
                if isCanMoveRightOne and isCanMoveDownOne:
                    if room[r][c + 1] == 'O' or room[r + 1][c] == 'O':
                        if room[r + 1][c + 1] == 'P':
                            return 0

                # 왼쪽 또는 밑이 파티션이 아닌데 왼쪽 아래에 사람이 있는 경우
                if isCanMoveLeftOne and isCanMoveDownOne:
                    if room[r][c - 1] == 'O' or room[r + 1][c] == 'O':
                        if room[r + 1][c - 1] == 'P':
                            return 0

                #  밑이 파티션이 아닌데 밑의 밑에 사람이 있는 경우
                if isCanMoveDownTwo and room[r + 1][c] == 'O':
                    if room[r + 2][c] == 'P':
                        return 0

                #  오른쪽이 파티션이 아닌데 오른쪽의 오른쪽에 사람이 있는 경우
                if isCanMoveRightTwo and room[r][c + 1] == 'O':
                    if room[r][c + 2] == 'P':
                        return 0
    return 1


def solution(places):
    answer = []
    for room in places:
        answer.append(room_checker(room))

    return answer