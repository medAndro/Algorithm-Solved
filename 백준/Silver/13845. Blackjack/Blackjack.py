from collections import deque

for _ in range(int(input())):
    hand = list(input().split())
    cal = 0
    aEleven = 0
    for h in hand:
        if h in ['T', 'J', 'Q', 'K']:
            cal += 10
        elif h == 'A':
            if (cal + 11) > 21:
                cal += 1
            else:
                cal += 11
                aEleven += 1
        else:
            cal += int(h)

    dummy = deque(list(input().split()))
    while cal <= 16 or (cal == 17 and aEleven > 0):
        p = dummy.popleft()
        hand.append(p)
        if p in ['T', 'J', 'Q', 'K']:
            cal += 10
        elif p == 'A':
            if (cal + 11) > 21:
                cal += 1
            else:
                cal += 11
                aEleven += 1
        else:
            cal += int(p)
        if cal > 21 and aEleven > 0:
            aEleven -= 1
            cal -= 10
    if cal == 21:
        isBJ = True
        for h in hand:
            if h not in ['A', 'T', 'J', 'Q', 'K']:
                isBJ = False
                break
        if len(hand) != 2:
            isBJ = False
        if isBJ:
            print('blackjack')
        else:
            print(cal)
    elif cal <= 21:
        print(cal)
    else:
        print('bust')