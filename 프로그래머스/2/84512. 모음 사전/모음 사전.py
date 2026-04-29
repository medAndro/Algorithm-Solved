import sys

sys.setrecursionlimit(10 ** 6)

vowel = ["A", "E", "I", "O", "U"]
def aeiou(idx, chars, word):
    if len(word) == len(chars) and "".join(chars) == word:
        return idx

    if not chars:
        return aeiou(idx + 1, ['A'], word)
    else:
        if len(chars) < 5:
            return aeiou(idx + 1, chars + ['A'], word)
        else:
            for i in range(4, -1, -1):
                if chars[i] != "U":
                    return aeiou(idx + 1, chars[:i] + [vowel[vowel.index(chars[i]) + 1]], word)
            return None


def solution(word):
    return aeiou(0, [], word)