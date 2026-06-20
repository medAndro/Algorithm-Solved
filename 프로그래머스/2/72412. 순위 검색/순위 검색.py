from itertools import product
from bisect import bisect_left


def count_more(sorted_collection, value):
    return len(sorted_collection) - bisect_left(sorted_collection, int(value))


def solution(info, query):
    languages = ['cpp', 'java', 'python', '-']
    jobs = ['backend', 'frontend', '-']
    careers = ['junior', 'senior', '-']
    foods = ['chicken', 'pizza', '-']

    info_dict = {
        i: []
        for i in list(product(languages, jobs, careers, foods))
    }

    for i in info:
        q = list(i.split())
        val = int(q[4])
        for case in product([q[0], '-'], [q[1], '-'], [q[2], '-'], [q[3], '-']):
            info_dict[case].append(val)
    for key in info_dict:
        info_dict[key].sort()

    answer = []
    for j in query:
        q = list(j.replace(' and ', ' ').split())
        answer.append(count_more(info_dict[tuple(q[:-1])], int(q[4])))

    return answer