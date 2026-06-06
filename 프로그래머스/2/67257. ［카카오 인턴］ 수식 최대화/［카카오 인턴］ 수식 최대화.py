import re
from itertools import permutations


def apply_operator(tokens, op):
    result = []
    i = 0

    while i < len(tokens):
        if tokens[i] == op:
            left = result.pop()
            right = tokens[i + 1]

            if op == '+':
                result.append(left + right)
            elif op == '-':
                result.append(left - right)
            else:
                result.append(left * right)

            i += 2
        else:
            result.append(tokens[i])
            i += 1

    return result


def solution(expression):
    raw_tokens = re.findall(r'\d+|[+\-*]', expression)

    tokens = []
    for token in raw_tokens:
        if token.isdigit():
            tokens.append(int(token))
        else:
            tokens.append(token)

    answer = 0
    for priority in permutations(['+', '-', '*']):
        temp = tokens[:]

        for op in priority:
            temp = apply_operator(temp, op)

        answer = max(answer, abs(temp[0]))

    return answer