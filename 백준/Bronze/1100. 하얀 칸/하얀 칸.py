chess = []
for i in range(8):
    row = list(input())
    if i % 2 == 1:
        chess += row[1:] + [row[0]]
    else:
        chess += row
answer = 0
for i, c in enumerate(chess):
    if i % 2 == 0 and c == "F":
        answer += 1

print(answer)