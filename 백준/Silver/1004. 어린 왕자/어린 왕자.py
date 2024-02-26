import math
T = int(input())
for _ in range(T):
    x1, y1, x2, y2 = map(int, input().split())
    n = int(input())
    answer = 0
    for _ in range(n):
        cx, cy, r = map(int, input().split())

        a1 = abs(x1 - cx)
        b1 = abs(y1 - cy)
        c1 = math.sqrt((a1 * a1) + (b1 * b1))  # c와 시작점간의 거리

        a2 = abs(x2 - cx)
        b2 = abs(y2 - cy)
        c2 = math.sqrt((a2 * a2) + (b2 * b2))  # c와 끝점간의 거리

        if c1 < r and c2 < r:
            continue  # 같은 행셩계에 둘 다 존재할경우 무시
        elif c1 < r or c2 < r:
            answer += 1  # 특정 점이 특정 행성계에 포함

    print(answer)
