for i in range(int(input())):
    A, B = map(int, input().split())
    target = B - A
    if A == B:
        print(f'#{i + 1} 0')
    elif A > B or target == 1:
        print(f'#{i + 1} -1')
    else:
        print(f'#{i + 1} {target//2}')
