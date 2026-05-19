T = int(input())

for test_case in range(1, T + 1):
    mirror_letters = dict({'b':'d', 'd':'b', 'p':'q', 'q':'p'})
    input_str = input()[::-1]
    answers = []
    for letter in input_str:
        answers.append(mirror_letters[letter])
    print(f"#{test_case} {''.join(answers)}")
