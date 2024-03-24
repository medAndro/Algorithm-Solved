eratos = [1] * 1000001
eratos[0] = 0
eratos[1] = 0

for i in range(2, 1002):
    if eratos[i] == 1:
        t = i * 2
        while t < 1000001:
            eratos[t] = 0
            t += i

for _ in range(int(input())):
    n = int(input())
    flag = True
    for i in range(2, 1000001):
        if eratos[i] and n % i == 0:
            flag = False
            break
    if flag:
        print('YES')
    else:
        print('NO')
