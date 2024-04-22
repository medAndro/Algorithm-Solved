N = int(input())
answer = []
for i in range(1, N+1):
    t = 0
    t += str(i).count('3')
    t += str(i).count('6')
    t += str(i).count('9')

    if t > 0:
        answer.append("-"*t)
    else:
        answer.append(i)

print(' '.join(map(str, answer)))