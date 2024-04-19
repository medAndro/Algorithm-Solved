word = input()
i = 0
while True:
    i += 10
    if len(word[i - 10:i]) == 0:
        break
    else:
        print(word[i - 10:i])