import java.util.ArrayDeque;

class Solution {
	static int N, K;
	static int[] prev, next;
	// K, prev[K], next[K]
	static ArrayDeque<int[]> stack = new ArrayDeque<>();

	public String solution(int n, int k, String[] cmd) {
		N = n;
		K = k;
		prev = new int[N];
		next = new int[N];
		boolean[] result = new boolean[N];

		for (int i = 0; i < N; i++) {
			prev[i] = i - 1;
			next[i] = i + 1;
		}
		next[N - 1] = -1;

		for (String c : cmd) {
			char type = c.charAt(0);
			switch (type) {
			case 'U':
				int uNum = Integer.parseInt(c.substring(2));
				for (int i = 0; i < uNum; i++) {
					K = prev[K];
				}
				break;
			case 'D':
				int dNum = Integer.parseInt(c.substring(2));
				for (int i = 0; i < dNum; i++) {
					K = next[K];
				}
				break;
			case 'C':
				stack.offer(new int[] { K, prev[K], next[K] });
				if (next[K] == -1) {
					// 가장 마지막 행
					next[prev[K]] = -1;
					K = prev[K];
				} else if (prev[K] == -1) {
					prev[next[K]] = prev[K];
					K = next[K];
				} else {
					next[prev[K]] = next[K];
					prev[next[K]] = prev[K];
					K = next[K];
				}
				break;
			case 'Z':
				int[] p = stack.pollLast();
				if (p[1] != -1)
					next[p[1]] = p[0];
				if (p[2] != -1)
					prev[p[2]] = p[0];
				break;
			}
		}
		int nK = prev[K] == -1 ? K : prev[K];
		while (true) {

			nK = next[nK];

			if (nK != -1) {
				result[nK] = true;
			} else {
				break;
			}
		}
		int pK = next[K] == -1 ? K : next[K];
		while (true) {
			pK = prev[pK];
			if (pK != -1) {
				result[pK] = true;
			} else {
				break;
			}
		}

		StringBuilder sb = new StringBuilder();

		for (boolean r : result) {
			if (r) {
				sb.append("O");
			} else {
				sb.append("X");
			}
		}
		return sb.toString();
	}
}