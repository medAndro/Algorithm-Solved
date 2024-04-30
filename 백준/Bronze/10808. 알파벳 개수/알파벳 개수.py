import string

alpha = dict(zip(string.ascii_lowercase, range(26)))
answer = [0 for _ in range(26)]
for i in input():
    answer[alpha[i]] += 1

print(' '.join(map(str, answer)))
