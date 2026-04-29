import sys

sys.setrecursionlimit(10 ** 6)


def book(room_dict, want_no, k):
    if want_no in room_dict:
        booked_room = book(room_dict, room_dict[want_no], k)
        room_dict[want_no] = booked_room + 1
        return booked_room
    else:
        room_dict[want_no] = want_no + 1
        return want_no


def solution(k, room_number):
    room_dict = dict()
    answer = [0] * len(room_number)
    for idx, want_no in enumerate(room_number):
        answer[idx] = book(room_dict, want_no, k)

    return answer
