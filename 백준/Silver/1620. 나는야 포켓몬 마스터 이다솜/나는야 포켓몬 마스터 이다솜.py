import sys
import bisect
N, M = map(int, input().split())
P = [sys.stdin.readline().strip() for _ in range(N)]
Q = [sys.stdin.readline().strip() for _ in range(M)]
Pdict = dict(zip(P, range(1,N+2)))
Pdict = dict(sorted(Pdict.items()))
sortedPokemon = list(Pdict.keys())
numPokemon = list(Pdict.values())
for i in Q:
    try:
        sys.stdout.writelines(P[int(i) - 1] + "\n")
    except:
        pokemonIdx = bisect.bisect_left(sortedPokemon, i)
        sys.stdout.writelines(str(numPokemon[pokemonIdx]) + "\n")
