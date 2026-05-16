T = int(input())

for test_case in range(1, T + 1):
    won = [50000, 10000, 5000, 1000, 500, 100, 50, 10]
    cash = int(input())
    answer = []
    for w in won:
        if cash // w > 0:
            answer.append(cash // w)
            cash %= w
        else:
            answer.append(0)
    print(f"#{test_case}")
    print(' '.join(map(str, answer)))