T = int(input())

for i in range(T):
    nums = list(map(int, input().split()))
    answer = int(round(sum(nums)/len(nums), 0))
    print(f'#{i+1} {answer}')