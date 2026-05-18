T = int(input())
for test_case in range(1, T + 1):
    p, q = map(float, input().split())
    # 한번 뒤집을떄 성공하려면 첫 시도가 뒤집혀 있었어야(1-p) 하고, q의 확률로 성공
    s1 = (1 - p) * q
    # 두번 뒤집을떄 성공하려면 첫 시도가 정상(p)이어야 하고, 첫 시도에서 실패(1-q) 해야 하며, 한번 뒤집으면 무조건 실패(1) 한 뒤, q의 확률로 성공
    s2 = p * (1 - q) * q

    if s1 < s2:
        print(f"#{test_case} YES")
    else:
        print(f"#{test_case} NO")