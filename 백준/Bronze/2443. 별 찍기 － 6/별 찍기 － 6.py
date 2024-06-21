N = int(input()) - 1
for i in range(N, -1, -1):
    print((N - i) * " " + "**" * i + "*")