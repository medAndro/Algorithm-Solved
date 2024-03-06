import sys
T = int(sys.stdin.readline())
answer = [0]*1000000
tc = sys.stdin.readlines()
for i, t in enumerate(tc):
    answer[i] = sum(map(int, t.strip().split()))
print("\n".join(map(str,answer[:T])))
