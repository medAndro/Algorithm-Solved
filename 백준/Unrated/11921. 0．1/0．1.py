import sys
sys.stdin.readline()
answer = 0
for _ in range(5):
    answer+=int(sys.stdin.readline())
sys.stdout.write("5"+'\n')
sys.stdout.write(str(answer))