for t in range(int(input())):
    C, F, X = map(float, input().split())
    farm = 0
    answer = None
    sec = 0

    while True:

        if answer is None or answer > sec + (X / (2 + (farm * F))):
            answer = sec + (X / (2 + (F * farm)))
        else:
            break

        sec += (C / (2 + (farm * F)))
        farm += 1

    print(f'Case #{t + 1}: {answer}')
