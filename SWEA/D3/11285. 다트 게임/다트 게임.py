T = int(input())
import math

for test_case in range(1, T + 1):
    N = int(input())
    answer = 0
    for _ in range(N):
        x, y = map(abs, map(int, input().split()))
        r = math.sqrt(x * x + y * y)
        score = 11 - math.ceil(r / 20)
        score = 10 if score > 10 else score
        answer += score if score >= 0 else 0
    print(f"#{test_case} {answer}")