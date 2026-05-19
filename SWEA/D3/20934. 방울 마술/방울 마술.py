T = int(input())

for test_case in range(1, T + 1):
    S, K = input().split()
    K = int(K)
    S = S.index('o')
    if S == 1:
        K += 1
    if K == 0:
        answer = S
    else:
        answer = K % 2

    print(f"#{test_case} {answer}")
