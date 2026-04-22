def solution(s, n):
    answer = ['a'] * len(s)

    for i in range(len(s)):
        if s[i] == ' ':
            answer[i] = ' '
        elif ord(s[i]) in range(ord('A'), (ord('Z') + 1)):
            new_ord = ord(s[i]) + n
            if new_ord > ord('Z'):
                answer[i] = chr(new_ord - ord('Z') + ord('A') - 1)
            else:
                answer[i] = chr(new_ord)
        elif ord(s[i]) in range(ord('a'), (ord('z') + 1)):
            new_ord = ord(s[i]) + n
            if new_ord > ord('z'):
                answer[i] = chr(new_ord - ord('z') + ord('a') - 1)
            else:
                answer[i] = chr(new_ord)

    return ''.join(answer)
