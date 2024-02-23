N = int(input())
exam = list(map(int,input().split()))
M = max(exam)
newExam = []
for r in exam:
    newExam.append(r / M * 100)
print(sum(newExam)/len(exam))