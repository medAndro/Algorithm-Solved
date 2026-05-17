T = int(input())

s = set()
for x in range(1, 10):
    for y in range(1, 10):
        s.add(x*y)
for test_case in range(1, T + 1):
    n = int(input())
    if n in s:
        print(f"#{test_case} Yes")
    else:
        print(f"#{test_case} No")