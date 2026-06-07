def solution(citations):
    citations.sort(reverse=True)
    h_index = len(citations)
    while h_index > 0:
        if citations[h_index-1] >= h_index:
            break
        h_index -= 1
    return h_index