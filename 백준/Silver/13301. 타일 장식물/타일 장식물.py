N = int(input())

tile = [1, 1]

if N == 1:
    print(4)
else:
    while len(tile) < N:
        tile.append(tile[-2] + tile[-1])
    print((tile[-1] * 2) + ((tile[-1] + tile[-2]) * 2))