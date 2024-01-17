N = int(input())
arrA = list(map(int, input().split()))
arrB = list(map(int, input().split()))
arrA.sort()
arrB.sort(reverse=True)
answer = 0
for i in range(N):
    answer += arrA[i] * arrB[i]
print(answer)