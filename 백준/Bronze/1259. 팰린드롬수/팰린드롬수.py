import sys
while True:
    num = sys.stdin.readline().strip()
    if num == '0':
        break
    else:
        if num[-1::-1] == num:
            sys.stdout.writelines("yes\n")
        else:
            sys.stdout.writelines("no\n")