T = int(input())

for test_case in range(1, T + 1):
    S, T = input().split()
    long_S = S
    long_T = T

    while len(long_S) < 100:
        long_S += S

    while len(long_T) < 100:
        long_T += T

    if long_S[:100] == long_T[:100]:
        print(f"#{test_case} yes")
    else:
        print(f"#{test_case} no")