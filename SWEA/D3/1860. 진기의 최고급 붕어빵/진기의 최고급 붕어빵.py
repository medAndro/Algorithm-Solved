from collections import deque

TC = int(input())
for idx in range(TC):
    N, M, K = map(int, input().split())
    customer = list(map(int, input().split()))
    customer.sort()
    customer = deque(customer)
    sec = 0
    fishBread = 0
    Impossible = False
    while True:
        if sec >= 1 and sec % M == 0:
            fishBread += K

        while len(customer) > 0 and customer[0] <= sec:
            if fishBread > 0:
                fishBread -= 1
                customer.popleft()
            else:
                Impossible = True
                break
        if Impossible or len(customer) == 0:
            break
        sec += 1

    if Impossible:
        print(f'#{idx + 1} Impossible')
    else:
        print(f'#{idx + 1} Possible')
