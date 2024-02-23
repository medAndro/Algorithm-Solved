from collections import defaultdict
import sys
N = int(input())
accounts = defaultdict(list)

for _ in range(N):
    age, name = sys.stdin.readline().strip().split()
    accounts[int(age)].append(name)
for age in list(sorted(list(accounts.keys()))):
    for name in list(accounts.get(age)):
        sys.stdout.writelines(str(age)+" "+name+"\n")
