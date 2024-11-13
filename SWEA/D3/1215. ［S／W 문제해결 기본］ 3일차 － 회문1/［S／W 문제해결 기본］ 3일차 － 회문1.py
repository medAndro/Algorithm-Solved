T = 10

for i in range(T):
    palindromeLen = int(input())
    wordBoard = list(list(input()) for _ in range(8))
    wordBoardT = list(zip(*wordBoard))

    answer = 0
    for line in (wordBoardT + wordBoard):
        for start in range(8 - palindromeLen + 1):
            if all(line[start + i] == line[start + (palindromeLen - 1 - i)] for i in range(palindromeLen // 2 + 1)):
                answer += 1

    print(f"#{i+1} {answer}")