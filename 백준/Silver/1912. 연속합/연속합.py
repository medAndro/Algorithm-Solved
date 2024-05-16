input()
li = list(map(int, input().split()))

largestNum = None
answer = None
temp = None
for i, num in enumerate(li):
    if largestNum is None or num > largestNum:
        largestNum = num

    if answer is None:
        answer = num
        temp = num
        continue
    elif temp <= 0 < num:
        temp = num
    else:
        temp += num
    if temp > answer:
        answer = temp
if largestNum > answer:
    answer = largestNum
print(answer)
