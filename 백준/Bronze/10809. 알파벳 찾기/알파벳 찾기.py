import string

word = input()
alpha = list(string.ascii_lowercase)
answer = dict(zip(alpha, [-1]*len(alpha)))

for i, w in enumerate(word):
    if answer[w] == -1:
        answer[w] = i

print(' '.join(map(str, list(answer.values()))))
