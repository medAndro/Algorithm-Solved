def solution(n, k, cmd):
    up = [x for x in range(-1, n + 1)]
    dn = [x for x in range(1, n + 2)]
    k += 1
    delete = []
    for c in cmd:
        if c[0] == "U":
            i = int(c[2:])
            for _ in range(i):
                k = up[k]
        elif c[0] == "D":
            i = int(c[2:])
            for _ in range(i):
                k = dn[k]
        elif c[0] == "C":
            delete.append(k)
            up[dn[k]] = up[k]
            dn[up[k]] = dn[k]
            if n < dn[k]:
                k = up[k]
            else:
                k = dn[k]
        elif c[0] == "Z":
            i = delete.pop()
            up[dn[i]] = i
            dn[up[i]] = i

    ansList = ['O'] * n
    for d in delete:
        ansList[d-1] = 'X'
    return ''.join(ansList)