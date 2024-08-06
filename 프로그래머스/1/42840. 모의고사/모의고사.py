def solution(numbers):
    answer = []
    sol = [[1, 2, 3, 4, 5] * 2000,
           [2, 1, 2, 3, 2, 4, 2, 5] * 1300,
           [3, 3, 1, 1, 2, 2, 4, 4, 5, 5] * 1000]
    cnt = [0] * 3

    for i in range(len(numbers)):
        for si, s in enumerate(sol):
            if numbers[i] == s[i]:
                cnt[si] += 1
    for i, c in enumerate(cnt):
        if c == max(cnt):
            answer.append(i + 1)
    answer.sort()
    return answer