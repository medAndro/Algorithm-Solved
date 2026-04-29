def find(data, cur_word, step):
    # 종료 조건: 단어의 최대 길이는 5이므로 step이 6이 되면 중단
    if step == 6:
        return

    # 빈 문자열이 아닌 경우에만 사전에 단어 추가
    if cur_word != '':
        data.append(cur_word)

    # 모음 순서대로 문자열을 확장하며 재귀 호출 (사전 순서 보장)
    for c in ['A', 'E', 'I', 'O', 'U']:
        find(data, ''.join([cur_word, c]), step + 1)


def solution(word):
    data = []
    # 빈 문자열에서 시작하여 사전 생성
    find(data, '', 0)

    # 리스트에서 목표 단어의 인덱스를 찾아 1을 더해 반환
    return data.index(word) + 1
