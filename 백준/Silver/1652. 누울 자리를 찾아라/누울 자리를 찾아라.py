N = int(input())

condo = [list(input()) for _ in range(N)]
vertical = 0
horizontal = 0
for i in range(N):
    v = 0
    h = 0
    for j in range(N):
        if condo[i][j] != 'X':
            h += 1
            if j == N - 1:
                if h >= 2:
                    horizontal += 1
                h = 0
        else:
            if h >= 2:
                horizontal += 1
            h = 0

    for j in range(N):
        if condo[j][i] != 'X':
            v += 1
            if j == N - 1:
                if v >= 2:
                    vertical += 1
                v = 0
        else:
            if v >= 2:
                vertical += 1
            v = 0

print(f"{horizontal} {vertical}")
