students = [0]*31

for _ in range(28):
    students[int(input())] = 1

for i in range(30):
    if students[i+1] == 0:
        print(i+1)