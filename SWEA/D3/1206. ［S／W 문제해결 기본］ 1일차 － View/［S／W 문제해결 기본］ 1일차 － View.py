for idx in range(10):
    N = int(input())
    building = list(map(int, input().split()))
    answer = 0
    for i, b in enumerate(building):
        if i < 2 or i > N - 3:
            continue
        else:
            append = b - max(building[i - 1], building[i - 2], building[i + 1], building[i + 2])
            if append > 0:
                answer += append

    print(f'#{idx + 1} {answer}')
