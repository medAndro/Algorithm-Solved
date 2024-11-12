from itertools import combinations

T = int(input())

for i in range(T):
    N, L = map(int, input().split())
    answer = 0
    tkList = [list(map(int, input().split())) for _ in range(N)]

    for combinationLengths in range(1,N+1):
        for combi in combinations(tkList, combinationLengths):
            kcalSum = 0
            favoriteSum = 0
            for element in combi:
                kcalSum += element[1]
                if kcalSum > L:
                    break
                favoriteSum += element[0]
            if favoriteSum > answer:
                answer = favoriteSum

    print(f"#{i+1} {answer}")