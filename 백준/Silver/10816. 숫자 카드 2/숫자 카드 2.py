import sys
N = int(sys.stdin.readline())
cards = {}
for i in map(int, sys.stdin.readline().split()):
    if i in cards:
        cards[i] +=1
    else:
        cards[i] = 1
M = int(sys.stdin.readline())
for i in map(int, sys.stdin.readline().split()):
    M -= 1
    if i in cards:
        if M:
            sys.stdout.writelines(str(cards[i])+" ")
        else:
            sys.stdout.writelines(str(cards[i]))
    else:
        if M:
            sys.stdout.writelines("0 ")
        else:
            sys.stdout.writelines("0")