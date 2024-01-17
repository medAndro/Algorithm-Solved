import sys

class node:
    def __init__(self, data, left, right):
        self.data = data
        self.left = left
        self.right = right

N = int(sys.stdin.readline())

def pre(node):
    print(node.data, end="")
    if node.left:
        pre(tree[node.left])
    if node.right:
        pre(tree[node.right])
def ino(node):
    if node.left:
        ino(tree[node.left])
    print(node.data, end="")
    if node.right:
        ino(tree[node.right])
def pos(node):
    if node.left:
        pos(tree[node.left])
    if node.right:
        pos(tree[node.right])
    print(node.data, end="")
tree = {}

for i in range(N):
    d, l, r = sys.stdin.readline().split()
    if l == ".":
        l = None
    if r == ".":
        r = None
    tree[d] = node(d, l, r)

pre(tree["A"])
print()
ino(tree["A"])
print()
pos(tree["A"])