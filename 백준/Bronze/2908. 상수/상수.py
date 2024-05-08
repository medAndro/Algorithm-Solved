oList = list(input().split())
rList = [word[::-1] for word in oList]
print(rList[0]) if rList[0] > rList[1] else print(rList[1])
