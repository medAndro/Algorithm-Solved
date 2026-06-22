def solution(distance, rocks, remove_num):
    rocks.sort()
    left = 1
    right = distance + 1
    answer = 0
    while left < right:
        x = (left + right) // 2
        prev_rock = 0
        remove_rock = 0
        for rock in rocks:
            if (rock - prev_rock) < x:
                remove_rock += 1
            else:
                prev_rock = rock
            if remove_rock > remove_num:
                break

        if (distance - prev_rock) < x:
            remove_rock += 1

        if remove_rock <= remove_num:
            answer = max(answer, x)
            left = x + 1
        else:
            right = x

    return answer