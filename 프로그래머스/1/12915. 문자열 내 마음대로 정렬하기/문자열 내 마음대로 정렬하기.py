def solution(citations, n):
    citations.sort(key=lambda x: (x[n], x))
    return citations