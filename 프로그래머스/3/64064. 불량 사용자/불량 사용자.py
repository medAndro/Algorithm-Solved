import re


def solution(user_id, banned_id):
    banned_regex = list(map(lambda x: x.replace('*', "."), banned_id))
    possible_ban_users = []
    for ban_idx in range(len(banned_id)):
        user_idx = []
        for idx, id in enumerate(user_id):
            if bool(re.fullmatch(banned_regex[ban_idx], id)):
                user_idx.append(idx)
        possible_ban_users.append(user_idx)
    print(possible_ban_users)
    results = set()

    def dfs(depth, current_selection):
        if depth == len(possible_ban_users):
            results.add(tuple(sorted(current_selection)))
            return
        for selected_user_idx in possible_ban_users[depth]:
            if selected_user_idx not in current_selection:
                current_selection.append(selected_user_idx)
                dfs(depth + 1, current_selection)
                current_selection.pop()

    dfs(0, [])
    return len(results)