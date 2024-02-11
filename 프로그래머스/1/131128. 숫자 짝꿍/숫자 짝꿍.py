def solution(X, Y):
    xDict = {}
    for i in list(str(X)):
        if xDict.get(i) is not None:
            xDict[i] += 1
        else:
            xDict[i] = 1
    yDict = {}
    for i in list(str(Y)):
        if yDict.get(i) is not None:
            yDict[i] += 1
        else:
            yDict[i] = 1
    ansDict={}
    for i in yDict.keys():
        if xDict.get(i):
            if xDict.get(i)> yDict.get(i):
                ansDict[i] = xDict.get(i) - (xDict.get(i) - yDict.get(i))
            else:
                ansDict[i] = yDict.get(i) - (yDict.get(i) - xDict.get(i))
    keys = list(ansDict.keys())
    keys.sort(reverse=True)
    if not keys:
        return '-1'
    elif keys[0] == '0':
        return '0'
    else:
        answer = ''
        for k in keys:
            answer += ansDict[k]*k
        return answer