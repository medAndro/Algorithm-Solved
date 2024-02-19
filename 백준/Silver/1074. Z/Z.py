N, r, c = map(int, input().split())
arr = []
r+=1
c+=1
def quadrantFinder(wh, r, c):
    if r <= wh // 2 and c <= wh // 2:
        return 1
    elif r <= wh // 2 and c > wh // 2:
        return 2
    elif r > wh // 2 and c <= wh // 2:
        return 3
    elif r > wh // 2 and c > wh // 2:
        return 4
def setNewRC(wh, quadrant):
    global r, c
    if quadrant == 2:
        c = c - wh//2
    elif quadrant == 3:
        r = r - wh//2
    elif quadrant == 4:
        r = r - wh//2
        c = c - wh//2

while N > 0:
    wH = 2 ** N
    size = 2 ** (N * 2)
    quadrant = quadrantFinder(wH, r, c)
    arr.append((quadrant-1) * (size//4))
    N-=1
    setNewRC(wH, quadrant)

print(sum(arr))