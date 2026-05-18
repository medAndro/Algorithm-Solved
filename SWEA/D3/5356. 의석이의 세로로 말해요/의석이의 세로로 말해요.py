T = int(input())
for test_case in range(1, T + 1):
    words = [[''] * 5 for _ in range(15)]
    for i in range(5):
        letters = input()
        for j in range(len(letters)):
            words[j][i] = letters[j]
    print(f"#{test_case} {''.join(map(''.join, words))}")