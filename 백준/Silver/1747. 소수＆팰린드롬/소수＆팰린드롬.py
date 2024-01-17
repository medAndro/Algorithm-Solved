N = int(input())
def prime(num):
    if num > 1:
        if num == 2:
            return True
        for i in range(2, int(num/2)+1):
            if num % i == 0:
                return False
        return True
    else:
        return False

while True:
    if str(N) == str(N)[::-1]:
        if prime(N):
            print(N)
            break
    N+=1
