for _ in range(int(input())):
    d, f, p = map(float, input().split())
    print(f'${format(round((d * f * p) + 0.000001, 2), ".2f")}')