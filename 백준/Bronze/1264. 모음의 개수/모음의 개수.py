while True:
    words = input()
    if len(words) == 1 and words == '#':
        break
    else:
        ans = 0
        find=list('aeiouAEIOU')
        for f in find:
            ans+=words.count(f)
        print(ans)