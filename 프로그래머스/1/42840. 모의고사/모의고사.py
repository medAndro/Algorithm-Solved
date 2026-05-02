def solution(answers):
    p1 = [1, 2, 3, 4, 5]
    p2 = [2, 1, 2, 3, 2, 4, 2, 5]
    p3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    users = [p1, p2, p3]
    right_answer_cnt = [0, 0, 0]
    for user_idx, user_answers in enumerate(users):
        for answer_idx, answer in enumerate(answers):
            if user_answers[answer_idx % len(user_answers)] == answer:
                right_answer_cnt[user_idx] += 1

    result = []
    for user_idx, answer_cnt in enumerate(right_answer_cnt):
        if answer_cnt == max(right_answer_cnt):
            result.append(user_idx + 1)

    return result
