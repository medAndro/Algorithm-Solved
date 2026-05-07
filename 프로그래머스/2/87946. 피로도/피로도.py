def solution(k, dungeons):
    max_visited_cnt = 0

    def dfs(depth, visited_mask, current_mp):
        nonlocal max_visited_cnt
        if depth == len(dungeons):
            max_visited_cnt = max(bin(visited_mask).count('1'), max_visited_cnt)
            return

        # 현재 depth에서 k개의 던전 중 1개 던전 방문
        for visit_idx in range(len(dungeons)):
            # 해당 던전이 미방문한 상태일 경우
            if not ((1 << visit_idx) & visited_mask):
                if dungeons[visit_idx][0] <= current_mp:
                    dfs(depth + 1, visited_mask | (1 << visit_idx), current_mp - dungeons[visit_idx][1])

        # 현재 depth에서 던전 미방문
        dfs(depth + 1, visited_mask, current_mp)

    dfs(0, 0b0, k)
    return max_visited_cnt
