N = int(input())
arr = [list(map(int,input().split())) for _ in range(N)]

blue = white = 0
def findWB(arr, N):
    global blue, white
    halfN = int(N/2)
    miniArr = [[0]*halfN for _ in range(halfN)]
    z = x = sumarr = 0
    # 4사분면
    for i in range(0, halfN):
        for j in range(0, halfN):
            miniArr[z][x] = arr[i][j]
            if arr[i][j]:
                sumarr+=1
            x += 1
            if x%(halfN) == 0:
                x=0
                z+=1

    if sumarr == halfN**2:
        blue += 1
    elif sumarr == 0:
        white += 1
    else:
        findWB([miniArr[x:x+halfN] for x in range(0,halfN,halfN)][0], halfN)
    miniArr = [[0]*halfN for _ in range(halfN)]
    z = x = sumarr = 0
    # 1사분면
    for i in range(0, halfN):
        for j in range(halfN, halfN*2):
            miniArr[z][x] = arr[i][j]
            if arr[i][j]:
                sumarr+=1
            x += 1
            if x%(halfN) == 0:
                x=0
                z+=1

    if sumarr == halfN ** 2:
        blue += 1
    elif sumarr == 0:
        white += 1
    else:
        findWB([miniArr[x:x+halfN] for x in range(0,halfN,halfN)][0], halfN)
    miniArr = [[0]*halfN for _ in range(halfN)]
    z = x = sumarr = 0
    # 3사분면
    for i in range(halfN, halfN*2):
        for j in range(0, halfN):
            miniArr[z][x] = arr[i][j]
            if arr[i][j]:
                sumarr+=1
            x += 1
            if x%(halfN) == 0:
                x=0
                z+=1

    if sumarr == halfN ** 2:
        blue += 1
    elif sumarr == 0:
        white += 1
    else:
        findWB([miniArr[x:x+halfN] for x in range(0,halfN,halfN)][0], halfN)
    miniArr = [[0]*halfN for _ in range(halfN)]
    z = x = sumarr = 0
    # 2사분면
    for i in range(halfN, halfN*2):
        for j in range(halfN, halfN*2):
            miniArr[z][x] = arr[i][j]
            if arr[i][j]:
                sumarr+=1
            x += 1
            if x%(halfN) == 0:
                x=0
                z+=1

    if sumarr == halfN ** 2:
        blue += 1
    elif sumarr == 0:
        white += 1
    else:
        findWB([miniArr[x:x+halfN] for x in range(0,halfN,halfN)][0], halfN)

initsum = 0
for a in arr:
    for i in a:
        initsum += i

if initsum == N*N:
    print(0)
    print(1)
elif initsum == 0:
    print(1)
    print(0)
else:
    findWB(arr, N)
    print(white)
    print(blue)
