d = dict()
for _ in range(int(input())):
    a, b = input().split()
    d[b] = a
answer = ''
for i in input():
    answer += d[i]

a, b = map(int, input().split())

print(answer[a - 1:b])
