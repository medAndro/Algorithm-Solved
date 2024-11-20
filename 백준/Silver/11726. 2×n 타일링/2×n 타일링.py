n = int(input())
fibonacci = [0, 1, 1]
while n >= len(fibonacci):
    fibonacci.append(fibonacci[-1] + fibonacci[-2])
print((fibonacci[n] + fibonacci[n - 1]) % 10007)