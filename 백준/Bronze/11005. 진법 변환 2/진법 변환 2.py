from string import ascii_uppercase

num36 = list(range(0, 10)) + list(ascii_uppercase)
N, B = map(int, input().split())
answer = []
while N > 0:
    answer.append(num36[N % B])
    N //= B

answer.reverse()
print("".join(map(str, answer)))
