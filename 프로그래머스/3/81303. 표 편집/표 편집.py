def solution(n, k, cmds):
    lList = {}
    for i in range(n):
        if i == 0:
            lList[i] = [None, i + 1]
        elif i == n - 1:
            lList[i] = [i - 1, None]
        else:
            lList[i] = [i - 1, i + 1]
    delete = []
    for c in cmds:
        if c[0] == 'U':
            v = int(c[2:])
            for i in range(v):
                k = lList[k][0]
        elif c[0] == 'D':
            v = int(c[2:])
            for i in range(v):
                k = lList[k][1]
        elif c[0] == 'C':
            uIdx, dIdx = lList[k]
            delete.append(k)
            if dIdx is None:
                k = uIdx
                lList[uIdx][1] = None
            elif uIdx is None:
                k = dIdx
                lList[dIdx][0] = None
            else:
                k = dIdx
                lList[uIdx][1] = dIdx
                lList[dIdx][0] = uIdx
        elif c[0] == 'Z':
            p = delete.pop()
            uIdx = lList[p][0]
            dIdx = lList[p][1]
            if uIdx is None:
                lList[dIdx][0] = p
            elif dIdx is None:
                lList[uIdx][1] = p
            else:
                lList[uIdx][1] = p
                lList[dIdx][0] = p

    answer = ['O'] * n
    for d in delete:
        answer[d] = 'X'
    return ''.join(answer)