from collections import defaultdict

T = int(input())

for test_case in range(1, T + 1):
    N = int(input())

    points = []
    x_points = defaultdict(list)
    y_points = defaultdict(list)

    for _ in range(N):
        point = list(map(int, input().split()))
        points.append(point)
        x_points[point[0]].append(point[1])
        y_points[point[1]].append(point[0])

    max_area_x2 = 0

    # 각 점을 직각 삼각형의 '모퉁이(교점)'라고 가정하고 순회
    for x0, y0 in points:
        # 현재 점(x0, y0)과 y좌표가 같은 점들 중 x거리의 최댓값 구하기
        max_dx = 0
        for x1 in y_points[y0]:
            max_dx = max(max_dx, abs(x1 - x0))

        # 현재 점(x0, y0)과 x좌표가 같은 점들 중 y거리의 최댓값 구하기
        max_dy = 0
        for y1 in x_points[x0]:
            max_dy = max(max_dy, abs(y1 - y0))

        # 두 변이 모두 존재할 때만 삼각형이 성립됨
        if max_dx > 0 and max_dy > 0:
            max_area_x2 = max(max_area_x2, max_dx * max_dy)

    print(max_area_x2)