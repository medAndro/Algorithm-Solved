def solution(k, dungeons):
    max_visited_cnt = 0

    def dfs(visited_mask, current_mp, visit_cnt):
        nonlocal max_visited_cnt

        max_visited_cnt = max(visit_cnt, max_visited_cnt)
        if visit_cnt == len(dungeons):
            return

        # k개의 던전 중 1개 던전 방문
        for visit_idx in range(len(dungeons)):
            # 해당 던전이 미방문이면서 마나가 허용된다면 해당 던전 방문
            if not ((1 << visit_idx) & visited_mask):
                if dungeons[visit_idx][0] <= current_mp:
                    dfs(visited_mask | (1 << visit_idx), current_mp - dungeons[visit_idx][1], visit_cnt + 1)

    dfs(0b0, k, 0)
    return max_visited_cnt
