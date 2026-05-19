T = int(input())

for test_case in range(1, T + 1):
    S, K = input().split()
    K = int(K)
    S = S.index('o')
    probability = [0.0] * 3
    probability[S] = 1.0

    for _ in range(K):
        left = probability[1] / 2
        middle = probability[0] + probability[2]
        right = probability[1] / 2
        probability[0] = left
        probability[1] = middle
        probability[2] = right
    print(f"#{test_case} {probability.index(max(probability))}")