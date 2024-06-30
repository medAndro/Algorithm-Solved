s = 0
for _ in range(5):
    i = int(input())
    s += i if i >= 40 else 40
print(round(s/5))