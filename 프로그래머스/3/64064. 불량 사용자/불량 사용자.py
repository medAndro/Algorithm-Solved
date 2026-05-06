import re
from itertools import permutations


def solution(user_id, banned_id):
    banned_regex = list(map(lambda x: x.replace('*', "."), banned_id))

    ban_candidates = []

    for id in user_id:
        for regex in banned_regex:
            if bool(re.fullmatch(regex, id)):
                ban_candidates.append(id)
                break

    user_permutations = list(permutations(ban_candidates, len(banned_id)))
    user_permutations_strs = list(map(lambda x: "".join(x), user_permutations))
    banned_full_regex = re.compile("".join(banned_regex))

    answer_set = set()
    for permutation_idx, user_id_strs in enumerate(user_permutations_strs):
        if re.fullmatch(banned_full_regex, user_id_strs):
            answer_set.add(tuple(sorted(user_permutations[permutation_idx])))

    return len(answer_set)
