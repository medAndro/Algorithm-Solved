N = int(input())
def hanoi(N, s, t, e):
    if N==1:
        print(f"{s} {e}")
    else:
        hanoi(N-1, s, e, t)
        print(f"{s} {e}")
        hanoi(N-1, t, s, e)
print(2**N-1)
hanoi(N, 1,2,3)