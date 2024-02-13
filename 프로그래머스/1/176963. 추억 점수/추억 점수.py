def solution(name, yearning, photo):
    missDict = dict(zip(name, yearning))
    answer = [0]*len(photo)
    for p in range(len(photo)):
        for n in photo[p]:
            try:
                answer[p] += missDict.get(n)
            except:
                continue
    return answer