import math
from itertools import permutations


def get_primes(max_len):
    eratosthenes = [0, 0] + [1] * max_len
    target = int(math.sqrt(max_len)) + 1

    for i in range(2, target):
        if eratosthenes[i] == 1:
            cnt = 2
            while cnt * i <= len(eratosthenes) - 1:
                eratosthenes[cnt * i] = 0
                cnt += 1

    primes = []
    for idx, val in enumerate(eratosthenes):
        if val == 1:
            primes.append(idx)
    return primes


def solution(numbers):
    answer = 0
    max_numbers = int(''.join(sorted(list(numbers), reverse=True)))
    nums = set()
    for l in range(1, len(numbers) + 1):
        for combi in permutations(numbers, l):
            nums.add(int(''.join(list(combi))))

    primes = get_primes(max_numbers)
    for num in nums:
        if num in primes:
            answer += 1
    return answer