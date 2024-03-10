N = int(input())
answer = 0
for _ in range(N):
    i = input()
    if i.find("01") != -1 or i.find("OI") != -1:
        answer+=1
print(answer)