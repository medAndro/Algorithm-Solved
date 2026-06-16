def solution(numbers):
    str_nums = list(map(str, numbers))
    answer = ''.join(sorted(str_nums, key=lambda x: x*3, reverse=True))
    if answer[0] == '0':
        return '0'
    return answer