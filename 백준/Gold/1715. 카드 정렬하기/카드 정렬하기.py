import sys
import heapq

N = int(sys.stdin.readline())
heap = []
for i in range(N):
    cards = int(sys.stdin.readline())
    heapq.heappush(heap, cards)
answer = 0
while len(heap) != 1 :
    sum_min2 = heapq.heappop(heap) + heapq.heappop(heap)
    answer += sum_min2
    heapq.heappush(heap, sum_min2)
print(answer)