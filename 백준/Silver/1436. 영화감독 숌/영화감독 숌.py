n = int(input())
answer=0
i=665
while True:
    i+=1
    if '666' in str(i):
        answer+=1
    if answer == n:
        print(i)
        break