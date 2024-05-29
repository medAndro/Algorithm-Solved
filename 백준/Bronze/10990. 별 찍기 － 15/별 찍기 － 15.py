N = int(input())

for i in range(N):
    print((N - 1 - i) * ' ' + "*", end='')
    if i > 0:
        print(' ' * ((i * 2) - 1) + '*')
    else:
        print(' ' * (i * 2))
