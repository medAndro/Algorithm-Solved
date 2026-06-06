import re
from itertools import permutations


def calculator(exp_list, operator):
    result = [exp_list[0]]
    exp_list = exp_list[1:]
    is_skip = False
    for idx, c in enumerate(exp_list):
        if type(c) == int and is_skip == False:
            result.append(c)
        elif type(c) == int and is_skip == True:
            is_skip = False
        else:
            if c == operator:
                if operator == "+":
                    result[-1] = result[-1] + exp_list[idx + 1]
                if operator == "-":
                    result[-1] = result[-1] - exp_list[idx + 1]
                if operator == "*":
                    result[-1] = result[-1] * exp_list[idx + 1]
                is_skip = True
            else:
                result.append(c)

    return result


def solution(expression):
    answer = 0
    reg = re.compile(r"\d")
    exp_list = list()
    start_idx = 0
    for idx, c in enumerate(expression + "!"):
        if not reg.match(c):
            exp_list.append(int(expression[start_idx:idx]))
            start_idx = idx + 1
            if c != "!":
                exp_list.append(c)

    combis = permutations(['+', '-', '*'], 3)
    for combi in combis:
        first = calculator(exp_list, combi[0])
        second = calculator(first, combi[1])
        third = calculator(second, combi[2])
        answer = max(answer, abs(third[0]))

    return answer