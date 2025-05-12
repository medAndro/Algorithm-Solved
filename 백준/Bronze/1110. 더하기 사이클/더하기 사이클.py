def getNewNum(target_num):
    if target_num < 10:
        str_num = "0"+str(target_num)
    else:
        str_num = str(target_num)
    a, b = map(int, str_num)
    sum_num = a + b
    return int(f"{b}{str(sum_num)[-1]}")

originNum = int(input())
targetNum = originNum

answer = 0
while True:
    answer += 1
    targetNum = getNewNum(targetNum)
    if targetNum == originNum:
        break

print(answer)