def solution(new_id):
    lower_id = list(new_id.lower())
    new_id = []
    for char in lower_id:
        if not (char.isdigit() or char.isalpha() or char in "-_."):
            continue
        if (not new_id) or (not (new_id[-1] == '.' and char == '.')):
            new_id.append(char)

    if new_id and new_id[-1] == '.':
        new_id = new_id[:-1]
    if new_id and new_id[0] == '.':
        new_id = new_id[1:]
    if not new_id:
        new_id.append('a')
    new_id = new_id[:15]
    if new_id and new_id[-1] == '.':
        new_id = new_id[:-1]

    while len(new_id) <= 2:
        new_id.append(new_id[-1])
    return ''.join(new_id)