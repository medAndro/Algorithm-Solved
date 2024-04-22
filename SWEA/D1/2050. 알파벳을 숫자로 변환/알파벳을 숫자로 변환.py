import string
adic = dict(zip(list(string.ascii_uppercase), range(1,27)))
answer = []
for i in input():
    answer.append(adic[i])
print(' '.join(map(str, answer)))