for _ in range(int(input())):
    N, M = map(int, input().split())
    print(f'{(M*2)-N} {M-((M*2)-N)}')