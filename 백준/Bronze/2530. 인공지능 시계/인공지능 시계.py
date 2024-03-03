import datetime
hh, mm, ss = map(int, input().split())
plusSec = int(input())
answer = datetime.timedelta(hours=hh, minutes=mm, seconds=ss) + datetime.timedelta(seconds=plusSec)
print(answer.seconds // 3600, (answer.seconds // 60) % 60, answer.seconds % 60)