N = int(input())
num = list(map(int,input().split()))
answer = -1
iL = 0
for i in range(N-1, 0, -1):
    if num[i-1] < num[i]:
        for j in range(N-1, i-1, -1):
            if num[j] > num[i - 1]:
                num[i - 1], num[j] = num[j], num[i - 1]
                answer = ' '.join(list(map(str, num[:i] + list(reversed(num[i:])))))
                break
    if answer != -1:
        break

print(answer)