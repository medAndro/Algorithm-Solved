def solution(n):
    answer = []
    tower = [[i for i in range(n, 0, -1)], [], []]
    fixed_tower_idx = 2 if n % 2 == 0 else 1

    while len(tower[2]) < n:
        ta_idx = (fixed_tower_idx + 1) % 3
        ta = tower[ta_idx]
        tb_idx = (fixed_tower_idx + 2) % 3
        tb = tower[tb_idx]

        if not ta:
            ta.append(tb.pop())
            answer.append([tb_idx + 1, ta_idx + 1])
        elif not tb:
            tb.append(ta.pop())
            answer.append([ta_idx + 1, tb_idx + 1])
        elif ta[-1] < tb[-1]:
            tb.append(ta.pop())
            answer.append([ta_idx + 1, tb_idx + 1])
        elif tb[-1] < ta[-1]:
            ta.append(tb.pop())
            answer.append([tb_idx + 1, ta_idx + 1])
        fixed_tower_idx = (fixed_tower_idx - 1 if n % 2 == 0 else fixed_tower_idx + 1) % 3

    return answer