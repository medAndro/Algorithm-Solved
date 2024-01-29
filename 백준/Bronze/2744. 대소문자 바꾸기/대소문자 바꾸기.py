words = input()

for w in words:
    if w.isupper():
        print(w.lower(), end="")
    else:
        print(w.upper(), end="")
