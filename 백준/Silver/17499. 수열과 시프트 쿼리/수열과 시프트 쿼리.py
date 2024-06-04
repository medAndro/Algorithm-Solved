N, Q = map(int, input().split())

A = list(map(int, input().split()))
shift = 0
for _ in range(Q):
    c = tuple(map(int, input().split()))
    if c[0] == 1:
        v = ((c[1] - 1) - shift)
        if v < 0:
            v = -(abs(v) % len(A))
        else:
            v = (v % len(A))
        A[v] += c[2]
    elif c[0] == 2:
        shift += c[1]
    elif c[0] == 3:
        shift -= c[1]

    if shift < 0:
        shift = -(abs(shift) % len(A))
    else:
        shift = (shift % len(A))

if shift < 0:
    A = A[-shift:] + A[:-shift]
elif shift > 0:
    A = A[-shift:] + A[:len(A) - shift]

print(' '.join(map(str, A)))
