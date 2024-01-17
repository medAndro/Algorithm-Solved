N = int(input())
def factorial(N, answer=1):
    if N != 0:
        factorial(N-1, answer *N)
    else:
        print(answer)
factorial(N)