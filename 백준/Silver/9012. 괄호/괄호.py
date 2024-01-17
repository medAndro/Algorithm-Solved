N = int(input())
for i in range(N):
    cmd = input()
    while True:
        cmd = ''.join(cmd.split("()"))
        if len(cmd):
            if cmd.find("()") == -1:
                print("NO")
                break
        else:
            print("YES")
            break