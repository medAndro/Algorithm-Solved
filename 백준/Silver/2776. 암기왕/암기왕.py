for _ in range(int(input())):
    input()
    seenNums = set(map(int, input().split()))

    answerList = [0 for _ in range(int(input()))]
    note2Nums = map(int, input().split())

    for idx, num in enumerate(note2Nums):
        if num in seenNums:
            answerList[idx] = 1
    print("\n".join(map(str, answerList)))