T = int(input())

for test_case in range(1, T + 1):
    XYZ = list(map(int, input().split()))
    A, B, C = 0, 0, 0
    if XYZ.count(max(XYZ)) >= 2:
        X, Y, Z = XYZ[0], XYZ[1], XYZ[2]
        s = set(XYZ)
        answer = None
        for a in s:
            if answer is not None:
                break
            for b in s:
                if answer is not None:
                    break
                for c in s:
                    if answer is not None:
                        break
                    if X == max(a, b) and Y == max(b, c) and Z == max(c, a):
                        answer = [a, b, c]
                        break
        print(" ".join(map(str, answer)))

    else:
        print("-1 -1 -1")