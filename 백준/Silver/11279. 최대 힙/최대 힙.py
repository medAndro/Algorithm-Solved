import heapq
import sys
input = sys.stdin.readline

N = int(input())
minHeap = []
for _ in range(N):
    x = int(input())
    x = -x
    if x == 0:
        print(-heapq.heappop(minHeap) if minHeap else 0)
    else:
        heapq.heappush(minHeap, x)