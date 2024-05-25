chess = [1, 1, 2, 2, 2, 8]
for i, c in enumerate(list(map(int, input().split()))):
    chess[i] = chess[i] - c
print(' '.join(map(str, chess)))
