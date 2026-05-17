T = int(input())

for test_case in range(1, T + 1):
    n = int(input())
    wire = [list(map(int, input().split())) for _ in range(n)]
    answer = 0
    for i, w1 in enumerate(wire):
        for w2 in wire[i + 1:]:
            x = (w1[0] - w2[0]) > 0
            y = (w1[1] - w2[1]) > 0
            if x != y:
                answer += 1

    print(f"#{test_case} {answer}")
