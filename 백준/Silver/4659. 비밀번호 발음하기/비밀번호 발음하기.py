while True:
    word = input()
    if word == 'end':
        break

    isAcceptable = False
    vowelsCounter = 0 #모음
    consonantCounter = 0 #자음

    for index, letter in enumerate(word):
        if index > 0 and word[index - 1] == letter:
            if letter not in 'eo':
                isAcceptable = False
                break

        if letter in 'aeiou':
            isAcceptable = True
            vowelsCounter += 1
            consonantCounter = 0
        else:
            consonantCounter += 1
            vowelsCounter = 0
        if vowelsCounter >= 3 or consonantCounter >= 3:
            isAcceptable = False
            break

    if isAcceptable:
        print(f'<{word}> is acceptable.')
    else:
        print(f'<{word}> is not acceptable.')