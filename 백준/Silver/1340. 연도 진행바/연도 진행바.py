import datetime

mDict = dict(
    zip(['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November',
         'December'], list(range(1, 13))))
month, day, year, hh, mm = input().replace(',', '').replace(':', ' ').split()

month = mDict[month]
day = int(day)
year = int(year)
hh = int(hh)
mm = int(mm)

d = datetime.datetime(year=year, month=month, day=day, hour=hh, minute=mm)

start = datetime.datetime(year=year, month=1, day=1, hour=0, minute=0)
end = datetime.datetime(year=year+1, month=1, day=1, hour=0, minute=0)

print((d-start)/(end-start)*100)