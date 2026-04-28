def collatz(n, cnt):
    if cnt == 500:
        return -1
    if n == 1:
        return cnt
    cnt += 1

    if n % 2 == 0:
        return collatz(n // 2, cnt)
    else:
        return collatz(n * 3 + 1, cnt)


def solution(num):
    return collatz(num, 0)