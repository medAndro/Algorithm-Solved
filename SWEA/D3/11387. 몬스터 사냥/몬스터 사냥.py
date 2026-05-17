T = int(input())

for test_case in range(1, T + 1):
    D, L , N = map(int, input().split())
    answer = 0
    for n in range(N):
        answer += D * (1 + n * L * 0.01)
    print(f"#{test_case} {int(answer)}")