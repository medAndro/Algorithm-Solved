def solution(s, n):
    answer = [' '] * len(s)

    for i in range(len(s)):
        if s[i] == ' ':
            continue
        base = ord('A') if s[i].isupper() else ord('a')
        answer[i] = chr((ord(s[i]) - base + n) % 26 + base)

    return ''.join(answer)