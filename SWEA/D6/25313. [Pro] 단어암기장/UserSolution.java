import java.util.LinkedList;

class UserSolution {
	int row;
	int col;

	Node tree[];

	boolean[] isWroteById;
	int[] rowIdxById;

	public void init(int N, int M) {
		row = N;
		col = M;
		tree = new Node[row * 4];
		rowIdxById = new int[55001];
		isWroteById = new boolean[55001];

		initTree(1, 0, row - 1);

	}

	// start, end는 행 범위
	void initTree(int node, int start, int end) {
		if (start == end) {
			// 리프노드
			tree[node] = new Node(true);
			return;
		}
		int mid = (start + end) / 2;

		initTree(node * 2, start, mid);
		initTree(node * 2 + 1, mid + 1, end);

		tree[node] = new Node(false);
	}

	public int writeWord(int mId, int mLen) {
		if (tree[1].getWritableSize() < mLen) {
			return -1;
		} else {
			int val = write(mId, mLen, 1, 0, row - 1);
			return val;
		}
	}

	int write(int mId, int mLen, int node, int start, int end) {
		if (start == end) {
			// 리프노드
			tree[node].addBlock(new Entity(mLen, mId));
			rowIdxById[mId] = start;
			isWroteById[mId] = true;
			return start;
		}
		int mid = (start + end) / 2;

		int rowVal = 0;
		if (tree[node * 2].getWritableSize() >= mLen) {
			rowVal = write(mId, mLen, node * 2, start, mid);
		} else {
			rowVal = write(mId, mLen, node * 2 + 1, mid + 1, end);
		}

		tree[node].writeAbleSize = Math.max(tree[node * 2].getWritableSize(), tree[node * 2 + 1].getWritableSize());

		return rowVal;
	}

	public int eraseWord(int mId) {
		if (isWroteById[mId]) {
			int targetRowIdx = rowIdxById[mId];
			erase(1, mId, targetRowIdx, 0, row - 1);
			return targetRowIdx;
		} else {
			return -1;
		}
	}

	void erase(int node, int bId, int targetRowIdx, int start, int end) {
		if (start == end) {
			// 리프노드
			tree[node].rmoveBlock(bId);
			isWroteById[bId] = false;
			rowIdxById[bId] = -1;
			return;
		}
		int mid = (start + end) / 2;

		if (targetRowIdx <= mid) {
			erase(node * 2, bId, targetRowIdx, start, mid);
		} else {
			erase(node * 2 + 1, bId, targetRowIdx, mid + 1, end);
		}

		tree[node].writeAbleSize = Math.max(tree[node * 2].getWritableSize(), tree[node * 2 + 1].getWritableSize());
		return;
	}

	// inner 클래스들

	class Node {
		LinkedList<Entity> entitys;
		boolean isLeaf;
		int writeAbleSize;

		public Node(boolean isLeaf) {
			this.isLeaf = isLeaf;
			this.writeAbleSize = col;

			if (isLeaf) {
				entitys = new LinkedList<>();
				entitys.add(new Entity(col));
			}
		}

		int getWritableSize() {
			if (isLeaf) {
				int maxEmpty = 0;
				for (Entity e : entitys) {
					if (e.isEmpty()) {
						maxEmpty = Math.max(maxEmpty, e.size);
					}
				}
				return maxEmpty;
			} else {
				return writeAbleSize;
			}
		}

		void addBlock(Entity b) {
			if (isLeaf) {
				int idx = 0;
				for (Entity e : entitys) {
					if (e.isEmpty() && e.size >= b.size) {
						entitys.add(idx, b);
						if (e.size == b.size) {
							entitys.remove(idx + 1);
						} else {
							e.size -= b.size;
						}
						break;
					} else {
						idx++;
					}
				}
				return;
			}
		}

		void rmoveBlock(int bId) {
			if (isLeaf) {
				int idx = 0;
				for (Entity e : entitys) {
					if (e.id == bId) {
						int emptyVal = 0;
						Entity left = null;
						Entity right = null;
						if (idx - 1 >= 0) {
							left = entitys.get(idx - 1);
						}

						if (idx + 1 < entitys.size()) {
							right = entitys.get(idx + 1);
						}

						if (left != null && left.isEmpty()) {
							emptyVal += left.size;
							entitys.remove(left);
						}

						if (right != null && right.isEmpty()) {
							emptyVal += right.size;
							entitys.remove(right);
						}

						e.id = EMPTY_ID;
						e.size += emptyVal;
						break;
					} else {
						idx++;
					}
				}
			}
		}

	}

	// 블록 또는 빈공간
	static final int EMPTY_ID = -1;

	class Entity {
		int size;
		int id;

		boolean isEmpty() {
			return id == EMPTY_ID;
		}

		public Entity(int size) {
			this.size = size;
			this.id = EMPTY_ID;
		}

		public Entity(int size, int id) {
			this.size = size;
			this.id = id;
		}

		@Override
		public String toString() {
			return "Entity [size=" + size + ", id=" + id + "]";
		}

	}

}
