N = int(input())
answer = -1
for three in range(1668):
    for five in range(1001):
        if three*3+five*5 > N:
            break
        elif three*3+five*5 == N:
            if answer > (three+five) or answer == -1:
                answer = (three+five)

print(answer)