Q = int(input())
for _ in range(Q):
    Ta, Tb, Va, Vb = map(int, input().split())
    time = 0
    sang = 0  # only A
    do = 0  # A and B
    while Va > 0 or Vb > 0:
        time += 1
        if sang < time and Va > 0:
            Va-=1
            sang += Ta
        if do < time:
            if Vb > 0:
                Vb-=1
                do += Tb
            elif Va > 0:
                Va-=1
                do += Ta
    print(max(sang, do))
