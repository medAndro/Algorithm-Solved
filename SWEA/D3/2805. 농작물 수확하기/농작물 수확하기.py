T = int(input())
for idx in range(T):
    N = int(input())
    if N == 1:
        print(f'#{idx + 1} {input()}')
    else:
        mid = (N - 1) // 2
        answer = 0
        t = mid
        farm = [list(map(int, list(input()))) for _ in range(N)]
        for i, f in enumerate(farm):
            if i < mid:
                answer += sum(f) - sum(f[:t]) - sum(f[N - t:])
                t -= 1
            elif i == mid:
                answer += sum(f)
                t += 1
            elif i > mid:
                answer += sum(f) - sum(f[:t]) - sum(f[N - t:])
                t += 1

        print(f'#{idx + 1} {answer}')
