
def base_10_to_reverse_3(n: int):
    arr = []
    while n > 0:
        arr.append(n % 3)
        n = n // 3
    return arr


def base_3_to_10(base3):
    base10 = 0
    base3.reverse()
    for idx in range(len(base3)):
        base10 += base3[idx] * 3 ** idx
    return base10


def solution(n):
    return base_3_to_10(base_10_to_reverse_3(n))