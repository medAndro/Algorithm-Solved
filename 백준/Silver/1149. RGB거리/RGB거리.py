N = int(input())
rgb = []
for _ in range(N):
    rgb.append(tuple(map(int, input().split())))

currentRGB = list(rgb[0])
for i in range(1, N):
    r, g, b = rgb[i]
    r += min(currentRGB[1], currentRGB[2])
    g += min(currentRGB[0], currentRGB[2])
    b += min(currentRGB[0], currentRGB[1])
    currentRGB = [r,g,b]

print(min(currentRGB))