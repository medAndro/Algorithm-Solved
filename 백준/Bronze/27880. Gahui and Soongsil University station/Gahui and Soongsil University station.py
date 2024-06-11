answer = 0
while True:
    try:
        h, s = input().split()
        if h == "Es":
            answer += int(s)*21
        else:
            answer += int(s)*17
    except:
        break

print(answer)