import re


def solution(babbling):
    answer = 0
    pattern1 = re.compile(r"(aya|ye|woo|ma)+")
    pattern2 = re.compile(r"(ayaaya|yeye|woowoo|mama)+")
    for b in babbling:
        if re.fullmatch(pattern1, b):
            if not re.search(pattern2, b):
                answer += 1
    return answer