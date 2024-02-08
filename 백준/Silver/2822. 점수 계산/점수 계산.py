quiz = []
for _ in range(8):
    quiz.append(int(input()))
answer = []
for q in list(sorted(quiz))[3:9]:
    answer.append(quiz.index(q)+1)
print(sum(list(sorted(quiz))[3:9]))
print(" ".join(map(str, sorted(answer))))