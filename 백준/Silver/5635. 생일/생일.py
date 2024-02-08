import datetime
n = int(input())
names = {}
for _ in range(n):
    name, day, month, year = input().split()
    names[datetime.date(int(year),int(month),int(day))] = name
print(names.get(max(names.keys())))
print(names.get(min(names.keys())))