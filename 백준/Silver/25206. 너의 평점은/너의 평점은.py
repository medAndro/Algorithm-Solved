answer = []
sumOfGrade = 0
G = dict(zip(("A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F"), (4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0)))
for _ in range(20):
    _, val, grade = input().split()
    if grade != "P":
        answer.append(float(val) * G[grade])
        sumOfGrade += float(val)

print(sum(answer)/sumOfGrade)
