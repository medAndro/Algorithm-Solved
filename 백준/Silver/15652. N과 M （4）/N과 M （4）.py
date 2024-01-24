N, M = map(int, input().split())

arr = []
def backTrack(idx):
    if len(arr) == M:
        print(" ".join(map(str,arr)))
        return
    for i in range(idx, N+1):
        arr.append(i)
        backTrack(arr[-1])
        arr.pop()
backTrack(1)