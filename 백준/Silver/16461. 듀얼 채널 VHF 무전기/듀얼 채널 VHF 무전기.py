def up(i):
    i += 20
    if i > 146000:
        i = 144000
    return i


def down(i):
    i -= 20
    if i < 144000:
        i = 146000
    return i


for t in range(int(input())):
    A, B, S, T = input().split()
    if S == 'B':
        A, B = B, A
    A = int(A[:3] + A[4:])
    B = int(B[:3] + B[4:])
    T = int(T[:3] + T[4:])

    answer = 6

    if A == T:
        answer = 0
    elif B == T:
        answer = 1

    au = ad = A
    bu = bd = B
    for i in range(0, 7):
        if i >= answer:
            break
        if i < answer and (au == T or ad == T):
            answer = i
            break
        au = up(au)
        ad = down(ad)

    for i in range(1, 7):
        if i >= answer:
            break
        if i < answer and (bu == T or bd == T):
            answer = i
            break
        bu = up(bu)
        bd = down(bd)
    print(answer)
