word = [input() for _ in range(5)]
for i in range(15):
    for j in range(5):
        if len(word[j]) - 1 >= i:
            print(word[j][i], end='')