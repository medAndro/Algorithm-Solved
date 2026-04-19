def cross_point(a,b,e,c,d,f):
    if a*d-b*c == 0:
        return None
    if (b*f-e*d)%(a*d-b*c) != 0:
        return None
    if (e*c-a*f)%(a*d-b*c) != 0:
        return None

    x = (b*f-e*d)//(a*d-b*c)
    y = (e*c-a*f)//(a*d-b*c)
    return x,y

def check_min_xy(points):
    min_x = points[0][0]
    min_y = points[0][1]
    for point in points:
        if point[0] < min_x:
            min_x = point[0]
        if point[1] < min_y:
            min_y = point[1]
    return [min_x, min_y]

def convert_zero_based_star_with_max_point(points, min_xy):
    x_bias = -min_xy[0]
    y_bias = -min_xy[1]

    x_max =x_bias +points[0][0]
    y_max =y_bias +points[0][1]

    zero_based_star = []
    for point in points:
        converted_point = (point[0] + x_bias, point[1] + y_bias)
        zero_based_star.append(converted_point)
        if converted_point[0] > x_max:
            x_max = converted_point[0]
        if converted_point[1] > y_max:
            y_max = converted_point[1]

    return zero_based_star, (x_max, y_max)

def convert_star_text(star_point, size):
    star_text = [["."]*(size[0]+1) for _ in range(size[1]+1)]
    for point in star_point:
        star_text[point[1]][point[0]] = "*"

    star_text.reverse()

    return list(map("".join, star_text))

def solution(line):
    points = set()
    for x in line:
        for y in line:
            point = cross_point(x[0],x[1],x[2],y[0],y[1],y[2])
            if point is not None:
                points.add(point)
    points_list = list(points)
    star_point, size= convert_zero_based_star_with_max_point(points_list, check_min_xy(points_list))

    return convert_star_text(star_point, size)