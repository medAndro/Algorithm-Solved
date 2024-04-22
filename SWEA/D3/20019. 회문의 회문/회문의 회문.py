T = int(input())
for i in range(T):
    word = input()
    f = (len(word) - 1) // 2
    flag = False
    if word == word[::-1]:
        if word[:f] == word[:f][::-1]:
            if word[-f:] == word[-f:][::-1]:
                flag = True
    if flag:
        print(f"#{i+1} YES")
    else:
        print(f"#{i+1} NO")