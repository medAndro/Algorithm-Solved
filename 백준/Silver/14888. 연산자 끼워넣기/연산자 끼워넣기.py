N = int(input())
A = list(map(int, input().split()))
G = list(map(int, input().split()))

minV = 1000000001
maxV = -1000000001

def backTrack(idx, sum):
    global minV, maxV
    if idx == len(A):
        if minV > sum:
            minV = sum
        if maxV < sum:
            maxV = sum
        return

    for i in range(0, 4):

        if G[i] == 0:
            continue
        else:
            tempsum = 0
            if i == 0:
                tempsum = sum+A[idx]
            elif i == 1:
                tempsum = sum-A[idx]
            elif i == 2:
                tempsum = sum* A[idx]
            elif i == 3:
                if sum > 0 :
                    tempsum = sum // A[idx]
                elif sum <= 0:  tempsum = -(abs(sum)//A[idx])
            G[i] -= 1
            backTrack(idx+1, tempsum)
            G[i] += 1

backTrack(1, A[0])
print(maxV)
print(minV)