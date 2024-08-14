from collections import deque

def solution(bridge_length, weight, truck_weights):
    answer = 0
    bridge = deque([0]*bridge_length)
    tw = deque(truck_weights)
    sumBridge = 0
    completed = 0
    while completed < len(truck_weights):
        answer += 1
        if tw and (tw[0]+sumBridge-bridge[-1]) <= weight:
            tp = tw.popleft()
            bridge.appendleft(tp)
            sumBridge+=tp
        else:
            bridge.appendleft(0)
        bp = bridge.pop()
        if bp != 0:
            completed += 1
            sumBridge-=bp

    return answer