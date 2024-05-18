TC = int(input())

for i in range(TC):
    N = int(input())
    nHalf = N//2
    word = input()

    if word[:nHalf] == word[nHalf:]:
        print(f'#{i+1} Yes')
    else:
        print(f'#{i + 1} No')