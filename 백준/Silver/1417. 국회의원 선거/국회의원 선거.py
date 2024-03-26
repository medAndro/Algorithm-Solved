candidate = []
for i in range(int(input())):
    candidate.append(int(input()))

def calAnswr():
    answer = 0
    while max(candidate[1:]) >= candidate[0]:
        candidate[candidate[1:].index(max(candidate[1:])) + 1] -= 1
        candidate[0] += 1
        answer += 1
    return answer

print(0 if len(candidate) == 1 else calAnswr())
