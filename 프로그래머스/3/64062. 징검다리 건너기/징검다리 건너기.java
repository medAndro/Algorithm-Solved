//세그먼트 트리를 이용한 풀이

class Solution {
	final int MAX_STONE = 200_000;
	int[] stones;
	int N;
	int k;

	int tree[];

	public int solution(int[] stones, int k) {
		this.stones = stones;
		this.N = stones.length;
		this.k = k;

		this.tree = new int[N * 4];
		build(1, 0, N - 1);
		int answer = Integer.MAX_VALUE;

		for (int i = 0; i + k <= N; i++) {
			answer = Math.min(answer, maxRange(1, 0, N - 1, i, i + k - 1));
		}
		
		return answer;

	}

	void build(int node, int start, int end) {
		if (start == end) {
			tree[node] = stones[start];
			return;
		}
		int mid = (start + end) / 2;

		build(node * 2, start, mid);
		build(node * 2 + 1, mid + 1, end);

		tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
	}

	// left, right는 요청 구간, start, end는 탐색중인 구간
	int maxRange(int node, int start, int end, int left, int right) {
		// 전혀 겹치지 않는 경우
		if (end < left || right < start) {
			return Integer.MIN_VALUE;
		}

		// 요청 구간이 탐색중인 구간 내에 완전히 포함되는 경우
		if (left <= start && end <= right) {
			return tree[node];
		}

		// 일부만 겹치는 경우;
		int mid = (start + end) / 2;
		return Math.max(maxRange(node * 2, start, mid, left, right), maxRange(node * 2 + 1, mid + 1, end, left, right));

	}
}