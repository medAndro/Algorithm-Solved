cmd = input()
sumIron = 0
iron = -1
prev = 0
for i in cmd:
    if i == "(":
        iron += 1
        prev = 0
    elif i == ")":
        if prev:
            sumIron += 1
        else :
            sumIron += iron
        prev = 1
        iron -= 1
print(sumIron)