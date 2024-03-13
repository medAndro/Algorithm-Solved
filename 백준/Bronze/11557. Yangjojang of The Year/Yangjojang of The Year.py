import heapq

for _ in range(int(input())):
    h = []
    d = dict()
    for _ in range(int(input())):
        univ, drink = input().split()
        drink = int(drink)
        heapq.heappush(h, -drink)
        d[-drink] = univ
    print(d[h[0]])
    h.clear()
    d.clear()
