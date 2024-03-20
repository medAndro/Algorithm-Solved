bracketQueue = []
while True:
    msg = input()
    if msg == '.':
        break
    for m in msg:
        if m == '(' or  m == '[':
            bracketQueue.append(m)
        elif m == ')' or m == ']':
            if len(bracketQueue) == 0:
                bracketQueue.append(m)
                break
            elif bracketQueue[-1] == '(' and m == ']':
                break
            elif bracketQueue[-1] == '[' and m == ')':
                break
            else:
                bracketQueue.pop()
    if len(bracketQueue) == 0:
        print('yes')
    else:
        print('no')
    bracketQueue.clear()