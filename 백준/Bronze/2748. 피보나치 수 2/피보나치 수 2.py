n = int(input())

answer = [0, 1]

if n <= 2:
    print(1)
else:
    for _ in range(n - 1):
        answer.append(answer[-2] + answer[-1])
    print(answer[-1])
