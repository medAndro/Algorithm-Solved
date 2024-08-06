def solution(numbers):
    answer = set()
    l = len(numbers)
    for i in range(l):
        for j in range(l):
            if j != i:
                answer.add(numbers[i] + numbers[j])
    answer = list(answer)
    answer.sort()
    return answer