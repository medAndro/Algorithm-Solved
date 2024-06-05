A, B, C = map(int, input().split())
s = int((A + B + C) / 3)

print((s - B) + ((s - A) * 2))
