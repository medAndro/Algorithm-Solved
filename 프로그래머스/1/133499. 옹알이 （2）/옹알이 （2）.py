import re

def solution(babbling):
    answer = 0
    # 조카가 발음할 수 있는 단어들이 1번 이상 반복되는지 확인하는 패턴
    pattern1 = re.compile(r"(aya|ye|woo|ma)+")
    # 연속된 동일 발음이 존재하는지 확인하는 패턴
    pattern2 = re.compile(r"(aya|ye|woo|ma)\1")
    
    for b in babbling:
        # 문자열 전체가 유효한 단어들로만 구성되어 있는지 확인
        if re.fullmatch(pattern1, b):
            # 문자열 내 어디든 연속된 발음이 포함되어 있지 않은지 확인
            if not re.search(pattern2, b):
                answer += 1
                
    return answer