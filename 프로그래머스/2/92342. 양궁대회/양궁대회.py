def solution(n, info):
    best_gap = 0
    best_shoot = [-1]

    def dfs(idx, remaining_arrows, current_ryan_shoot):
        nonlocal best_gap, best_shoot

        if idx == 11:
            current_ryan_shoot[10] += remaining_arrows
            ryan_score, apeach_score = 0, 0
            for i in range(11):
                if current_ryan_shoot[i] > info[i]:
                    ryan_score += (10 - i)
                elif info[i] > 0:
                    apeach_score += (10 - i)

            gap = ryan_score - apeach_score
            if gap > 0:
                if gap > best_gap:
                    best_gap = gap
                    best_shoot = current_ryan_shoot[:]
                elif gap == best_gap:
                    if current_ryan_shoot[::-1] > best_shoot[::-1]:
                        best_shoot = current_ryan_shoot[:]

            current_ryan_shoot[10] -= remaining_arrows
            return

        arrows_needed = info[idx] + 1
        if remaining_arrows >= arrows_needed:
            current_ryan_shoot[idx] = arrows_needed
            dfs(idx + 1, remaining_arrows - arrows_needed, current_ryan_shoot)
            current_ryan_shoot[idx] = 0  # 백트래킹 원복

        dfs(idx + 1, remaining_arrows, current_ryan_shoot)

    dfs(0, n, [0] * 11)
    return best_shoot