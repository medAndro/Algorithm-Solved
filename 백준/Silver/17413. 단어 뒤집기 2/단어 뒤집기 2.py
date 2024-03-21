msg = input()
answer = []
word = False
tag = False
for i, m in enumerate(msg):
    if not tag and not word:
        if m == '<':
            tag = True
        else:
            word = True
        answer.append(m)
    elif tag:
        if m == '>':
            tag = False
        answer[-1] += m
    elif word:
        if m == ' ':
            word = False
            answer.append(m)
        elif m == '<':
            word = False
            tag = True
            answer.append(m)
        else:
            answer[-1] += m

for i in answer:
    if i[0] == '<':
        print(i, end='')
    else:
        print(i[::-1], end='')
print()