T = int(input())

for test_case in range(1, T + 1):
    B, W, X, Y, Z = map(int, input().split())
    if X + Y >= Z * 2:
        print(B * X + W * Y)
    else:
        c = min(B, W)
        print((B - c) * X + (W - c) * Y + c * 2 * Z)
