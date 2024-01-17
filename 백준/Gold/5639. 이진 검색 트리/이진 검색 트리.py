import sys
sys.setrecursionlimit(10 ** 6) #재귀오류 해결
class node:
    def __init__(self, data, left, right):
        self.data = data
        self.left = left
        self.right = right

def find_node(root, num):
    current = root
    while True:
        if current.data > num: #값보다 루트가 크면 (왼쪽에 삽입)
            if current.left: #루트노드의 왼쪽에 노드가 이미 있다면
                current = current.left
            else:
                current.left = node(num, None, None) #없다면 노드를 넣고 끝내기
                break
        elif current.data < num: #값보다 루트가 작으면 (오른쪽에 삽입)
            if current.right:
                current = current.right
            else:
                current.right = node(num, None, None)
                break

def post_print(node):
    if node.left:
        post_print(node.left)
    if node.right:
        post_print(node.right)
    print(node.data)

root = None
while True:
    try:
        num = int(sys.stdin.readline())
        if not root:
            root = node(num, None, None)
        else:
            find_node(root, num)
    except:
        break

post_print(root)