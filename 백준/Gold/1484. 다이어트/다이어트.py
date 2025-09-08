G = int(input())

old = 1
cur = 2

answer = []
while True:
    g = pow(cur, 2) - pow(old, 2)
    if cur == old:
        break
    elif g < G:
        cur += 1
        continue
    elif g > G:
        old += 1
        continue

    else:
        answer.append(cur)
        cur += 1

if len(answer) == 0:
    print(-1)
else:
    print("\n".join(map(str, answer)))