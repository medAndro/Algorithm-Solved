n = int(input())

def s(n, idx):
    strs = [' '] * n
    strs[n - idx - 1] = '*'
    return "".join(strs)

for i in range(n):
    print(f"{' ' * n}{s(n, i)} {s(n, i)} {s(n, i)[::-1]}")
for i in range(n):
    print(f"{s(n, i)}{' ' * n} {s(n, i)[::-1]} {s(n, i)}")
