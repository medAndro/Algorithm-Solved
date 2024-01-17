N = int(input())
arr = list(map(int, input().split()))
S = int(input())

sorted = []
while S:
    try:
        localMaxNum = max(arr[0:S+1]) #로 교환이 가능한 부분(시작점~S)중 최댓값
        localMaxIdx = arr[0:S+1].index(localMaxNum) #최댓값의 인덱스
        sorted.append(localMaxNum)
        del arr[localMaxIdx]
        S -= localMaxIdx #남은 S값 업데이트
    except:
        break

print(' '.join(list(map(str,sorted+arr))))