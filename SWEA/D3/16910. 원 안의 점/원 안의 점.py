import math

tc = int(input())

for i in range(tc):
    answer = 0
    N = int(input())
    for x in range((N * 2) + 1):
        for y in range((N * 2) + 1):
            if N >= math.sqrt((abs(x - N) ** 2) + (abs(y - N) ** 2)):
                answer += 1
    print(f'#{i + 1} {answer}')
