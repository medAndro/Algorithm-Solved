yHp, yAtk, mHp, mAtk = map(int, input().split())
P, S = map(int, input().split())
originMHp = mHp
skip = min(((mHp - P) // yAtk) - 1, (yHp // mAtk) - 1, (mHp // yAtk) - 1)
mHp -= (yAtk * skip)
yHp -= (mAtk * skip)
while True:
    mHp -= yAtk
    if mHp <= 0:
        break
    yHp -= mAtk
    if yHp <= 0:
        break
    if 1 <= mHp <= P:
        mHp += S
        #if mHp > originMHp:
            #mHp = originMHp
        break

skip = min((yHp // mAtk) - 1, (mHp // yAtk) - 1)
mHp -= (yAtk * skip)
yHp -= (mAtk * skip)
while True:
    mHp -= yAtk
    if mHp <= 0:
        print('Victory!')
        break
    yHp -= mAtk
    if yHp <= 0:
        print('gg')
        break
