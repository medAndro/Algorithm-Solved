from collections import defaultdict

hansooEngName = input()
alphaDict = defaultdict(int)
for letter in hansooEngName:
    alphaDict[letter] += 1
alphaList = list(zip(alphaDict.keys(), alphaDict.values()))

middle = ''
for element in alphaList:
    if element[1] % 2 != 0:
        middle += element[0]
alphaList.sort()

answer = ''
if len(middle) <= 1:
    for element in alphaList:
        answer += element[0] * (element[1]//2)
    print(f"{answer}{middle}{answer[::-1]}")
else:
    print("I'm Sorry Hansoo")