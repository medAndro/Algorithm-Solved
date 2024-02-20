import heapq
import sys
minHeap = []

for _ in range(int(input())):
    num = int(sys.stdin.readline().strip())
    if num==0:
        if minHeap:
            sys.stdout.writelines(str(heapq.heappop(minHeap))+'\n')
        else:
            sys.stdout.writelines('0\n')
    else:
        heapq.heappush(minHeap, num)