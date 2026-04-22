def solution(s: str) -> str:
    answer = [' '] * len(s)

    cnt = 0
    for i in range(len(s)):
        if s[i].isalpha():
            answer[i] = s[i].lower() if cnt % 2 != 0 else s[i].upper()
            cnt += 1
        else:
            cnt = 0

    return ''.join(answer)