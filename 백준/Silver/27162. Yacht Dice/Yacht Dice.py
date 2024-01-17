import sys

yacht = sys.stdin.readline()
dices = list(map(int, sys.stdin.readline().split()))
max_yacht = 0

def check_max(val):
    global max_yacht
    if max_yacht < val:
        max_yacht = val

for i in range(len(yacht)):
    if yacht[i] == 'Y':
        if i < 6: # Ones ~ Siex 처리
            temp = 0
            for j in dices:
                if j == i + 1:
                    temp += j
            temp += (i + 1) * 2
            check_max(temp)
        elif i == 6: # Four of a Kind 처리
            if dices[0] == dices[1]:
                check_max(dices[0] * 4)
            elif dices[1] == dices[2]:
                check_max(dices[1] * 4)
            elif dices[0] == dices[2]:
                check_max(dices[0] * 4)
        elif i == 7: # Full House 처리
            if dices[0] == dices[1] == dices[2]:
                if dices[0] == 6:
                    check_max(6+6+6+5+5)
                else:
                    check_max((dices[0]*3)+6+6)
            elif dices[0] == dices[1]:
                check_max((dices[0] * 2) + (dices[2] * 3))
                check_max((dices[0] * 3) + (dices[2] * 2))
            elif dices[1] == dices[2]:
                check_max((dices[1] * 2) + (dices[0] * 3))
                check_max((dices[1] * 3) + (dices[0] * 2))
            elif dices[0] == dices[2]:
                check_max((dices[0] * 2) + (dices[1] * 3))
                check_max((dices[0] * 3) + (dices[1] * 2))
        elif i == 8: # Little Straight 처리
            ls = set(dices)
            if (6 not in dices) and len(ls) == 3:
                check_max(30)
        elif i == 9: # Big Straight 처리
            ls = set(dices)
            if (1 not in dices) and len(ls) == 3:
                check_max(30)
        elif i == 10:  # Yacht 처리
            if dices[0] == dices[1] == dices[2]:
                check_max(50)
        elif i == 11: # Choice 처리
            check_max(sum(dices) + 6 + 6)
    else:
        None
print(max_yacht)