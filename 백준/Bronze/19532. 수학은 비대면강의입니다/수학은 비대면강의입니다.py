a,b,c,d,e,f = map(int, input().split())

for x in range(-999, 1000):
    flag = False
    for y in range(-999, 1000):
        if a*x+b*y == c and d*x+e*y==f:
            flag = True
            break
    if flag:
        print(f"{x} {y}")
        break