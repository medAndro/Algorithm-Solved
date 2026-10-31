import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	static int n;
	static int[] ans;
	static int[][] dice;
	static int maxWin;

	public int[] solution(int[][] dice) {
		n = dice.length;
		this.dice = dice;
		maxWin = -1;
		ans = new int[n / 2];

		boolean[] selected = new boolean[n];
		dfs(selected, 0, 0);
		for (int i = 0; i < n / 2; i++) {
			ans[i] += 1;
		}
		return ans;
	}

	public void dfs(boolean[] selected, int depth, int cnt) {
		if (cnt >= n / 2) {
			// 기저조건, selected가 1인것들의 주사위 조합을 구하기
			int[] a = new int[n / 2];
			int[] b = new int[n / 2];
			int ai = 0;
			int bi = 0;
			for (int i = 0; i < n; i++) {
				if (selected[i]) {
					a[ai++] = i;
				} else {
					b[bi++] = i;
				}
			}

			List<Integer> aSum = new ArrayList<>();
			dfsSum(a, 0, 0, aSum);

			List<Integer> bSum = new ArrayList<>();
			dfsSum(b, 0, 0, bSum);
			bSum.sort(Integer::compare);

			int win = 0;

			// 이분탐색으로 a가 이기는 경우의 수 구하기
			for (int aNum : aSum) {
				int left = 0;
				int right = bSum.size();

				while (left < right) {
					int mid = (right + left) / 2;

					if (bSum.get(mid) < aNum) {
						left = mid + 1;
					} else {
						right = mid;
					}
				}

				// a가 이기는 경우의수는 left
				win += left;
			}

			if (maxWin < win) {
				ans = a.clone();
				maxWin = win;
			}

			return;
		}
		if (depth >= n) {
			return;
		}
		selected[depth] = true;
		dfs(selected, depth + 1, cnt + 1);
		selected[depth] = false;
		dfs(selected, depth + 1, cnt);
	}

	public void dfsSum(int[] selected, int depth, int sum, List<Integer> result) {
		if (depth == selected.length) {
			result.add(sum);
			return;
		}

		for (int j = 0; j < 6; j++) {
			dfsSum(selected, depth + 1, sum + dice[selected[depth]][j], result);
		}
	}
}