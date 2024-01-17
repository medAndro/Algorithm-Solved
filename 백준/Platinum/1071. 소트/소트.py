N = int(input())
arr = sorted(list(map(int, input().split())))
if N == 1:
    print(arr[0])
else:
    answer = [arr[0]]
    del arr[0]
    i = 0
    while True:
        stack=0
        for a in range(len(arr)):
            if answer[-1]+1 == arr[a]:
                stack+=1
            else:
                answer.append(arr[a])
                del arr[a]
                break
        if len(arr) == stack:
            break
    try:
        flag = True
        if answer[-1]+1 != arr[0]:
            answer = answer+arr
            flag = False
        else:
            for i in range(len(answer)-2,-1,-1):
                if answer[i]+1 != arr[0] and arr[0]+1 != answer[i+1]:
                    answer = answer[0:i+1]+arr+answer[i+1:]
                    flag = False
                    break
        if flag:
            answer = arr+answer
    except:
        None

    print(' '.join(map(str,answer)))

