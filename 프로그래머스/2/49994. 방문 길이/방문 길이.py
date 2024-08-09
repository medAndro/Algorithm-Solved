def solution(dirs):
    answer = 0
    visited = set()
    pos = [0, 0]

    newPosDict = {'U': [0, 1], 'D': [0, -1], 'L': [-1, 0], 'R': [1, 0]}
    for d in dirs:
        x = pos[0]
        y = pos[1]
        xx = x + newPosDict[d][0]
        yy = y + newPosDict[d][1]

        if -5 <= xx <= 5 and -5 <= yy <= 5:
            visited.add(str(x) + str(y) + str(xx) + str(yy))
            visited.add(str(xx) + str(yy) + str(x) + str(y))
            pos = [xx, yy]
            answer = len(visited) // 2
            
    return answer