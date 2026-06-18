def solution(n, times):
    min_time = 1
    max_time = min(times) * n
    mid_time = max_time // 2

    while min_time < max_time:
        possible_number = 0
        for t in times:
            possible_number += mid_time // t

        if possible_number >= n:
            max_time = mid_time
        else:
            min_time = mid_time + 1
        mid_time = min_time + (max_time - min_time) // 2

    return mid_time
