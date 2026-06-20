import bisect
from bisect import bisect_left
from copy import deepcopy
from itertools import product


def count_more(a, left_val):
    left_idx = bisect_left(a, left_val)
    return len(a) - left_idx


def solution(info, query):
    structure = dict({'backend':
                          dict({'junior':
                                    dict({'chicken': [], 'pizza': []})
                                   , 'senior':
                                    dict({'chicken': [], 'pizza': []})
                                })
                         , 'frontend':
                          dict({'junior':
                                    dict({'chicken': [], 'pizza': []})
                                   , 'senior':
                                    dict({'chicken': [], 'pizza': []})
                                })
                      })

    candidates = dict({'cpp': deepcopy(structure), 'java': deepcopy(structure), 'python': deepcopy(structure)})
    for info_text in info:
        q = list(info_text.split())
        bisect.insort(candidates[q[0]][q[1]][q[2]][q[3]], int(q[4]))

    answer = []
    for query_text in query:
        q = list(query_text.replace(' and ', ' ').split())
        q0 = ['cpp', 'java', 'python'] if q[0] == '-' else [q[0]]
        q1 = ['backend', 'frontend'] if q[1] == '-' else [q[1]]
        q2 = ['junior', 'senior'] if q[2] == '-' else [q[2]]
        q3 = ['chicken', 'pizza'] if q[3] == '-' else [q[3]]
        q4 = int(q[4])

        queries = list(product(q0, q1, q2, q3))
        total_num = 0
        for q in queries:
            total_num += count_more(candidates[q[0]][q[1]][q[2]][q[3]], q4)
        answer.append(total_num)
    return answer