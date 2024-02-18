import sys
M = int(input())
S = set()

for _ in range(M):
    cmd = sys.stdin.readline().strip()
    if cmd.find(' ') > -1:
        cmd, val = cmd.split()
        val = int(val)
        if cmd == "add":
            S.add(val)
        elif cmd == "remove":
            if val in S:
                S.remove(val)
        elif cmd == "check":
            if val in S:
                sys.stdout.writelines("1\n")
            else:
                sys.stdout.writelines("0\n")
        elif cmd == "toggle":
            if val in S:
                S.remove(val)
            else:
                S.add(val)
    else:
        if cmd == "all":
            S = set([x for x in range(1,21)])
        elif cmd == "empty":
            S.clear()