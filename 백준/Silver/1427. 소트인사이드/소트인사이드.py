num = list(map(int, str(input())))
num.sort(reverse=True)
print("".join(map(str, num)))