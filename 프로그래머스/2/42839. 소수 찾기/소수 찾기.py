import math
from itertools import permutations


def get_eratosthenes(max_len):
    eratosthenes = [0, 0] + [1] * max_len
    target = int(math.sqrt(max_len)) + 1

    for i in range(2, target):
        if eratosthenes[i] == 1:
            cnt = 2
            while cnt * i <= len(eratosthenes) - 1:
                eratosthenes[cnt * i] = 0
                cnt += 1
    return eratosthenes


def solution(numbers):
    answer = 0
    max_numbers = int(''.join(sorted(list(numbers), reverse=True)))
    nums = set()
    for l in range(1, len(numbers) + 1):
        for combi in permutations(numbers, l):
            nums.add(int(''.join(list(combi))))

    eratosthenes = get_eratosthenes(max_numbers)
    for num in nums:
        if eratosthenes[num] == 1:
            answer += 1
    return answer
