import sys
class node():
    def __init__(self):
        self.isLast = False
        self.nums = dict()

class trie():
    def __init__(self):
        self.root = node()
    def insertNum(self, tel):
        curNode = self.root
        for t in tel:
            if t in curNode.nums.keys():
                curNode = curNode.nums[t]
                if curNode.isLast:
                    return False
            else:
                curNode.nums[t] = node()
                curNode = curNode.nums[t]
        curNode.isLast = True
        return True

for _ in range(int(input())):
    t = trie()
    flag = True
    inputArr = []
    for _ in range(int(input())):
        inputArr.append(sys.stdin.readline().strip())
    inputArr.sort()
    for i in inputArr:
        if flag == False:
            t.insertNum(i)
        else:
            flag = t.insertNum(i)
    if flag:
        print("YES")
    else:
        print("NO")
