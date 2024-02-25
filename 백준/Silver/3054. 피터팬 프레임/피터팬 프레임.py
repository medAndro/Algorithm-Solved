word = input()

peterPan = ["..#..", ".#.#.", "#.", ".#"]
wendy = ["..*..", ".*.*.", "*.", ".*"]
answer = ["", "", ""]

for i in range(len(word)):
    isWendy = False
    if (i+1) % 3 == 0:
        isWendy = True
    if i == 0:
        if isWendy:
            answer[0] += wendy[0]
            answer[1] += wendy[1]
            answer[2] += wendy[2] + word[i] + wendy[3]
        else:
            answer[0] += peterPan[0]
            answer[1] += peterPan[1]
            answer[2] += peterPan[2] + word[i] + peterPan[3]
    else:
        answer[0] = answer[0][0:-1]
        answer[1] = answer[1][0:-1]
        answer[2] = answer[2][0:-1]

        if isWendy:
            answer[0] += wendy[0]
            answer[1] += wendy[1]
            answer[2] += wendy[2] + word[i] + wendy[3]
        else:
            answer[0] += peterPan[0]
            answer[1] += peterPan[1]
            if i % 3 == 0:
                answer[2] += wendy[2] + word[i] + peterPan[3]
            else:
                answer[2] += peterPan[2] + word[i] + peterPan[3]

print(answer[0])
print(answer[1])
print(answer[2])
print(answer[1])
print(answer[0])