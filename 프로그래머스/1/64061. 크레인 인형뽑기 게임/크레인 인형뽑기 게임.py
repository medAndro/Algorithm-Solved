def solution(board, moves):
    answer = 0
    basket = []
    bStack = [[] for _ in range(len(board[0]))]

    for y in range(len(board[0])):
        for x in range(len(board) - 1, -1, -1):
            if board[x][y] > 0:
                bStack[y].append(board[x][y])

    for i in moves:
        i -= 1
        if bStack[i]:
            if basket and basket[-1] == bStack[i][-1]:
                basket.pop()
                bStack[i].pop()
                answer += 2
            elif bStack[i]:
                basket.append(bStack[i].pop())

    return answer