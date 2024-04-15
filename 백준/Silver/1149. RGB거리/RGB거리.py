import sys
input = sys.stdin.readline
N = int(input())
rgb = []
for _ in range(N):
    rgb.append(list(map(int, input().split())))

for i in range(1, N):
    r, g, b = rgb[i]
    r += min(rgb[0][1], rgb[0][2])
    g += min(rgb[0][0], rgb[0][2])
    b += min(rgb[0][0], rgb[0][1])
    rgb[0] = [r,g,b]

print(min(rgb[0]))