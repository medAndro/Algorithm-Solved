while True:
    try:
        N = int(input())
        kanto = '- -'
        if N == 0:
            print('-')
        else:
            target = pow(3, N)

            while len(kanto) < target:
                kanto = kanto + ' ' * len(kanto) + kanto

            print(kanto)
    except:
        break
