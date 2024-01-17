cmd = input().split('-')
for i in range(len(cmd)):
    cmd[i] = sum(list(map(int, cmd[i].split('+'))))
answer = cmd[0]
del cmd[0]
for i in cmd:
    answer -= i
print(answer)