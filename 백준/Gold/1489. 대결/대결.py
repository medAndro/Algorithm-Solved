N = int(input())
A = sorted(list(map(int, input().split())))
B = sorted(list(map(int, input().split())))

answer = 0

while True:
    biggerExitFlag = False
    whileExitFlag = True
    for i in range(N):
        for j in range(N):
            if B[j] < A[i]:
                k = j
                while True:
                    try:
                        if B[k+1] < A[i]:
                            k += 1
                        else:
                            break
                    except:
                        break
                answer += 2
                del A[i]
                del B[k]
                N -= 1
                biggerExitFlag = True
                whileExitFlag = False
                break
        if biggerExitFlag:
            break
    if whileExitFlag:
        break

for i in A:
    if i in B:
        answer += 1
        B.remove(i)
print(answer)