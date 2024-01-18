from collections import deque
N = int(input())

for i in range(N):
    answer = 0
    n, index = map(int, input().split())
    arr = deque(list(map(int, input().split())))
    myImp = arr[index]
    arr[index] = -1

    while True:
        pop = deque.popleft(arr)
        printpg = True
        imp = myImp if pop == -1 else pop
        for m in arr:
            if (myImp if m == -1 else m) > imp:
                printpg = False
                break
        if printpg:
            answer += 1
            if pop == -1:
                break
        else:
            deque.append(arr, pop)

    print(answer)