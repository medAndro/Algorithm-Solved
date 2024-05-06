N = int(input())
answer = 0
def notHas3to9(number):
    while number != 0:
        digit = number % 10
        if digit >= 3 and digit <= 9:
            return False
        number //= 10
    return True
for i in range(int('1' + '0' * (N - 1)), int('2' * N) + 1):
    if i % 3 == 0:
        if notHas3to9(i):
            answer += 1
print(answer)