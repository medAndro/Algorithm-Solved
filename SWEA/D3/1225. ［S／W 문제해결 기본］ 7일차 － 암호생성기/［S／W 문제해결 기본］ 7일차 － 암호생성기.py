from collections import deque

for idx in range(10):
    input()
    nums = deque(list(map(int, input().split())))
    endFlag = False
    while True:
        for i in range(1, 6):
            p = nums.popleft() - i
            if p < 0:
                p = 0
            nums.append(p)
            if p == 0:
                endFlag = True
                break
        if endFlag:
            break
    print(f'#{idx + 1} ' + ' '.join(map(str, nums)))
