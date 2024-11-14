import string

T = int(input())
for _ in range(T):
    text = input().replace(' ', '')
    alphaDict = dict(zip(string.ascii_lowercase, [0]*26))
    for char in text:
        alphaDict[char] += 1

    alphaList = list(zip(alphaDict.values(), alphaDict.keys()))
    alphaList.sort(reverse=True)

    if alphaList[0][0] == alphaList[1][0]:
        print('?')
    else:
        print(alphaList[0][1])