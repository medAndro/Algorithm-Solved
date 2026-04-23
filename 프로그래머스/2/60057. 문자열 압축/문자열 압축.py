def solution(s):
    answer = len(s)
    if len(s) <= 2:
        return len(s)

    for i in range(1, len(s) // 2 + 1):
        parts = []
        idx = 0
        while idx + i <= len(s):
            if parts and parts[-1][0] == s[idx:idx + i]:
                parts[-1][1] += 1
            else:
                parts.append([s[idx:idx + i], 1])
            idx += i

        compressed_len = len(s[idx:])
        for part in parts:
            compressed_len += i
            if part[1] > 1:
                compressed_len += len(str(part[1]))
        answer = min(answer, compressed_len)
        
    return answer