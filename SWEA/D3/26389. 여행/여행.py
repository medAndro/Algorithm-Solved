T = int(input())

for test_case in range(1, T + 1):
    direction = set(input())
    if len(direction) % 2 == 1:
        print("No")
    else:
        if 'N' in direction and 'S' in direction:
            direction.remove('N')
            direction.remove('S')
        if 'W' in direction and 'E' in direction:
            direction.remove('W')
            direction.remove('E')
        if len(direction) == 0:
            print("Yes")
        else:
            print("No")