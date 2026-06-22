def solution(distance, rocks, remove_num):
    rocks.sort()

    left_distance = 1
    right_distance = distance + 1
    mid_distance = distance // 2

    answer = 0

    while left_distance < right_distance:
        prev_rock = 0
        removed_rock = 0
        for i in range(len(rocks)):
            if (rocks[i] - prev_rock) < mid_distance:
                removed_rock += 1
            else:
                prev_rock = rocks[i]
            if removed_rock > remove_num:
                break

        if distance - prev_rock < mid_distance:
            removed_rock += 1

        if removed_rock <= remove_num:
            answer = max(answer, mid_distance)
            left_distance = mid_distance + 1
        else:
            right_distance = mid_distance

        mid_distance = (right_distance + left_distance) // 2

    return answer
