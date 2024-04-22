T = int(input())

for i in range(T):
    nums = list(map(int, input().split()))
    answer = 0
    for j in nums:
        if j % 2 != 0:
            answer += j
    print(f'#{i+1} {answer}')