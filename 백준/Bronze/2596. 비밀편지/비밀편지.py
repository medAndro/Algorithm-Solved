N = int(input())
message = input()
password = (
"000000",
"001111",
"010011",
"011100",
"100110",
"101001",
"110101",
"111010"
)
alphabet = "ABCDEFGH"

answer = []
isUnknow = False

for i in range(N):
    #print(keys.get(''.join(message[i*6:i*6])), end='')
    guess = -1
    for j in range(8):
        parity = 0
        for ll in range(6):
            if list(password[j])[ll] != message[i * 6:(i * 6) + 6][ll]:
                parity +=1
        if parity <= 1:
            guess = j
            break

    if guess == -1:
        print(i + 1)
        isUnknow = True
        break
    else:
        answer.append(alphabet[guess])

if not isUnknow:
    print(''.join(answer))