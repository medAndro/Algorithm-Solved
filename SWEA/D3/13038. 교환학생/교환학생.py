TC = int(input())
for idx in range(TC):
    n = int(input())
    cls = list(map(int, input().split()))
    answer = None
    for i, c in enumerate(cls):
        cnt = 0
        ans = 0
        while ans < n:
            cnt += 1
            if cls[(i + (cnt - 1)) % 7] == 1:
                ans += 1
        if answer is None or cnt < answer:
            answer = cnt

    print(f'#{idx + 1} {answer}')
