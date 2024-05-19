for _ in range(int(input())):
    team = input()
    verified = True
    upper = 0
    lower = 0
    num = 0
    for i in team:
        if i in ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']:
            num += 1
        if i.isalpha() and i.isupper():
            upper += 1
        if i.isalpha() and i.islower():
            lower += 1

    if upper > lower or len(team) == num or len(team) > 10:
        verified = False

    if verified:
        print(team)
