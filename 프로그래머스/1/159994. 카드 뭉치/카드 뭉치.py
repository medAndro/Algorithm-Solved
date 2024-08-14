def solution(cards1, cards2, goal):
    goal = list(reversed(goal))

    c1Idx = 0
    c2Idx = 0
    while goal:
        g = goal.pop()
        if len(cards1) > c1Idx and g == cards1[c1Idx]:
            c1Idx += 1
        elif len(cards2) > c2Idx and g == cards2[c2Idx]:
            c2Idx += 1
        else:
            return "No"

    return "Yes"