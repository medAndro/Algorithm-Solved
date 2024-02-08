N, M, K = map(int, input().split())
dog = -N
rabbit = 0
jump = 0
while dog < rabbit:
    dog+=K
    rabbit+=M
    jump+=1
print(jump)