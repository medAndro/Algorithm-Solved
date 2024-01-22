N, M = map(int, input().split())
ans = []
def backTrack(depth):
    global ans, N, M
    if depth == M:
        print(" ".join(map(str, ans)))
        return

    for i in range(1, N+1):
        ans.append(i)
        backTrack(depth+1)
        ans.pop()
backTrack(0)