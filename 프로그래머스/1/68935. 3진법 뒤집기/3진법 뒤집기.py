def base_change(num, base):
    if num == 0:
        return 0
    nums = []
    while num:
        num, digit = divmod(num, base)
        nums.append(str(digit))
    return ''.join(reversed(nums))


def solution(num):
    base3 = base_change(num, 3)
    return int(base3[::-1], 3)
