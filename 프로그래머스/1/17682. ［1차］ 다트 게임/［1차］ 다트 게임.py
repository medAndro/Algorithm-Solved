import re


def solution(dartResult):
    pattern = re.compile(r"(\d+)([SDT])([*#]?)")
    sdt = {"S": 1, "D": 2, "T": 3}
    answers = []
    results = re.findall(pattern, dartResult)
    for score, bonus, option in results:
        answers.append(int(score) ** sdt[bonus])
        if option == "*":
            answers[-2:] = [x * 2 for x in answers[-2:]]
        elif option == "#":
            answers[-1] *= -1
    return sum(answers)