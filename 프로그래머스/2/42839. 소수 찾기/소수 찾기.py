from itertools import permutations


def is_prime(num):
    if num < 2:
        return False
    for i in range(2, (num // 2) + 1):
        if num % i == 0:
            return False
    return True


def solution(numbers):
    answer = 0
    nums = set()
    for l in range(1, len(numbers) + 1):
        for permutation in permutations(numbers, l):
            nums.add(int(''.join(list(permutation))))

    for num in nums:
        if is_prime(num):
            answer += 1
    return answer