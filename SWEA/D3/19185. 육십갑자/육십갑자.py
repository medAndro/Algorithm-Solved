for tc in range(int(input())):
    Nlen, Mlen = map(int, input().split())
    N = list(input().split())
    M = list(input().split())

    answer = []
    for _ in range(int(input())):
        year = int(input()) - 1

        answer.append(N[year % Nlen] + M[year % Mlen])
    print(f'#{tc + 1}', ' '.join(answer))
