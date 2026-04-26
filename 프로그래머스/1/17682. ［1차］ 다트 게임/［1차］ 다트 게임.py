import re


def solution(dartResult):
    pattern = re.compile(r"(\d+)([SDT])([*#]?)")
    sdt = {"S": 1, "D": 2, "T": 3}
    answers = []
    results = re.findall(pattern, dartResult)
    for result in results:
        answers.append(int(result[0]) ** sdt[result[1]])
        if result[2] == "*":
            answers[-1] *= 2
            if len(answers) >= 2:
                answers[-2] *= 2
        elif result[2] == "#":
            answers[-1] *= -1
    return sum(answers)