T = 10

for i in range(T):
    palindromeLen = int(input())
    wordBoard = list(list(input()) for _ in range(8))
    answer = 0
    for y in range(8):
        for startIdx in range(8-palindromeLen+1):
            isPalindrome = True
            for x in range(palindromeLen):
                if wordBoard[y][startIdx+x] != wordBoard[y][startIdx+(palindromeLen-1-x)]:
                    isPalindrome = False
                    break
            if isPalindrome:
                answer+=1
    for x in range(8):
        for startIdx in range(8-palindromeLen+1):
            isPalindrome = True
            for y in range(palindromeLen):
                if wordBoard[startIdx+y][x] != wordBoard[startIdx+(palindromeLen-1-y)][x]:
                    isPalindrome = False
                    break
            if isPalindrome:
                answer+=1

    print(f"#{i+1} {answer}")