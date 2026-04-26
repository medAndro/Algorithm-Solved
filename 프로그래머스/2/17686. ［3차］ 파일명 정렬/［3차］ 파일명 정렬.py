import re


def solution(files):
    files_for_sort = []
    pattern = re.compile(r'(\D+)(\d{1,5})')
    for file in files:
        group = re.match(pattern, file)
        head = group[1]
        number = group[2]
        files_for_sort.append([file, head.lower(), int(number)])

    files_for_sort.sort(key=lambda x: (x[1], x[2]))
    answer = []
    for file in files_for_sort:
        answer.append(file[0])
    return answer
