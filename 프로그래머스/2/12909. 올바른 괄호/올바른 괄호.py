def solution(s):
    chkLeft = 0
    answer = True
    for i in s:
        if i == '(':
            chkLeft += 1
        elif chkLeft > 0 and i == ')':
            chkLeft -= 1
        else:
            answer = False
            break
    if chkLeft > 0:
        answer = False
    return answer