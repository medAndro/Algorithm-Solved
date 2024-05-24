T = int(input())

for _ in range(T):
    li = list(input())
    answer = 0
    cnt = 0
    for l in li:
        if l == 'O':
            cnt += 1
            answer += cnt
        else:
            cnt = 0
    print(answer)