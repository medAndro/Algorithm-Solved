T = int(input())

def check_omok(row, rd, col, cd, depth):
    if row < 0 or col < 0 or row >= n or col >= n:
        return False
    if board[row][col] == "o":
        if depth == 5:
            return True
        else:
            return check_omok(row + rd, rd, col + cd, cd, depth + 1)
    else:
        return False


for test_case in range(1, T + 1):
    n = int(input())
    board = [list(input()) for _ in range(n)]
    answer = False
    for row in range(n):
        if answer: break
        for col in range(n):
            if board[row][col] == "o":
                answer = (check_omok(row, 0, col, 1, 1)
                          or check_omok(row, 1, col, 0, 1)
                          or check_omok(row, 1, col, 1, 1)
                          or check_omok(row, 1, col, -1, 1))

            if answer: break
    print(f"#{test_case} {'YES' if answer else 'NO'}")
