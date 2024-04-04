import itertools

dwarf = [int(input()) for _ in range(9)]
for l in list(itertools.combinations(dwarf, r=7)):
    if sum(l) == 100:
        print('\n'.join(map(str, sorted(l))))
        break
