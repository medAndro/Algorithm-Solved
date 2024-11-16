N = int(input())
tShirts = list(map(int, input().split()))
T, P = map(int, input().split())

tShirtsBundleCount = 0

for count in tShirts:
    tShirtsBundleCount += count // T
    tShirtsBundleCount += 1 if count % T != 0 else 0

pensBundleCount = sum(tShirts) // P
penRemainCount = sum(tShirts) % P

print(tShirtsBundleCount)
print(pensBundleCount, penRemainCount)