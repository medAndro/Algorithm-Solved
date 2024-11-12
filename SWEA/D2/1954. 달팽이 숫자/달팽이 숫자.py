T = int(input())
for i in range(T):
    print(f"#{i+1}")
    N = int(input())
    snail = [[0]*N for _ in range(N) ]

    y, x = 0, 0
    snail[y][x] = 1
    move = [[0, 1], [1, 0], [0, -1], [-1, 0]] # 우,하 좌,상
    direction = 0

    number = 1
    while number < N*N:
        newY = y + move[direction % 4][0]
        newX = x + move[direction % 4][1]

        if newX < 0 or newX >= N or newY < 0 or newY >= N:
            direction += 1
            continue

        if snail[newY][newX] != 0:
            direction += 1
            continue

        number += 1
        snail[newY][newX] = number
        y = newY
        x = newX

    for i in range(N):
        print(*snail[i])