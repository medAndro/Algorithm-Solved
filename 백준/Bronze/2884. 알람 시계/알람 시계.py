import datetime
h, m = map(int, input().split())
ans=datetime.timedelta(hours=h, minutes=m) - datetime.timedelta(minutes=45)
print((ans.seconds//60)//60, (ans.seconds%(60*60))//60)