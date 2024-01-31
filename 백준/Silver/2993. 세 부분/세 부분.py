import itertools as its
word = input()
l = len(word)
combi = list(its.combinations(list(range(1,l)), 2))

answer = ""
for c in combi:
    w = ''.join(reversed(word[0:c[0]])) + ''.join(reversed(word[c[0]:c[1]])) + ''.join(reversed(word[c[1]:]))
    if answer == "":
        answer = w
    else:
        if answer > w:
            answer = w
print(answer)