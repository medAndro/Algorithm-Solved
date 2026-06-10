def solution(numbers):
    numbers = list(map(str, numbers))
    temp = []
    for i, number in enumerate(numbers):
        temp.append(((number * 4)[:4], numbers[i]))
    temp.sort(key=lambda x: x[0], reverse=True)
    answer = []
    for number in temp:
        answer.append(number[1])
        
    result = ''.join(answer)
    if result[0] == '0':
        return '0'

    return result