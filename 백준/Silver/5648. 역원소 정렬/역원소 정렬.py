import sys
arr = " ".join(sys.stdin.read().split('\n')).split()
answer = [0]*int(arr[0])
for i in range(int(arr[0])):
    answer[i] = int(arr[i+1][::-1])
answer.sort()
print("\n".join(map(str, answer)))