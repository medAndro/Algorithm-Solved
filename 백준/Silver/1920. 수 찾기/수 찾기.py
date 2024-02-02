N=int(input())
A=list(map(int, input().split()))
A.sort()
def binarySeach(num):
    start = 0
    end = N-1
    while start <= end:
        mid = (start + end) // 2
        if A[mid] < num:
            start = mid+1
        elif A[mid] > num:
             end = mid-1
        else:
            print(1)
            return
    print(0)

M=int(input())
B=list(map(int, input().split()))
for i in B:
    binarySeach(i)