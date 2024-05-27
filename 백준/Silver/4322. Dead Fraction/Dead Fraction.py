import math

while True:
    numS = str(input()[2:-3])
    if numS == '':
        break
    if len(numS) == 1:
        g = math.gcd(int(numS), 9)
        print(f'{int(int(numS) / g)}/{int(9 / g)}')
    else:
        aU = -1
        aD = -1
        l = len(numS)
        for i in range(1, l + 1):
            # i는 순환마디의 길이 l-i는 순환마디가 아닌 자리의 길이
            u = int(int(numS) - (0 if (l - i) == 0 else int(numS[:(l - i)])))
            d = int('9' * i + '0' * (l - i))
            g = math.gcd(u, d)
            if aD == -1 or aD > int(d / g):
                aU = int(u / g)
                aD = int(d / g)
        print(f'{aU}/{aD}')