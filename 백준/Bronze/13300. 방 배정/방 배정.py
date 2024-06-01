from collections import defaultdict
import math

N, K = map(int, input().split())

students = defaultdict(int)
for i in range(N):
    S, Y = input().split()
    students[S + Y] += 1

answer = 0
for k in students.keys():
    answer += math.ceil(students[k] / K)

print(answer)
