T = int(input())

for test_case in range(1, T + 1):
    words = input()
    pairs = dict()

    for word in words:
        if word not in pairs:
            pairs[word] = 1
        elif pairs[word] == 1:
            del pairs[word]
    if sum(pairs.values()) == 0:
        print(f"#{test_case} Good")
    else:
        answers = []
        for word in pairs:
            if pairs[word] == 1:
                answers.append(word)
        answers.sort()
        print(f"#{test_case} {''.join(answers)}")
