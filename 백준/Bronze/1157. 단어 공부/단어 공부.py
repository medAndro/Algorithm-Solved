from collections import defaultdict
alphaDict = defaultdict(int)
for alpha in input():
    alphaDict[alpha.upper()] += 1
keys = list(alphaDict.keys())
values = list(alphaDict.values())
if values.count(max(values)) > 1:
    print('?')
else:
    print(keys[values.index(max(values))])
