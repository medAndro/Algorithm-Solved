from collections import deque

def rotate(board, point):
    # 0-인덱스 보정
    row1, col1 = point[0] - 1, point[1] - 1
    row2, col2 = point[2] - 1, point[3] - 1
    
    # 변의 길이 계산
    horizontal_len = abs(col2 - col1 + 1)
    vertical_len = abs(row2 - row1 + 1)

    # 최솟값 초기화 및 추출을 위한 변수 설정
    min_val = board[row1][col1]
    r, c = row1, col1 - 1
    deq = deque()

    # 1. 테두리 값 추출 및 실시간 최솟값 갱신
    for _ in range(horizontal_len):
        c += 1
        deq.append(board[r][c])
        if board[r][c] < min_val: 
            min_val = board[r][c]
            
    for _ in range(vertical_len - 1):
        r += 1
        deq.append(board[r][c])
        if board[r][c] < min_val: 
            min_val = board[r][c]
            
    for _ in range(horizontal_len - 1):
        c -= 1
        deq.append(board[r][c])
        if board[r][c] < min_val: 
            min_val = board[r][c]
            
    for _ in range(vertical_len - 2):
        r -= 1
        deq.append(board[r][c])
        if board[r][c] < min_val: 
            min_val = board[r][c]
            
    # 2. 데큐를 이용한 시계 방향 1칸 회전
    deq.rotate(1)

    # 3. 회전된 값을 다시 보드에 삽입
    r, c = row1, col1 - 1
    index = 0
    
    for _ in range(horizontal_len):
        c += 1
        board[r][c] = deq[index]
        index += 1
        
    for _ in range(vertical_len - 1):
        r += 1
        board[r][c] = deq[index]
        index += 1
        
    for _ in range(horizontal_len - 1):
        c -= 1
        board[r][c] = deq[index]
        index += 1
        
    for _ in range(vertical_len - 2):
        r -= 1
        board[r][c] = deq[index]
        index += 1
        
    return min_val


def solution(rows, columns, queries):
    answer = []
    # 보드 초기화
    board = [[0] * columns for _ in range(rows)]
    counter = 1
    for i in range(rows):
        for j in range(columns):
            board[i][j] = counter
            counter += 1
            
    # 쿼리 순차 수행
    for query in queries:
        answer.append(rotate(board, query))

    return answer