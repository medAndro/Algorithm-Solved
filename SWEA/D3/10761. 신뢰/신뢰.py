from collections import deque

T = int(input())

for test_case in range(1, T + 1):
    raw = list(input().split())[1:]
    case = deque()
    orange = deque()
    blue = deque()

    for r in range(len(raw)):
        if r % 2 != 0:
            case.append((raw[r - 1]))
            if raw[r - 1] == 'O':
                orange.append(int(raw[r]))
            else:
                blue.append(int(raw[r]))

    answer = 0
    o_pos = 1
    b_pos = 1

    while case:
        c = case[0]
        o = orange[0] if orange else None
        b = blue[0] if blue else None

        if o is not None:
            if o == o_pos and c == 'O':
                orange.popleft()
                case.popleft()
            if o_pos > o:
                o_pos -= 1
            elif o_pos < o:
                o_pos += 1

        if b is not None:
            if b == b_pos and c == 'B':
                blue.popleft()
                case.popleft()
            if b_pos > b:
                b_pos -= 1
            elif b_pos < b:
                b_pos += 1
        answer += 1

    print(f"#{test_case} {answer}")
