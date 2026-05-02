def solution(brown, yellow):
    yellow_col_plus_row = (brown - 4) // 2

    yellow_row = 0
    while True:
        yellow_row += 1
        yellow_col = yellow_col_plus_row - yellow_row
        if yellow_row * yellow_col == yellow:
            return [yellow_col + 2, yellow_row + 2]