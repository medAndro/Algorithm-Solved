import sys
import heapq

N = int(sys.stdin.readline())
heap = []

for i in range(N):
    num = int(sys.stdin.readline())
    if num:  # num 입력
        heapq.heappush(heap, -num)
    else:  # 출력
        if heap:  # 가장 큰값 출력
            print(-heapq.heappop(heap))
        else:
            print(0)