vote = [[0, 0, 0, 0] for _ in range(3)]

for _ in range(int(input())):
    a, b, c = map(int, input().split())
    vote[0][a] += 1
    vote[0][0] += a
    vote[1][b] += 1
    vote[1][0] += b
    vote[2][c] += 1
    vote[2][0] += c

m = max(vote[0][0], vote[1][0], vote[2][0])
answer = []

for i in range(3):
    if vote[i][0] == m:
        r = vote[i][1:4]
        r.reverse()
        answer.append([vote[i][0]] + r + [i + 1])

answer.sort(reverse=True)

if len(answer) == 1 or answer[0][:4] != answer[1][:4]:
    print(f'{answer[0][4]} {answer[0][0]}')
else:
    print(f'0 {answer[0][0]}')
