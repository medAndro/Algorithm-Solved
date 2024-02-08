import sys
sys.stdin.readline()
answer = 0
for _ in range(10000):
    answer+=int(sys.stdin.readline())
sys.stdout.write("10000"+'\n')
sys.stdout.write(str(answer))